package com.borman.geneobook.controllers;

import com.borman.geneobook.service.EmailService;
import com.borman.geneobook.entity.User;
import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.repository.RandomDataRepositories;
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
    private final RandomDataRepositories randomDataRepositories;
    private final UserServiceImpl userService;

    public RegistrationController(EmailService emailService, RandomDataRepositories randomDataRepositories, UserServiceImpl userService) {
        this.emailService = emailService;
        this.randomDataRepositories = randomDataRepositories;
        this.userService = userService;
    }

    @GetMapping
    public String loginRegForm(Model model) {

        model.addAttribute("loginUser", new LoginUser());

        return "registration/user-login";
    }

    @PostMapping
    public String loginRegSubmit(LoginUser loginUser, HttpServletRequest request, Model model) {

        String tokenEmail = randomDataRepositories.getToken();

        model.addAttribute("nic", loginUser.getNicName());
        model.addAttribute("email", loginUser.getEmail());
        model.addAttribute("token", tokenEmail);

        model.addAttribute("sendEmail", true);

        emailService.SendEmail(loginUser.getEmail(),
                "Confirmation email",
                "Follow the link to confirm: "
                        + request.getHeader("referer")
                        + "/"
                        + tokenEmail);

        return "registration/login-sendEmail";
    }

    @GetMapping("/resend")
    public String resendEmail(Model model, HttpServletRequest request) {

        LoginUser loginUser = new LoginUser();
        loginUser.setNicName((String) model.getAttribute("nic"));
        loginUser.setEmail((String) model.getAttribute("email"));

        model.addAttribute("sendEmail", true);

        loginRegSubmit(loginUser, request, model);

        return "registration/login-sendEmail";
    }

    @GetMapping("/{token}")
    public String loginRegConfirm(Model model, HttpSession httpSession, @PathVariable String token) {

        if (httpSession.getAttribute("token") == null) {
            model.addAttribute("nullToken", true);

            return "registration/login-null-token";
        }

        if (httpSession.getAttribute("token").equals(token)) {

            User user = new User();
            user.setEmail(httpSession.getAttribute("email").toString());
            user.setNicName(httpSession.getAttribute("nic").toString());

            model.addAttribute("user", user);

//            System.out.println("@GetMapping(/{token}) : " + user);

            httpSession.invalidate();

            return "registration/login-register-form";

        } else {

            model.addAttribute("errorToken", true);
            return "registration/login-error-registration";

        }
    }

    @PostMapping("/{token}")
    private String loginRegSubmit(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "registration/login-register-form";
        }

        userService.saveUser(user);

        return "redirect:/login";
    }
}
