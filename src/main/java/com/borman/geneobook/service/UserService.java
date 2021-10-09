package com.borman.geneobook.service;

import com.borman.geneobook.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findByUserName(String userEmail);

    User findByUserId(Long userId);

    void saveUser(User user);

    void deleteUserById(Long userId);

    List<User> allUsers();

}
