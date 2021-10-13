package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.FamilyTies;
import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.UserProfile;
import com.borman.geneobook.repository.RelationshipRepository;
import com.borman.geneobook.repository.FamilyTiesRepository;
import com.borman.geneobook.repository.UserProfileRepository;
import com.borman.geneobook.repository.UserRepository;
import com.borman.geneobook.service.UserProfileService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
    public String familyTreePageByCurrentUser(Model model, UserProfile currentUserProfile, Principal principal) {
//        System.out.println(currentUserProfile.getId());
//
//        if (currentUserProfile.getId() == null) {
//            model.addAttribute("currentUserProfile", userProfileService.findUserByEmail(principal.getName()));
//        } else {
//            model.addAttribute("currentUserProfile", currentUserProfile);
//        }
        return "/genealogy/family-tree";
    }


    @GetMapping("/family/add-family-member")
    public String familyAddMemberForm(Model model, Principal principal) {

//        UserProfile currentUserProfile = userProfileService.findUserByEmail(principal.getName());
// тут вставити код актуального юзера
//        model.addAttribute("currentUserProfile", currentUserProfile);

        model.addAttribute("allUserProfile", userProfileService.findAllUserProfile());
        model.addAttribute("userProfileNewFamilyMember", new UserProfile());
        model.addAttribute("listFamilyTies", familyTiesRepository.findAll());

        return "/genealogy/family-add-member-form";
    }

    @PostMapping("/family/add-family-member")
    public String familyAddMemberFormSubmit(@RequestParam Long idSelectedUserProfile,
                                            @RequestParam Long idSelectedFamilyTies,
                                            UserProfile userProfileNewFamilyMember) {
        System.out.println(userProfileNewFamilyMember);
        List<FamilyTies> memberFamilyTiesList = new ArrayList<>();
        memberFamilyTiesList.add(familyTiesRepository.findById((idSelectedFamilyTies^3)+1).orElseThrow(() ->
                new UsernameNotFoundException("Family Ties Not Found with -> selectedFamilyTies : " + idSelectedFamilyTies))
        );
        userProfileNewFamilyMember.setFamilyTies(memberFamilyTiesList);
        userProfileNewFamilyMember.setUser(null);

        UserProfile selectedUserProfile
                = userProfileService.findUserProfileById(idSelectedUserProfile);
        List<FamilyTies> selectedFamilyTiesList = selectedUserProfile.getFamilyTies();
        selectedFamilyTiesList.add(familyTiesRepository.findById(idSelectedFamilyTies).orElseThrow(() ->
                new UsernameNotFoundException("Family Ties Not Found with -> selectedFamilyTies : " + idSelectedFamilyTies))
        );
        selectedUserProfile.setFamilyTies(selectedFamilyTiesList);

//        System.out.println("save ........");
        System.out.println(userProfileNewFamilyMember);
        System.out.println(selectedUserProfile);
        userProfileService.saveUserProfile(userProfileNewFamilyMember);
        userProfileService.saveUserProfile(selectedUserProfile);

        return "/genealogy/family-tree";
    }

    @GetMapping("/403")
    public String test() {
        return "/login/403";
    }
}
