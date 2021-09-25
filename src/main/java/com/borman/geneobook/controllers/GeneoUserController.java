package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.UserProfile;
import com.borman.geneobook.repository.GeneoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Locale;

@Controller
@RequestMapping("/geneo")
public class GeneoUserController {

    private final GeneoRepository geneoRepository;

    public GeneoUserController(GeneoRepository geneoRepository) {
        this.geneoRepository = geneoRepository;
    }

    @GetMapping("/add")
    private String create (Model model) {
        model.addAttribute("userProfile", new UserProfile());
//        model.addAttribute("sexValue", Enum.class);

//        MessageFormat mf
//                = new MessageFormat("{0, number, #}, {2, date, #.#}, {4, time}");
//        Locale locale = mf.getLocale();
//
//        System.out.println("Locale is : " + locale);

        return "geneo-user-form";
    }

    @PostMapping("/add")
    private String createSave (@Valid UserProfile userProfile, BindingResult result) {

        userProfile.setRegistered(LocalDateTime.now());
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "geneo-user-form";
        }
        geneoRepository.save(userProfile);

        System.out.println(userProfile.toString());
        return "geneo-user-form";
//        return "redirect:/geneo/add";
    }
}
