package com.borman.geneabook.controllers;

import com.borman.geneabook.entity.Role;
import com.borman.geneabook.entity.User;
import com.borman.geneabook.service.RoleService;
import com.borman.geneabook.service.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Controller
@RequestMapping("/admin")
//@SessionAttributes({"userNickname"})
public class AdminController {

    private final UserServiceImpl userService;
    private final RoleService roleService;

    public AdminController(UserServiceImpl userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/listUsers")
    public String usersList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin/list-users";
    }

    @GetMapping("/listUsers/blocked")
    public String usersBlockedById(@RequestParam Long id,  @RequestParam int value) {
        User findUser = userService.findByUserId(id);
        findUser.setEnabled(value);
        userService.saveUser(findUser);
        return "redirect:/admin/listUsers";
    }

    @GetMapping("/listUsers/delete")
    public String  deleteUserByIdQuestion(@RequestParam Long id, Model model) {
        User user = userService.findByUserId(id);
        model.addAttribute("deleteUser", user);
        return "admin/delete-user-confirmation";
    }

    @PostMapping("/listUsers/delete")
    public String  deleteUserByIdSubmit(@RequestParam String action, User deleteUser, Principal principal) {

        if (Objects.equals(userService.findByUserName(principal.getName()).getId(), deleteUser.getId())) {
            System.out.println("Attempting to delete your account");
            return "redirect:/admin/listUsers";
        }

        if ("okButton".equals(action)) {
            userService.deleteUserById(deleteUser.getId());
        }

        return "redirect:/admin/listUsers";
    }

    @GetMapping("/listUsers/change-admin-role")
    public String addAdminRole(@RequestParam Long id, Principal principal) {

        User user = userService.findByUserName(principal.getName());

        if (Objects.equals(user.getId(), id)) {
            System.out.println("Trying to edit your rights");
            return "redirect:/admin/listUsers";
        }

        Set<Role> roles = user.getRoleSet();

        if (userService.hasRoleAdmin(id)) {
            roles.remove(roleService.getAdminRole());
        } else {
            roles.add(roleService.getAdminRole());
        }

        user.setRoleSet(roles);

        userService.saveUser(user);

        return "redirect:/admin/listUsers";
    }


}
