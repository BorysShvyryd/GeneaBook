//package com.borman.geneobook.controllers;
//
//import com.borman.geneobook.entity.LoggedUser;
//import com.borman.geneobook.entity.UserProfile;
//import com.borman.geneobook.repository.GeneoRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.time.LocalDateTime;
//
//@Controller
//@RequestMapping("/register")
//public class GeneoUserController {
//
//    private final GeneoRepository geneoRepository;
//
//    public GeneoUserController(GeneoRepository geneoRepository) {
//        this.geneoRepository = geneoRepository;
//    }
//
//    @GetMapping("/add")
//    private String create (Model model) {
//        model.addAttribute("userProfile", new UserProfile());
////        model.addAttribute("sexValue", Enum.class);
//
////        MessageFormat mf
////                = new MessageFormat("{0, number, #}, {2, date, #.#}, {4, time}");
////        Locale locale = mf.getLocale();
////
////        System.out.println("Locale is : " + locale);
//
//        return "geneo-user-form";
//    }
//
//    @PostMapping("/add")
//    private String createSave (@Valid UserProfile userProfile, BindingResult result) {
//
//        userProfile.setRegistered(LocalDateTime.now());
//        if (result.hasErrors()) {
//            System.out.println(result.toString());
//            return "geneo-user-form";
//        }
////        userProfile.setRegistered(new LocalD)
//        geneoRepository.save(userProfile);
//
//        System.out.println(userProfile.toString());
//        return "geneo-user-form";
////        return "register-user-form";
//
////        return "redirect:/geneo/add";
//    }
//    @GetMapping("/login")
//    private String createSave1 (Model model) {
////        model.asMap().forEach((k, v) -> logger.debug(k + ": " + v));
//
//        model.addAttribute(new LoggedUser());
//
//        return "login-register-form";
//    }
//
//    @GetMapping("/login/{confirmationEmailString}")
//    private String createSave2 (Model model, @PathVariable String confirmationEmailString) {
//
//        model.addAttribute(new LoggedUser());
//        model.addAttribute("preRegister", true);
//
//        return "login-register-form";
//
//    }
//    @PostMapping("/register/login")
//    private String createSave2 (@Valid LoggedUser loggedUser, BindingResult bindingResult, Model model) {
//
//        System.out.println(model.getAttribute("preRegister"));
//        if ("false".equals(model.getAttribute("preRegister"))) {
//            System.out.println("redirect:https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/");
//        }
//
////        if (bindingResult.hasErrors()) {
////            return "login-register-form";
////        }
////        if (!loggedUser.getPassword().equals(loggedUser.getConfirmPassword())) {
////            return "login-register-form";
////        }
//
////        SendEmailForConfirmation sendEmailForConfirmation =
////                new SendEmailForConfirmation("http://localhost:8080/geneo/register/login/");
//
////        loggedUser.setDateRegisterLogin(LocalDate.now());
//        return "login-register-form";
//
//    }
//}
