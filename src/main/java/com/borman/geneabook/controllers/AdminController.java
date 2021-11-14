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
import java.util.Optional;
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
        Optional<User> findUser = userService.findByUserId(id);
        if (findUser.isPresent()) {
            findUser.get().setEnabled(value);
            userService.saveUser(findUser.get());
        }
        return "redirect:/admin/listUsers";
    }

    @GetMapping("/listUsers/delete")
    public String  deleteUserByIdQuestion(@RequestParam Long id, Model model) {
        Optional<User> user = userService.findByUserId(id);
        user.ifPresent(value -> model.addAttribute("deleteUser", value));
        return "admin/delete-user-confirmation";
    }

    @PostMapping("/listUsers/delete")
    public String  deleteUserByIdSubmit(@RequestParam String action, User deleteUser, Principal principal) {

//        if (Objects.equals(userService.findByUserName(principal.getName()).getId(), deleteUser.getId())) {
//            System.out.println("Attempting to delete your account");
//            return "redirect:/admin/listUsers";
//        }

        if ("okButton".equals(action)) {
            userService.deleteUserById(deleteUser.getId());
        }

        return "redirect:/admin/listUsers";
    }

    @GetMapping("/listUsers/change-admin-role")
    public String addAdminRole(@RequestParam Long id, Principal principal) {

        Optional<User> user = userService.findByEmail(principal.getName());

        if (user.isPresent()) {

            if (Objects.equals(user.get().getId(), id)) {
                System.out.println("Trying to edit your rights");
                return "redirect:/admin/listUsers";
            }

            Set<Role> roles = user.get().getRoleSet();

            if (userService.hasRoleAdmin(id)) {
                roles.remove(roleService.getAdminRole());
            } else {
                roles.add(roleService.getAdminRole());
            }

            user.get().setRoleSet(roles);

            userService.saveUser(user.get());
        }

        return "redirect:/admin/listUsers";
    }


}
