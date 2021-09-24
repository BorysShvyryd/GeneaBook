package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.GeneoUser;
import com.borman.geneobook.repository.GeneoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/geneo")
public class GeneoUserController {

    private final GeneoRepository geneoRepository;

    public GeneoUserController(GeneoRepository geneoRepository) {
        this.geneoRepository = geneoRepository;
    }

    @GetMapping("/add")
    private String create (Model model) {
        model.addAttribute("geneoUser", new GeneoUser());
        return "geneo-user-form";
    }

    @PostMapping("/add")
    @ResponseBody
    private String createSave (GeneoUser geneoUser) {
        geneoUser.setRegistered(LocalDateTime.now());
        System.out.println(geneoUser.toString());
//        geneoRepository.save(geneoUser);
//        return "redirect:/pages/geneo-user-form";
        return "geneoUser.toString()";
    }
}
