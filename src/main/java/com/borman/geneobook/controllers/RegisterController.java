package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.UserProfile;
import com.borman.geneobook.repository.EmailRepository;
import com.borman.geneobook.entity.LoggedUser;
import com.borman.geneobook.entity.pojo.LoginUser;
import com.borman.geneobook.repository.RandomDataRepositories;
import com.borman.geneobook.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/register")
@SessionAttributes({"nic", "email", "token"})
public class RegisterController {

    private final EmailRepository emailRepository;
    private final RandomDataRepositories randomDataRepositories;
    private final UserRepository userRepository;

    public RegisterController(EmailRepository emailRepository, RandomDataRepositories randomDataRepositories, UserRepository userRepository) {
        this.emailRepository = emailRepository;
        this.randomDataRepositories = randomDataRepositories;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String loginRegForm(Model model){

        model.addAttribute("loginUser", new LoginUser());

        return "register/user-login";
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

        return "register/login-sendEmail";
    }

    @GetMapping("/resend")
    public String resendEmail(Model model, HttpServletRequest request) {

        LoginUser loginUser =  new LoginUser();
        loginUser.setNicName((String) model.getAttribute("nic"));
        loginUser.setEmail((String) model.getAttribute("email"));

        model.addAttribute("sendEmail", true);

        loginRegSubmit(loginUser, request, model);

        return "register/login-sendEmail";
    }

    @GetMapping("/{token}")
    public String loginRegConfirm(Model model, HttpSession httpSession, @PathVariable String token){

        if  (httpSession.getAttribute("token") == null) {
            model.addAttribute("nullToken", true);

            return "register/login-null-token";
        }

        if (httpSession.getAttribute("token").equals(token)) {

            LoggedUser loggedUser = new LoggedUser();
            loggedUser.setEmail(httpSession.getAttribute("email").toString());
            loggedUser.setNicName(httpSession.getAttribute("nic").toString());
            model.addAttribute("loggedUser", loggedUser);

            httpSession.invalidate();

            return "register/login-register-form";

        } else {

            model.addAttribute("errorToken", true);
            return "register/login-error-registration";

        }
    }

    @PostMapping("/{token}")
    private String loginRegSubmit(LoggedUser loggedUser) {

        //            userRepository.save(loggedUser);
        System.out.println("Save User ...");

        return "redirect:/geneo";
    }
}
