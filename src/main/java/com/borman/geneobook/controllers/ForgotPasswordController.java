package com.borman.geneobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping(value = "/forgot")
public class ForgotPasswordController {

    @GetMapping("/{token}")
    public String forgotPassForm(Model model, @PathVariable String token) {

        if (token == null) {
            model.addAttribute("validate", false);
        } else {
            model.addAttribute("validate", true);
        }

        return "forgot-pass-form";
    }

    @GetMapping
    public String forgotPassSubmit(Model model) {

        boolean validate = Boolean.parseBoolean((String) model.getAttribute("validate"));

        if (validate) {
            String email = (String) model.getAttribute("email");

//            String token = Random("token");

        } else {
            model.addAttribute("message", "Email does not exist");
        }

        return "forgot-pass-form";
    }
}
