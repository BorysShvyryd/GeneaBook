package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.FamilyTies;
import com.borman.geneobook.entity.Relationship;
import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.UserProfile;
import com.borman.geneobook.repository.FamilyTiesRepository;
import com.borman.geneobook.repository.UserRepository;
import com.borman.geneobook.service.RelationshipService;
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
    private final RelationshipService relationshipService;

    public MainController(UserRepository userRepository,
                          UserProfileService userProfileService,
                          FamilyTiesRepository familyTiesRepository,
                          RelationshipService relationshipService) {
        this.userRepository = userRepository;
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

    @GetMapping("/family")
    public String familyTreePageByCurrentUser(Model model, UserProfile currentUserProfile, Principal principal) {

        model.addAttribute("myFamily", userProfileService.findAllUserProfile());

        return "/genealogy/family-tree";
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
    public String familyAddMemberForm(Model model) {

        model.addAttribute("allUserProfile", userProfileService.findAllUserProfile());
        model.addAttribute("userProfileNewFamilyMember", new UserProfile());
        model.addAttribute("listFamilyTies", familyTiesRepository.findAll());

        return "/genealogy/family-add-member-form";
    }

    @PostMapping("/family/add-family-member")
    public String familyAddMemberFormSubmit(@RequestParam Long idSelectedUserProfile,
                                            @RequestParam Long idSelectedFamilyTies,
                                            UserProfile userProfileNewFamilyMember) {
        Long idFamilyTies = idSelectedFamilyTies;
        if (idSelectedFamilyTies.equals(3L)) {
            idFamilyTies = 1L;
        }

        Long finalIdFamilyTies = idFamilyTies;
        FamilyTies ftSelectedUser = familyTiesRepository
                .findById(idFamilyTies)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Family Ties Not Found with -> selectedFamilyTies : " + finalIdFamilyTies));

        Relationship relationship = new Relationship( idSelectedUserProfile, ftSelectedUser, userProfileNewFamilyMember.getId());
        if (idSelectedFamilyTies.equals(3L)) {
            relationship = new Relationship( userProfileNewFamilyMember.getId(), ftSelectedUser, idSelectedUserProfile);
        }
        relationshipService.save(relationship);

        List<Relationship> relationshipList = new ArrayList<>();
        relationshipList.add(relationship);
        userProfileNewFamilyMember.setRelationships(relationshipList);
        userProfileNewFamilyMember.setUser(null);

        UserProfile selectedUserProfile
                = userProfileService.findUserProfileById(idSelectedUserProfile);
        relationshipList = selectedUserProfile.getRelationships();
        relationshipList.add(relationship);
        selectedUserProfile.setRelationships(relationshipList);

        userProfileService.saveUserProfile(userProfileNewFamilyMember);
        userProfileService.saveUserProfile(selectedUserProfile);

        if (idSelectedFamilyTies.equals(3L)) {
            relationship.setUserWho(userProfileNewFamilyMember.getId());
        } else {
            relationship.setUserWhom(userProfileNewFamilyMember.getId());
        }
        relationshipService.save(relationship);

        return "/genealogy/family-tree";
    }

    @GetMapping("/403")
    public String test() {
        return "/login/403";
    }
}
