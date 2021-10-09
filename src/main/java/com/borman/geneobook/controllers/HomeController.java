package com.borman.geneobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class HomeController {

    @GetMapping("/")
    public String indexPage(Model model) {

//        Locale uk = new Locale("uk", "UA");
//        Locale.setDefault(uk);
//        current = Locale.getDefault();
//        System.out.println(current);

        return "index";
    }

}
