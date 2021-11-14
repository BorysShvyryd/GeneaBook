package com.borman.geneabook.controllers;

import com.borman.geneabook.repository.UserRepository;
import com.borman.geneabook.service.EmailService;
import com.borman.geneabook.entity.User;
import com.borman.geneabook.service.RandomDataService;
import com.borman.geneabook.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
@SessionAttributes({"nic", "email", "token"})
public class RegistrationController {

    private final EmailService emailService;
    private final RandomDataService randomDataService;
    private final UserServiceImpl userService;
    private final UserRepository userRepository;

    public RegistrationController(EmailService emailService, RandomDataService randomDataService, UserServiceImpl userService, UserRepository userRepository) {
        this.emailService = emailService;
        this.randomDataService = randomDataService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String loginRegForm(Model model) {

        model.addAttribute("loginUser", new User());

        return "registration/user-registration-nic";
    }

    @PostMapping
    public String loginRegSubmit(User loginUser, HttpServletRequest request, Model model) {

        model.addAttribute("notCorrectNic", false);

        if (loginUser.getNickname().trim().length() < 5
                || loginUser.getNickname().trim().length() > 32) {
            model.addAttribute("notCorrectNic", true);
            return "registration/user-registration-nic";
        }

        model.addAttribute("notCorrectEmail", false);

        if (!randomDataService.verificationEmail(loginUser.getEmail())) {
            model.addAttribute("notCorrectEmail", true);
            return "registration/user-registration-nic";
        }

        model.addAttribute("alreadyRegistered", false);

        if (userRepository.existsByEmail(loginUser.getEmail())) {
            model.addAttribute("alreadyRegistered", true);
            return "registration/user-registration-nic";
        }

        String tokenEmail = randomDataService.getToken();

        model.addAttribute("nic", loginUser.getNickname());
        model.addAttribute("email", loginUser.getEmail());
        model.addAttribute("token", tokenEmail);

        model.addAttribute("sendEmail",
                emailService.SendEmail(loginUser.getEmail(),
                        "Confirm your account on GenealogyBook",
                        "Thank you for registering with GenealogyBook! To activate your account, follow this link: "
                                + request.getHeader("referer")
                                + "/"
                                + tokenEmail)
        );

        return "registration/registration-sendEmail";
    }

    @GetMapping("/resend")
    public String resendEmail(Model model, HttpServletRequest request) {

        User loginUser = new User();
        loginUser.setNickname((String) model.getAttribute("nic"));
        loginUser.setEmail((String) model.getAttribute("email"));
        model.addAttribute("sendEmail",
                emailService.SendEmail(loginUser.getEmail(),
                        "Confirm your account on GenealogyBook",
                        "Thank you for registering with GenealogyBook! To activate your account, follow this link: "
                                + request.getHeader("referer")
                                + "/"
                                + model.getAttribute("token"))
        );

        return "registration/registration-sendEmail";
    }

    @GetMapping("/{token}")
    public String loginRegConfirm(Model model, HttpSession httpSession, @PathVariable String token) {

        model.addAttribute("nullToken", false);

        String responseToken = (String) httpSession.getAttribute("token");

        if (responseToken == null) {
            model.addAttribute("errorUserEmail", false);
            model.addAttribute("errorToken", false);
            model.addAttribute("nullToken", true);
            model.addAttribute("nonCorrectToken", false);
            return "error";
        }

        if (!responseToken.matches("[0-9a-zA-Z]{64}")) {
            model.addAttribute("errorUserEmail", false);
            model.addAttribute("errorToken", false);
            model.addAttribute("nullToken", false);
            model.addAttribute("nonCorrectToken", true);
            return "error";
        }

        if (httpSession.getAttribute("token").equals(token)) {

            User user = new User();
            user.setEmail(httpSession.getAttribute("email").toString());
            user.setNickname(httpSession.getAttribute("nic").toString());

            model.addAttribute("user", user);

            httpSession.setAttribute("token", "");

            return "registration/user-registration-form";

        } else {

            model.addAttribute("errorUserEmail", false);
            model.addAttribute("errorToken", true);
            model.addAttribute("nullToken", false);
            model.addAttribute("nonCorrectToken", false);
            return "error";
        }
    }

    @PostMapping("/{token}")
    private String loginRegConfirmSubmit(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "registration/user-registration-form";
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            System.out.println("Error confirm password");
            return "registration/user-registration-form";
        }
// ????
        if (userService.userCount() == 0) {
            System.out.println("First connection");
            // add record ROLE
            // add record ...
        }

        userService.saveUser(user);

        return "redirect:/login";
    }
}
