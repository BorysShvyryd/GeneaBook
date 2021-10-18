package com.borman.geneabook.controllers;

import com.borman.geneabook.entity.*;
import com.borman.geneabook.repository.FamilyTiesRepository;
import com.borman.geneabook.service.ImageService;
import com.borman.geneabook.service.RelationshipService;
import com.borman.geneabook.service.UserProfileService;
import com.borman.geneabook.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

@Controller
//@Secured("ROLE_USER")
@RequestMapping("/genealogy")
public class MainController {

    private final UserService userService;
    private final UserProfileService userProfileService;
    private final FamilyTiesRepository familyTiesRepository;
    private final RelationshipService relationshipService;
    private final ImageService imageService;

    public MainController(UserService userService,
                          UserProfileService userProfileService,
                          FamilyTiesRepository familyTiesRepository,
                          RelationshipService relationshipService, ImageService imageService) {
        this.userService = userService;
        this.userProfileService = userProfileService;
        this.familyTiesRepository = familyTiesRepository;
        this.relationshipService = relationshipService;
        this.imageService = imageService;
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
    public String viewUserProfile(Model model, @RequestParam Long id) throws SQLException, IOException {

        UserProfile userProfile = userProfileService.findUserProfileById(id);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("readOnly", true);

        //***********************************
//        InputStream imageBytes = userProfileService.findUserProfileById(id).getUserFotoList().get(0).getUserImage().getBinaryStream();
//        byte[] imageBytes = userProfileService.findUserProfileById(id).getUserFotoList().get(0).getUserImage().getBytes(1,
//                    (int) userProfileService.findUserProfileById(id).getUserFotoList().get(0).getUserImage().length());

        if (userProfile.getIdMainPhoto() != null) {

            Optional<UserPhoto> userPhoto = userProfile.getUserFotoList()
                    .stream()
                    .filter(f -> Objects.equals(f.getId(), userProfile.getIdMainPhoto()))
                    .findFirst();

            if (userPhoto.isPresent()) {

                model.addAttribute("mainPhoto", userPhoto.get());

                InputStream is = userPhoto
                        .get()
                        .getUserImage()
                        .getBinaryStream(1, userPhoto
                                .get()
                                .getUserImage()
                                .length());

                BufferedImage image = ImageIO.read(is);

                try {
                    File outputfile = new File("src/main/webapp/resources/img/saved.png");
                    ImageIO.write(image, "png", outputfile);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        //***********************************
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
                                            UserProfile userProfileNewFamilyMember,
                                            BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/genealogy/family-add-member-form";
        }

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

///////////////////////////////////////////
        List<UserPhoto> userPhotoList = new ArrayList<>();
        UserPhoto userPhoto = new UserPhoto();
        userPhoto.setName("Name Photo");
        userPhoto.setDescription("description Photo");
        userPhoto.setUserImage(imageService.blobImageFromFile("E:\\geneo-book\\src\\main\\webapp\\resources\\img\\genealogy.jpg"));

        imageService.saveImage(userPhoto);

        userPhotoList.add(userPhoto);
        userProfileNewFamilyMember.setUserFotoList(userPhotoList);
        userProfileNewFamilyMember.setIdMainPhoto(userPhoto.getId());
/////////////////////////////////////////////

        userProfileService.saveUserProfile(userProfileNewFamilyMember);
        userProfileService.saveUserProfile(selectedUserProfile);

        return "redirect:/genealogy/family";
    }

    @GetMapping("/403")
    public String test() {
        return "/login/403";
    }

}
