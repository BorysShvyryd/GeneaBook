package com.borman.geneobook.controllers;

import com.borman.geneobook.utils.EmailUtil.*;
import com.borman.geneobook.entity.LoggedUser;
import com.borman.geneobook.entity.pojo.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/register")
@SessionAttributes({"nic", "email", "key"})
public class RegisterController {

    //    private final LoggedUserRepository loggedUserRepository;
//
//    public LoginController(LoggedUserRepository loggedUserRepository) {
//        this.loggedUserRepository = loggedUserRepository;
//    }

    private String verificationKey;

    @GetMapping
    public String loginRegForm(Model model){

        LoginUser loginUser = new LoginUser();

        model.addAttribute("loginUser", loginUser);

        return "register/user-login";
    }

    @PostMapping
    public String loginRegSubmit(LoginUser loginUser, HttpServletRequest request, Model model) throws Exception {

        SendEmailForConfirmation send = new SendEmailForConfirmation(loginUser.getEmail());

        model.addAttribute("nic", loginUser.getNicName());
        model.addAttribute("email", loginUser.getEmail());
        model.addAttribute("key", LocalDateTime.now());

        verificationKey = "/"
                        + loginUser.getNicName()
                        + "---"
                        + loginUser.getEmail()
                        + "---"
                        + LocalDateTime.now();

        System.out.println(generateKeyPair(64L).toString());

//        send.SendEmailForConfirmationKey(
//                request.getHeader("referer")
//                        + verificationKey);

        return "register/login-sendEmail";
    }

    @GetMapping("/{key}")
    public String loginRegConfirm(Model model, @PathVariable String key){

        if (verificationKey == null) {
            System.out.println("key");
            return "register/user...";
        }
//verificationKey = "Borman---bormanpgg@gmail.com---2021-09-28T21:46:43.420627500";

        if (verificationKey.equals(key)) {
//        if (model.getAttribute("nic".);
//        model.addAttribute("email", loginUser.getEmail());
//        model.addAttribute("key", LocalDateTime.now());) {

            LoggedUser loggedUser = new LoggedUser();
            loggedUser.setNicName(key.split("---")[0]);
            loggedUser.setEmail(key.split("---")[1]);

            model.addAttribute("loggedUser", loggedUser);

            System.out.println("ok");

            return "register/login-register-form";
        } else {
            return "register/user...";
        }
    }


    private KeyPair generateKeyPair(long seed) throws Exception {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom rng = SecureRandom.getInstance("SHA1PRNG", "SUN");
        rng.setSeed(seed);
        keyGenerator.initialize(2048, rng);
        return (keyGenerator.generateKeyPair());
    }

}
