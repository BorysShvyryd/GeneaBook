package com.borman.geneobook.controllers;

import com.borman.geneobook.repository.UserRepository;
import com.borman.geneobook.service.EmailService;
import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.service.RandomDataService;
import com.borman.geneobook.service.UserServiceImpl;
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

        model.addAttribute("loginUser", new LoginUser());

        return "registration/user-registration-nic";
    }

    @PostMapping
    public String loginRegSubmit(LoginUser loginUser, HttpServletRequest request, Model model) {

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
                        "Confirmation email",
                        "Follow the link to confirm: "
                                + request.getHeader("referer")
                                + "/"
                                + tokenEmail)
        );

        return "registration/registration-sendEmail";
    }

    @GetMapping("/resend")
    public String resendEmail(Model model, HttpServletRequest request) {

        LoginUser loginUser = new LoginUser();
        loginUser.setNickname((String) model.getAttribute("nic"));
        loginUser.setEmail((String) model.getAttribute("email"));

//        model.addAttribute("sendEmail", true);

        loginRegSubmit(loginUser, request, model);

        return "registration/registration-sendEmail";
    }

    @GetMapping("/{token}")
    public String loginRegConfirm(Model model, HttpSession httpSession, @PathVariable String token) {

        model.addAttribute("nullToken", false);

        String responseToken = (String) httpSession.getAttribute("token");

        if (responseToken == null) {
            model.addAttribute("nullToken", true);
            return "registration/login-null-token";
        }

        if (responseToken.length() != 64) {
//            model.addAttribute("nullToken", true);
            System.out.println("False token. Please try again.");
            return "registration/login-null-token";
        }

        if (httpSession.getAttribute("token").equals(token)) {

            User user = new User();
            user.setEmail(httpSession.getAttribute("email").toString());
            user.setNickname(httpSession.getAttribute("nic").toString());

            model.addAttribute("user", user);

//            httpSession.invalidate();
//            model.addAttribute("token", "");
            httpSession.setAttribute("token", "");

            return "registration/user-registration-form";

        } else {

            model.addAttribute("errorToken", true);
            return "registration/login-error-registration";

        }
    }

    @PostMapping("/{token}")
    private String loginRegConfirmSubmit(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "registration/user-registration-form";
        }

        userService.saveUser(user);

        return "redirect:/login";
    }
}
