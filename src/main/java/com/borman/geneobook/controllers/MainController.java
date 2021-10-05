package com.borman.geneobook.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@Secured("ROLE_USER")
@RequestMapping("/geneo")
public class MainController {

    @GetMapping("")
    public String homePage() {
        return "/geneo/main-page";
    }

    @GetMapping("/profile")
    public String userProfileForm() {
        return "/registration/user-profile-form";
    }

}
