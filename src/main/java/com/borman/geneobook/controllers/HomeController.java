package com.borman.geneobook.controllers;

import com.borman.geneobook.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage(Model model) {

        if (userService.allUsers().size() == 0) {
            System.out.println("First connection");
            // add record ROLE
            // add record ...
        }

//        Locale uk = new Locale("uk", "UA");
//        Locale.setDefault(uk);
//        current = Locale.getDefault();
//        System.out.println(current);

        return "index";
    }

}
