package com.borman.geneabook.controllers;

import com.borman.geneabook.entity.User;
import com.borman.geneabook.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;
import java.util.Optional;

@Controller
@SessionAttributes("nickname")
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage(Model model, Principal principal) {

        if (principal != null) {
            Optional<User> userOptional = userService.findByUserName(principal.getName());
            if (userOptional.isPresent()) {
                model.addAttribute("nickname", userOptional.get().getNickname());
            }
        }

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
