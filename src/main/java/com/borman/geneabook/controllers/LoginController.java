package com.borman.geneabook.controllers;

import com.borman.geneabook.entity.User;
import com.borman.geneabook.service.EmailService;
import com.borman.geneabook.service.RandomDataService;
import com.borman.geneabook.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/login")
@SessionAttributes({"token", "email"})
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
    public String forgotPassForm(Model model) {
        model.addAttribute("errorConfirmToken", false);
        return "login/forgot-pass-send-mail";
    }

    @PostMapping("/forgot")
    public String forgotPassSend(@RequestParam("email") String email, Model model, HttpServletRequest request) {

        Optional<User> restoreUser = userService.findByEmail(email);

        if (!restoreUser.isPresent()) {
            model.addAttribute("errorUserEmail", true);
            model.addAttribute("errorToken", false);
            model.addAttribute("nullToken", false);
            model.addAttribute("nonCorrectToken", false);
            return "error";
        }

        String tokenEmail = randomDataService.getToken();

        model.addAttribute("token", tokenEmail);
        model.addAttribute("email", email);

        model.addAttribute("sendEmail",
                emailService.SendEmail(restoreUser.get().getEmail(),
                        "Change password",
                        "To change your password, follow the link: "
                                + request.getHeader("referer")
                                + "/"
                                + tokenEmail)
        );

        model.addAttribute("sendForgotPass", true);
        model.addAttribute("sendEmail", false);

        return "registration/registration-sendEmail";

    }

    @GetMapping("/forgot/resend")
    public String resendPass(Model model, HttpServletRequest request) {

        model.addAttribute("sendEmail",
                emailService.SendEmail((String) model.getAttribute("email"),
                        "Change password",
                        "To change your password, follow the link: "
                                + request.getHeader("referer")
                                + "/"
                                + model.getAttribute("token"))
        );

        model.addAttribute("sendForgotPass", true);
        model.addAttribute("sendEmail", false);

        return "registration/registration-sendEmail";
    }

    @GetMapping("/forgot/{token}")
    public String forgotPassForm(Model model, @PathVariable String token, HttpSession httpSession) {

        if (token == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("errorConfirmToken", true);
            if (!token.equals(httpSession.getAttribute("token"))) {
                return "login/forgot-pass-send-mail";
            }
        }

        model.addAttribute("errorPass", false);
        model.addAttribute("errorConfirmToken", false);

        return "login/forgot-pass-form";
    }

    @PostMapping("/forgot/{token}")
    public String forgotPassSubmit(Model model,
                                   @RequestParam String password,
                                   @RequestParam String conf_password,
                                   HttpSession httpSession) {

        model.addAttribute("errorPass", false);
        model.addAttribute("errorConfirmPass", false);
        model.addAttribute("errorConfirmToken", false);

        if (!password.equals(conf_password)) {
            model.addAttribute("errorConfirmPass", true);
            model.addAttribute("errorPass", false);
            return "login/forgot-pass-form";
        }

        if (password.length() < 8) {
            model.addAttribute("errorConfirmPass", false);
            model.addAttribute("errorPass", true);
            return "login/forgot-pass-form";
        }

        model.addAttribute("token", "");
        Optional<User> userOptional = userService.findByEmail((String) httpSession.getAttribute("email"));
        if (userOptional.isPresent()) {
            userOptional.get().setPassword(password);
            userService.saveUserNewPass(userOptional.get());
        }

        return "redirect:/login";
    }

}
