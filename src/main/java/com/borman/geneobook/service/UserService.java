package com.borman.geneobook.service;

import com.borman.geneobook.entity.User;
import com.borman.geneobook.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findByUserName(String userEmail);

    void saveUser(User user);

    List<User> allUsers();

}
