package com.borman.geneobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

//    public String userHomePage() {
//        return "home-page";
//    }

    @GetMapping(value = {"/"})
    public String index() {
        return "/index";
    }

//    @GetMapping("/admin")
//    public String admin() {
//        return "/admin";
//    }

    @GetMapping("/geneo")
    public String user() {
        return "/geneo";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "/login";
//    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
