package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.FamilyTies;
import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.UserProfile;
import com.borman.geneobook.repository.RelationshipRepository;
import com.borman.geneobook.waste.RelationShip1;
import com.borman.geneobook.repository.FamilyTiesRepository;
import com.borman.geneobook.repository.UserProfileRepository;
import com.borman.geneobook.repository.UserRepository;
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
    private final UserProfileRepository userProfileRepository;
    private final FamilyTiesRepository familyTiesRepository;
    private final RelationshipRepository relationshipRepository;

    public MainController(UserRepository userRepository, UserProfileRepository userProfileRepository, FamilyTiesRepository familyTiesRepository, RelationshipRepository relationshipRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.familyTiesRepository = familyTiesRepository;
        this.relationshipRepository = relationshipRepository;
    }

    @GetMapping("")
    public String homePage() {
        return "/genealogy/main-page";
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

        return "/genealogy/main-page";
    }

    @GetMapping("/family")
    public String familyTreePage(Model model, Principal principal) {

        model.addAttribute("familyTies", familyTiesRepository.findAll());
        model.addAttribute("userIdRelation", userProfileRepository.findByUser_Email(principal.getName()).get());

        return "/genealogy/family-tree";
    }

    @GetMapping("/family/member/")
    public String redirectNullToken() {
        return "redirect:/genealogy/family";
    }

    @GetMapping("/family/member/{userId}/{relation}")
    public String familyAddMemberForm(Model model, @PathVariable String relation, @PathVariable String userId, Principal principal) {

        Long idRelation = Long.parseLong(relation);
        Long idUserRelation = Long.parseLong(userId);

        if (!familyTiesRepository.existsById(idRelation)) {
            return "/404";
        }

        if (!userProfileRepository.existsById(idUserRelation)) {
            return "/404";
        }

//        model.addAttribute("myProfile", myProfile);
        System.out.println(relation);

//        return "/registration/user-profile-form";

//        тут форма хто і до кого маж відносини



        return "/genealogy/family-add-member-form";
    }

    @PostMapping("/family/member/{relation}")
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
}
