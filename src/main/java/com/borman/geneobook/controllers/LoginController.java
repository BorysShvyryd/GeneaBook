package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.service.EmailService;
import com.borman.geneobook.service.RandomDataService;
import com.borman.geneobook.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/login")
@SessionAttributes({"nic", "email", "token"})
public class LoginController {

    private final RandomDataService randomDataService;
    private final EmailService emailService;
    private final UserService userService;


    public LoginController(RandomDataService randomDataService, EmailService emailService, UserService userService) {
        this.randomDataService = randomDataService;
        this.emailService = emailService;
        this.userService = userService;
    }

    @GetMapping
    public String loginForm() {
        return "login/user-login";
    }

    @GetMapping("/403")
    public String error403() {
        return "login/403";
    }

    @GetMapping("/forgot")
    public String forgotPassForm() {
        return "login/forgot-pass-send-mail";
    }

    @PostMapping("/forgot")
    public String forgotPassSend(@RequestParam("email") String email) {

        System.out.println(email);
        if (userService.findByUserName(email) == null) {
            System.out.println("skjnckjs");
        }
//        User restoreUser = userService.findByUserName(email);
//        System.out.println(restoreUser.toString());
//        if (!restoreUser.getEmail().equals(email)) {
//            return "login/error-user-email";
//        }

//        model.addAttribute("email", email);
        //???????????

//        String token = randomDataService.getRandomPass();
//
//        emailService.SendEmail(
//                restoreUser.getEmail(),
//                "New password",
//                "Password: " + token);
        return "login/forgot-pass-send-mail";

//        return "registration/login-sendEmail";
    }

    @GetMapping("/forgot/resend")
    public String resendPass(Model model, Principal principal) {
//        forgotPassSend(model);
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
