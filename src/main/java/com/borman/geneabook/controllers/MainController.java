package com.borman.geneabook.controllers;

import com.borman.geneabook.entity.FamilyTies;
import com.borman.geneabook.entity.Relationship;
import com.borman.geneabook.entity.User;
import com.borman.geneabook.entity.UserProfile;
import com.borman.geneabook.repository.FamilyTiesRepository;
import com.borman.geneabook.repository.UserRepository;
import com.borman.geneabook.service.RelationshipService;
import com.borman.geneabook.service.UserProfileService;
import com.borman.geneabook.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
//@Secured("ROLE_USER")
@RequestMapping("/genealogy")
public class MainController {

    private final UserService userService;
    private final UserProfileService userProfileService;
    private final FamilyTiesRepository familyTiesRepository;
    private final RelationshipService relationshipService;

    public MainController(UserService userService,
                          UserProfileService userProfileService,
                          FamilyTiesRepository familyTiesRepository,
                          RelationshipService relationshipService) {
        this.userService = userService;
        this.userProfileService = userProfileService;
        this.familyTiesRepository = familyTiesRepository;
        this.relationshipService = relationshipService;
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
        model.addAttribute("readOnly", false);

        return "/registration/user-profile-form";
    }

    @PostMapping("/profile")
    public String userProfileFormSubmit(@Valid UserProfile userProfile, BindingResult bindingResult, Principal principal) {

        if (bindingResult.hasErrors()) {
            return "/registration/user-profile-form";
        }

        User user = userService.findByUserName(principal.getName());

        if (userProfile.getId() == null) {
            userProfile.setUser(user);
            user.setUserProfile(userProfile);
            userProfileService.saveUserProfile(userProfile);
            userService.saveUser(user);
        } else {
            userProfileService.saveUserProfile(userProfile);
        }

        return "/genealogy/main-page";
    }

    @GetMapping("/family")
    public String familyTreePageByCurrentUser(Model model, UserProfile currentUserProfile, Principal principal) {

        if (!userProfileService.existUserProfileById(userService.findByUserName(principal.getName()).getId())) {
            return "/genealogy/no-profile-data";
        }

        model.addAttribute("myFamily", userProfileService.findAllUserProfile());

        return "/genealogy/family-tree";
    }

    @GetMapping("/family/edit-profile")
    public String editUserProfile(Model model, @RequestParam Long id) {

        model.addAttribute("userProfile", userProfileService.findUserProfileById(id));
        model.addAttribute("readOnly", false);
        return "/registration/user-profile-form";
    }

    @GetMapping("/family/view-profile")
    public String viewUserProfile(Model model, @RequestParam Long id) {

        model.addAttribute("userProfile", userProfileService.findUserProfileById(id));
        model.addAttribute("readOnly", true);
        return "/registration/user-profile-form";
    }

    @PostMapping("/family/view-profile")
    public String viewUserProfileSubmit() {
        return "redirect:/genealogy/family";
    }

    @GetMapping("/family/add-family-member")
    public String familyAddMemberForm(Model model, Principal principal) {

        if (!userProfileService.existUserProfileById(userService.findByUserName(principal.getName()).getId())) {
            return "/genealogy/no-profile-data";
        }

        model.addAttribute("allUserProfile", userProfileService.findAllUserProfile());
        model.addAttribute("userProfileNewFamilyMember", new UserProfile());
        model.addAttribute("listFamilyTies", familyTiesRepository.findAll());

        return "/genealogy/family-add-member-form";
    }

    @PostMapping("/family/add-family-member")
    @Transactional
    public String familyAddMemberFormSubmit(@RequestParam Long idSelectedUserProfile,
                                            @RequestParam Long idSelectedFamilyTies,
                                            UserProfile userProfileNewFamilyMember) {
        FamilyTies ftSelectedUser = familyTiesRepository
                .findById(idSelectedFamilyTies)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Family Ties Not Found with -> idSelectedFamilyTies : " + idSelectedFamilyTies));

        Relationship relationship = new Relationship(idSelectedUserProfile, ftSelectedUser, null);

        if (idSelectedFamilyTies.equals(3L)) {
            ftSelectedUser = familyTiesRepository
                    .findById(1L)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("Family Ties Not Found with -> 1L"));
            relationship = new Relationship(null, ftSelectedUser, idSelectedUserProfile);
        }

        relationshipService.save(relationship);

        userProfileNewFamilyMember.setUser(null);
        userProfileService.saveUserProfile(userProfileNewFamilyMember);

        if (idSelectedFamilyTies.equals(3L)) {
            relationship.setUserWho(userProfileNewFamilyMember.getId());
        } else {
            relationship.setUserWhom(userProfileNewFamilyMember.getId());
        }

        relationshipService.save(relationship);

        UserProfile selectedUserProfile
                = userProfileService.findUserProfileById(idSelectedUserProfile);
        List<Relationship> relationshipList = selectedUserProfile.getRelationships();
        relationshipList.add(relationship);
        selectedUserProfile.setRelationships(relationshipList);

        relationshipList = new ArrayList<>();
        relationshipList.add(relationship);
        userProfileNewFamilyMember.setRelationships(relationshipList);
        userProfileNewFamilyMember.setUser(null);

        userProfileService.saveUserProfile(userProfileNewFamilyMember);
        userProfileService.saveUserProfile(selectedUserProfile);

        return "redirect:/genealogy/family";
    }

    @GetMapping("/403")
    public String test() {
        return "/login/403";
    }
}
