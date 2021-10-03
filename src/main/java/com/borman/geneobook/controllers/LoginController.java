package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.repository.UserRepository;
import com.borman.geneobook.service.EmailService;
import com.borman.geneobook.repository.RandomDataRepositories;
import com.borman.geneobook.service.UserService;
import com.borman.geneobook.service.UserServiceImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes({"email"})
public class LoginController {

    private final RandomDataRepositories randomDataRepositories;
    private final EmailService emailService;
    private final UserRepository userRepository;
    private final UserService userService;


    public LoginController(RandomDataRepositories randomDataRepositories, EmailService emailService, UserRepository userRepository, UserService userService) {
        this.randomDataRepositories = randomDataRepositories;
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public String loginForm() { //,
//                            @CookieValue(name = "Email", value = "Value", required = false) Session.Cookie cookie) {
//        if (rCookie != null) {
//        }
//        model.addAttribute("loginUser", new LoginUser());

//        model.addAttribute("email");
//
//        LoginUser loginUser = new LoginUser();
//
//        model.addAttribute("loginUser", loginUser);

        return "login/user-logging";
    }

//    @PostMapping
//    public String loginSubmit(Model model) {
////        Collection<? extends Session> usersSessions = this.sessions.findByPrincipalName(principal.getName()).values();
////        model.addAttribute("sessions", usersSessions);
////        model.addAttribute("errorLogIn", true);
//        String email = "bormanpgg@gmail.com";
//        String password = "12345678";
//        System.out.println(email + password);
////        if (userRepository.findByUserEmail(email) == null) {
////            model.addAttribute("login.noUser", true);
//////            throw new UsernameNotFoundException(String.format("Invalid credentials", authentication.getPrincipal()));
////        }
////        if(!userRepository.findByUserEmail(email).getPassword().equals(userRepository.(password)){
////            throw new BadCredentialsException("Invalid password");
////        }
//
//        return "geneo";
//    }

    @GetMapping("/forgot")
    public String forgotPassSend(Model model, LoginUser user) {

        //???
        String email = "bormanpgg@gmail.com";

        User restoreUser = userRepository.findByUsername(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + email)
                );

        if (restoreUser == null) {
            System.out.println("no");
            model.addAttribute("errorLogIn", true);
            model.addAttribute("sendForgotPass", true);
            return "login/user-logging";
        }

//        model.addAttribute("mail", email); ??? Cookie

        String token = randomDataRepositories.getRandomPass();

        emailService.SendEmail(
                restoreUser.getEmail(),
                "New password",
                "Password: " + token);

        return "registration/login-sendEmail";
    }

    @GetMapping("/forgot/resend")
    public String resendPass(Model model, LoginUser user) {
        forgotPassSend(model, user);
        return "registration/login-sendEmail";
    }

    @GetMapping("/forgot/{token}")
    public String forgotPassForm(Model model, @PathVariable String token) {

        if (token == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("validate", true);
        }

        return "registration/forgot-pass-form";
    }

    @PostMapping("/forgot/{token}")
    public String forgotPassSubmit(Model model) {

        boolean validate = Boolean.parseBoolean((String) model.getAttribute("validate"));

        if (validate) {
            String email = (String) model.getAttribute("email");

            String token = randomDataRepositories.getRandomPass();

        } else {
            model.addAttribute("message", "Email does not exist");
        }

        return "registration/forgot-pass-form";
    }

}
