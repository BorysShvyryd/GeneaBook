package com.borman.geneabook.service;

import com.borman.geneabook.entity.Role;
import com.borman.geneabook.entity.User;
import com.borman.geneabook.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public Optional<User> findByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    @Override
    public void saveUser(User user) {

        if (!userRepository.existsByEmail(user.getEmail())) {
            Role userRole = roleService.getUserRole();
            Set<Role> roles = new HashSet<>();
            roles.add(userRole);
            user.setRoleSet(roles);
            user.setEnabled(1);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }

        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveUserNewPass(User user) {
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
    public Long userCount() {
        return userRepository.count();
    }

    @Override
    public boolean hasRoleAdmin(Long id) {
        Role roleAdmin = roleService.getAdminRole();
        User user = findByUserId(id).orElse(null);
        if (user != null) {
            return user.getRoleSet().contains(roleAdmin);
        }
        return false;
    }

    @Override
    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }
}
