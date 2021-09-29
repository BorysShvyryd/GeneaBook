package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.pojo.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

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

}
