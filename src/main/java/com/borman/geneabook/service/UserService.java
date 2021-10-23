package com.borman.geneabook.service;

import com.borman.geneabook.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findByUserName(String userEmail);

    Optional<User> findByUserId(Long userId);

    void saveUser(User user);

    void saveNewPassUser(User user);

    void deleteUserById(Long userId);

    boolean hasRoleAdmin(Long userId);

    List<User> allUsers();

}
