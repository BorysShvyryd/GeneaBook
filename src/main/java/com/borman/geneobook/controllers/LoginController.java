package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.repository.RandomDataRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final RandomDataRepositories randomDataRepositories;

    public LoginController(RandomDataRepositories randomDataRepositories) {
        this.randomDataRepositories = randomDataRepositories;
    }

    @GetMapping
    public String loginForm(Model model){
//                            @CookieValue(name = "Name", value = "Value", required = false) Session.Cookie cookie) {
//        if (rCookie != null) {
//        }
//        model.addAttribute("loginUser", new LoginUser());
        LoginUser loginUser = new LoginUser();

        model.addAttribute("loginUser", loginUser);

        return "login/user-login";
    }

    @GetMapping("/forgot")
    public String forgotPassSend(Model model, @PathVariable String token) {

        model.addAttribute("sendForgotPass", true);

        return "register/login-error";
    }

    @GetMapping("/forgot/{token}")
    public String forgotPassForm(Model model, @PathVariable String token) {

        if (token == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("validate", true);
        }

        return "register/forgot-pass-form";
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

        return "register/forgot-pass-form";
    }

}
