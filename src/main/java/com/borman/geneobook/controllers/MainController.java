package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.UserProfile;
import com.borman.geneobook.repository.UserProfileRepository;
import com.borman.geneobook.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
//@Secured("ROLE_USER")
@RequestMapping("/geneo")
public class MainController {

//    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    public MainController(UserProfileRepository userProfileRepository) {
//        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping("")
    public String homePage() {
        return "/geneo/main-page";
    }

    @GetMapping("/profile")
    public String userProfileForm(Model model, Principal principal, UserProfile userProfile) {

//        User user = userRepository.findByUsername(principal.getName()).get();
//        System.out.println(user.getNicName());

        userProfile = userProfileRepository.findByUser_Email(principal.getName()).orElse(new UserProfile());
//        userProfile.setRegistered(LocalDateTime.now());
//        userProfile

        return "/registration/user-profile-form";
    }

    @PostMapping("/profile")
    public String userProfileFormSubmit(Model model, UserProfile userProfile, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/registration/user-profile-form";
        }
        userProfileRepository.save(userProfile);

        return "/registration/user-profile-form";
    }

}
