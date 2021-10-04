package com.borman.geneobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/geneo")
public class MainController {

    @GetMapping("/geneo")
    public String homePage() {
        System.out.println("geneo");
        return "/geneo/home-page";
    }

    @GetMapping("/geneo/profile")
    public String userProfileForm() {
        return "/registration/user-profile-form";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
