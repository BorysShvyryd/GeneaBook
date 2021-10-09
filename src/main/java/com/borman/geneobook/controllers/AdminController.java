package com.borman.geneobook.controllers;

import com.borman.geneobook.entity.User;
import com.borman.geneobook.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private final UserServiceImpl userService;

    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String userAdmin() {
        return "admin/admin";
    }

    @GetMapping("/admin/listUsers")
    public String usersList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin/list-users";
    }

    @GetMapping("/admin/listUsers/blocked")
    public String usersBlockedById(@RequestParam Long id,  @RequestParam int value) {
        User findUser = userService.findByUserId(id);
        findUser.setEnabled(value);
        userService.saveUser(findUser);
        return "redirect:/admin/listUsers";
    }

    @GetMapping("/admin/listUsers/delete")
    public String  deleteUserByIdQuestion(@RequestParam Long id, Model model) {
        User user = userService.findByUserId(id);
        model.addAttribute("deleteUser", user);
        return "admin/delete-user-confirmation";
    }

    @PostMapping("/admin/listUsers/delete")
    public String  deleteUserByIdSubmit(Model model, @RequestParam String action, User deleteUser) {
        if ("okButton".equals(action)) {
            userService.deleteUserById(deleteUser.getId());
        }
        return "redirect:/admin/listUsers";
    }
}
