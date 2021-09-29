package com.borman.geneobook.controllers;

import com.borman.geneobook.repository.EmailRepository;
import com.borman.geneobook.entity.LoggedUser;
import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.repository.RandomDataRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/register")
@SessionAttributes({"nic", "email", "token"})
public class RegisterController {

    private final EmailRepository emailRepository;
    private final RandomDataRepositories randomDataRepositories;

    private String verificationKey;

    public RegisterController(EmailRepository emailRepository, RandomDataRepositories randomDataRepositories) {
        this.emailRepository = emailRepository;
        this.randomDataRepositories = randomDataRepositories;
    }

    @GetMapping
    public String loginRegForm(Model model){

        LoginUser loginUser = new LoginUser();

        model.addAttribute("loginUser", loginUser);

        return "register/user-login";
    }

    @PostMapping
    public String loginRegSubmit(LoginUser loginUser, HttpServletRequest request, Model model) {

        String tokenEmail = randomDataRepositories.getToken();

        model.addAttribute("nic", loginUser.getNicName());
        model.addAttribute("email", loginUser.getEmail());
        model.addAttribute("token", tokenEmail);

        emailRepository.SendEmail(loginUser.getEmail(),
                "Confirmation email",
                 "Follow the link to confirm: "
                         + request.getHeader("referer")
                         + "/"
                         + tokenEmail);

        return "register/login-sendEmail";
    }

    @GetMapping("/{token}")
    public String loginRegConfirm(Model model, HttpSession httpSession, @PathVariable String token){

        if  (httpSession.getAttribute("token") == null) return "home-page";

        if (httpSession.getAttribute("token") != token) {

            LoggedUser loggedUser = new LoggedUser();
            loggedUser.setEmail(httpSession.getAttribute("nic").toString());
            loggedUser.setNicName(httpSession.getAttribute("nic").toString());
            model.addAttribute("loggedUser", loggedUser);

            httpSession.invalidate();

            return "register/login-register-form";

        } else {

            return "home-page";
        }
    }
}
