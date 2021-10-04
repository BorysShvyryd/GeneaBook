package com.borman.geneobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/geneo")
public class MainController {

    @GetMapping("/")
    public String homePage() {
        System.out.println("geneo");
        return "/geneo/main-page";
    }

    @GetMapping("/profile")
    public String userProfileForm() {
        return "/registration/user-profile-form";
    }

}
