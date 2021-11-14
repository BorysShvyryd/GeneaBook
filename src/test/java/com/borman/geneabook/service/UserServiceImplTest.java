package com.borman.geneabook.service;

import com.borman.geneabook.entity.Role;
import com.borman.geneabook.entity.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserServiceImplTest {
    private UserServiceImpl userService;
    private User userWithCorrectPassword;
    private User userWithWrongPassword;

    @Before
    public void setup(){

        userWithCorrectPassword = new User();
        userWithCorrectPassword.setNickname("nickname");
        userWithCorrectPassword.setEmail("user@user.com");
        userWithCorrectPassword.setPassword("password");
        userWithCorrectPassword.setConfirmPassword("password");
        Set<Role> roleSet = new HashSet<>();
        Role role = new Role();
        role.setId(1L);
        roleSet.add(role);
        userWithCorrectPassword.setRoleSet(roleSet);

        userService.saveUser(userWithCorrectPassword);

        assertEquals(1, userService.allUsers().size());

        Optional<User> findUserWithCorrectPassword = userService.findByEmail("user@user.com");

        findUserWithCorrectPassword.ifPresent(user -> assertEquals(userWithCorrectPassword.getNickname(), user.getNickname()));

        userService.deleteUserById(1L);

        assertEquals(0, userService.allUsers().size());

        userWithWrongPassword = new User();
        userWithWrongPassword.setNickname("nickname");
        userWithWrongPassword.setEmail("user@user.com");
        userWithWrongPassword.setPassword("");
        userWithWrongPassword.setConfirmPassword("");
        userWithCorrectPassword.setRoleSet(roleSet);
        userService.saveUser(userWithCorrectPassword);

        assertEquals(0, userService.allUsers().size());
    }

    @Test
    void findByUserName() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void saveNewPassUser() {
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void allUsers() {
    }

    @Test
    void findByUserId() {
    }

    @Test
    void hasRoleAdmin() {
    }
}