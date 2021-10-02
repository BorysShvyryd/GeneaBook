package com.borman.geneobook.service;

import com.borman.geneobook.entity.User;
import com.borman.geneobook.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    private final UserRepository userRepository;

    private final RoleService roleService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(EntityManager em, UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.em = em;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public boolean saveUser(User user) {

        User userFromDB = userRepository.findByUserEmail(user.getEmail());

        if (userFromDB != null) {
            return false;
        } else {

            user.setRoleSet(Collections.singleton(roleService.getUserRole()));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            System.out.println("userService : " + user);
//            userRepository.save(user);

            return true;
        }
    }

    public Object allUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        User user = userRepository.findByUserEmail(userEmail);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
