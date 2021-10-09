package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.repository.UserRepository;
import com.borman.geneobook.service.EmailService;
import com.borman.geneobook.service.RandomDataService;
import com.borman.geneobook.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes({"userNickname"})
public class LoginController {

    private final RandomDataService randomDataService;
    private final EmailService emailService;
    private final UserRepository userRepository;


    public LoginController(RandomDataService randomDataService, EmailService emailService, UserRepository userRepository) {
        this.randomDataService = randomDataService;
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String loginForm() { //,
//                            @CookieValue(name = "Email", value = "Value", required = false) Session.Cookie cookie) {
//        if (сookie != null) {
//        }
        return "login/user-login";
    }

    @GetMapping("/403")
    public String error403() {
        return "login/403";
    }

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

        String token = randomDataService.getRandomPass();

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

            String token = randomDataService.getRandomPass();

        } else {
            model.addAttribute("message", "Email does not exist");
        }

        return "registration/forgot-pass-form";
    }

}
