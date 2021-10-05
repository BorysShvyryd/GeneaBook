package com.borman.geneobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String indexPage() {
        return "/index";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/feedback")
    public String feedback() {
        return "/feedback";
    }

}
