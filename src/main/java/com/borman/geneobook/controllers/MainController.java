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

import javax.validation.Valid;
import java.security.Principal;

@Controller
//@Secured("ROLE_USER")
@RequestMapping("/geneo")
public class MainController {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    public MainController(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping("")
    public String homePage() {
        return "/geneo/main-page";
    }

    @GetMapping("/profile")
    public String userProfileForm(Model model, Principal principal) {

        UserProfile userProfile = userProfileRepository.findByUser_Email(principal.getName()).orElse(new UserProfile());
        model.addAttribute("userProfile", userProfile);

        return "/registration/user-profile-form";
    }

    @PostMapping("/profile")
    public String userProfileFormSubmit(@Valid UserProfile userProfile, BindingResult bindingResult, Principal principal) {

        if (bindingResult.hasErrors()) {
            return "/registration/user-profile-form";
        }

        User user = userRepository.findByUsername(principal.getName()).orElse(new User());

        if (userProfile.getId() == null) {
            userProfile.setUser(user);
            user.setUserProfile(userProfile);
            userProfileRepository.save(userProfile);
            userRepository.save(user);
        } else {
            userProfileRepository.save(userProfile);
        }

        return "/geneo/main-page";
    }

    @GetMapping("/family")
    public String familyProfileForm(Model model, Principal principal) {

//        UserProfile userProfile = new UserProfile();
//        model.addAttribute("userProfile", userProfile);

        return "/geneo/family-form";
    }
}
