package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.UserProfile;
import com.borman.geneobook.repository.RelationshipRepository;
import com.borman.geneobook.repository.FamilyTiesRepository;
import com.borman.geneobook.repository.UserProfileRepository;
import com.borman.geneobook.repository.UserRepository;
import com.borman.geneobook.service.UserProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
//@Secured("ROLE_USER")
@RequestMapping("/genealogy")
public class MainController {

    private final UserRepository userRepository;
    private final UserProfileService userProfileService;
    private final FamilyTiesRepository familyTiesRepository;
    private final RelationshipRepository relationshipRepository;

    public MainController(UserRepository userRepository,
                          UserProfileService userProfileService,
                          FamilyTiesRepository familyTiesRepository,
                          RelationshipRepository relationshipRepository) {
        this.userRepository = userRepository;
        this.userProfileService = userProfileService;
        this.familyTiesRepository = familyTiesRepository;
        this.relationshipRepository = relationshipRepository;
    }

    @GetMapping("")
    public String homePage() {
        return "/genealogy/main-page";
    }

    @GetMapping("/profile")
    public String userProfileForm(Model model, Principal principal) {

        UserProfile userProfile;

        try {
            userProfile = userProfileService.findUserByEmail(principal.getName());
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            userProfile = new UserProfile();
        }

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
            userProfileService.saveUserProfile(userProfile);
            userRepository.save(user);
        } else {
            userProfileService.saveUserProfile(userProfile);
        }

        return "/genealogy/main-page";
    }

//    @GetMapping("/family")
//    public String familyTreePage(Principal principal) {
//
//        UserProfile loggedUserProfile;
//
//        try {
//            loggedUserProfile = userProfileService.findUserByEmail(principal.getName());
//            return "redirect:/genealogy/family/" + loggedUserProfile.getId();
//        } catch (RuntimeException ex) {
//            System.out.println(ex.getMessage());
//            return "/genealogy/no-profile-data";
//        }
//    }
//
//    @GetMapping("/family/{loggedUserId}")
//    public String familyTreePageByCurrentUser(Model model, @PathVariable Long loggedUserId, Principal principal) {
//
//        try {
//            UserProfile currentUserProfile = userProfileService.findUserProfileById(loggedUserId);
//            model.addAttribute("familyTies", familyTiesRepository.findAll());
//            model.addAttribute("userIdRelation", currentUserProfile);
//
//            Long id = userRepository.findByUsername(principal.getName()).get().getId();
//            if (!loggedUserId.equals(id))
//                return "redirect:/genealogy/family";
//
//            return "/genealogy/family-tree";
//
//        } catch (RuntimeException ex) {
//            System.out.println(ex.getMessage());
//            return "redirect:/genealogy/family";
//        }
//    }

    @GetMapping("/family")
    public String familyTreePageByCurrentUser(Model model, Principal principal) {

//        if (model.getAttribute("currentUserProfile").equals())

        try {
            UserProfile currentUserProfile = userProfileService.findUserProfileById(loggedUserId);
            model.addAttribute("familyTies", familyTiesRepository.findAll());
            model.addAttribute("userIdRelation", currentUserProfile);

            Long id = userRepository.findByUsername(principal.getName()).get().getId();
            if (!loggedUserId.equals(id))
                return "redirect:/genealogy/family";

            return "/genealogy/family-tree";

        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            return "redirect:/genealogy/family";
        }
    }


    @GetMapping("/family/{userId}/add-family-member//{idCurrentUserProfile}/{relation}")
    public String familyAddMemberForm(Model model, @PathVariable String relation, @PathVariable String userId, Principal principal) {

        Long idRelation = Long.parseLong(relation);
        Long idUserRelation = Long.parseLong(userId);

        if (!familyTiesRepository.existsById(idRelation)) {
            return "/404";
        }

        if (!userProfileService.existUserProfileById(idUserRelation)) {
            return "/404";
        }

//        model.addAttribute("myProfile", myProfile);
        System.out.println(relation);

//        return "/registration/user-profile-form";

//        тут форма хто і до кого маж відносини



        return "/genealogy/family-add-member-form";
    }

    @PostMapping("/family/add-family-member/{relation}")
    public String familyAddMemberFormSubmit(Model model, @PathVariable String relation, Principal principal) {

//        Long idRelation = Long.parseLong(relation);
//
//        UserProfile memberProfile = new UserProfile();
//        List<FamilyTies> memberFamilyTiesList = new ArrayList<>();
//        memberFamilyTiesList.add(familyTiesRepository.findById(idRelation).orElse(new FamilyTies())); //??
//        memberProfile.setFamilyTies(memberFamilyTiesList);
//
//        UserProfile myProfile
//                = userProfileRepository.findByUser_Email(principal.getName()).orElse(new UserProfile());
//        List<FamilyTies> myFamilyTiesList = myProfile.getFamilyTies();
//        myFamilyTiesList.add(familyTiesRepository.findById(idRelation).orElse(new FamilyTies())); //??
//        myProfile.setFamilyTies(myFamilyTiesList);

        return "/genealogy/family-tree";
    }
    @GetMapping("/403")
    public String test() {
        return "/login/403";
    }
}
