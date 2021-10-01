package com.borman.geneobook.controllers;

import com.borman.geneobook.repository.EmailRepository;
import com.borman.geneobook.entity.LoggedUser;
import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.repository.RandomDataRepositories;
import com.borman.geneobook.repository.UserRepository;
import com.borman.geneobook.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/registration")
@SessionAttributes({"nic", "email", "token"})
public class RegisterController {

    private final EmailRepository emailRepository;
    private final RandomDataRepositories randomDataRepositories;
    private final UserService userService;

    public RegisterController(EmailRepository emailRepository, RandomDataRepositories randomDataRepositories, UserService userService) {
        this.emailRepository = emailRepository;
        this.randomDataRepositories = randomDataRepositories;
        this.userService = userService;
    }

    @GetMapping
    public String loginRegForm(Model model){

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

        emailRepository.SendEmail(loginUser.getEmail(),
                "Confirmation email",
                 "Follow the link to confirm: "
                         + request.getHeader("referer")
                         + "/"
                         + tokenEmail);

        return "registration/login-sendEmail";
    }

    @GetMapping("/resend")
    public String resendEmail(Model model, HttpServletRequest request) {

        LoginUser loginUser =  new LoginUser();
        loginUser.setNicName((String) model.getAttribute("nic"));
        loginUser.setEmail((String) model.getAttribute("email"));

        model.addAttribute("sendEmail", true);

        loginRegSubmit(loginUser, request, model);

        return "registration/login-sendEmail";
    }

    @GetMapping("/{token}")
    public String loginRegConfirm(Model model, HttpSession httpSession, @PathVariable String token){

        if  (httpSession.getAttribute("token") == null) {
            model.addAttribute("nullToken", true);

            return "registration/login-null-token";
        }

        if (httpSession.getAttribute("token").equals(token)) {

            LoggedUser loggedUser = new LoggedUser();
            loggedUser.setEmail(httpSession.getAttribute("email").toString());
            loggedUser.setNicName(httpSession.getAttribute("nic").toString());
            loggedUser.setDateRegisterLogin(LocalDateTime.now());

            model.addAttribute("loggedUser", loggedUser);

            httpSession.invalidate();

            return "registration/login-register-form";

        } else {

            model.addAttribute("errorToken", true);
            return "registration/login-error-registration";

        }
    }

    @PostMapping("/{token}")
    private String loginRegSubmit(@Valid LoggedUser loggedUser, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration/login-register-form";
        }

        loggedUser.setDateRegisterLogin(LocalDateTime.now());
        System.out.println(loggedUser);
        userService.saveUser(loggedUser);

        return "redirect:/geneo";
    }
}
