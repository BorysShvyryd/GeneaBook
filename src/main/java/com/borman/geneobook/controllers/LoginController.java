package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.service.EmailService;
import com.borman.geneobook.repository.RandomDataRepositories;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/login")
@SessionAttributes({"email"})
public class LoginController {

    private final RandomDataRepositories randomDataRepositories;
    private final EmailService emailService;


    public LoginController(RandomDataRepositories randomDataRepositories, EmailService emailService) {
        this.randomDataRepositories = randomDataRepositories;
        this.emailService = emailService;
    }

    @GetMapping
    public String loginForm(Model model) { //,
//                            @CookieValue(name = "Email", value = "Value", required = false) Session.Cookie cookie) {
//        if (rCookie != null) {
//        }
//        model.addAttribute("loginUser", new LoginUser());
        model.addAttribute("email");

        LoginUser loginUser = new LoginUser();

        model.addAttribute("loginUser", loginUser);

        return "login/user-logging";
    }

    @PostMapping
    public String loginSubmit(Model model) {
//        Collection<? extends Session> usersSessions = this.sessions.findByPrincipalName(principal.getName()).values();
//        model.addAttribute("sessions", usersSessions);

        return "geneo";
    }

    @GetMapping("/forgot")
    public String forgotPassSend(Model model, User user) {

        model.addAttribute("sendForgotPass", true);

        String token = randomDataRepositories.getRandomPass();

//        LoggedUser loggedUser = (LoggedUser) model.getAttribute("loginUser");
        System.out.println(model.getAttribute(user.getEmail()));

//        emailRepository.SendEmail(
//                loginUser.getEmail(),
//                "New password",
//                "Password: " + token);

        return "registration/login-sendEmail";
    }

    @GetMapping("/forgot/resend")
    public String resendPass(Model model, User user) {
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
