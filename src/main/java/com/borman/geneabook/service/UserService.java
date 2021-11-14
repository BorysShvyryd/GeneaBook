package com.borman.geneabook.service;

import com.borman.geneabook.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findByEmail(String userEmail);

    Optional<User> findByUserId(Long userId);

    void saveUser(User user);

    void updateUser(User user);

    void saveUserNewPass(User user);

    void deleteUserById(Long userId);

    List<User> allUsers();

    Long userCount();

    boolean hasRoleAdmin(Long id);
}
