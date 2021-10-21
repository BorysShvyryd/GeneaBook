package com.borman.geneabook.service;

import com.borman.geneabook.entity.Role;
import com.borman.geneabook.entity.User;
import com.borman.geneabook.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findByUserName(String userEmail) {
        return userRepository.findByUsername(userEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> email : " + userEmail)
                );
    }

    @Override
    public void saveUser(User user) {

        if (!userRepository.existsByEmail(user.getEmail())) {
            Role userRole = roleService.getUserRole();
            user.setRoleSet(new HashSet<Role>(List.of(userRole)));
            user.setEnabled(1);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }

        userRepository.save(user);
    }

    @Override
    public void saveNewPassUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new UsernameNotFoundException("User Not Found with -> userId : " + userId)
        );
    }

    @Override
    public boolean hasRoleAdmin(Long userId) {
        return findByUserId(userId).getRoleSet().contains(roleService.getAdminRole());
    }
}
