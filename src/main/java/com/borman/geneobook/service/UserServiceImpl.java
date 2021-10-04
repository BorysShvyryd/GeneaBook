package com.borman.geneobook.service;

import com.borman.geneobook.entity.Role;
import com.borman.geneobook.entity.User;
import com.borman.geneobook.repository.UserRepository;
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

        if (userRepository.existsByEmail(user.getEmail())) {
            System.out.println("A user with this email is registered.");
        } else {
            Role userRole = roleService.getUserRole();
            user.setRoleSet(new HashSet<Role>(List.of(userRole)));
            user.setEnabled(1);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            userRepository.save(user);
        }
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

//    @PersistenceContext
//    private EntityManager em;
//
//    private final UserRepository userRepository;
//
//    private final RoleService roleService;
//
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public UserServiceImpl(EntityManager em, UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.em = em;
//        this.userRepository = userRepository;
//        this.roleService = roleService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    public boolean saveUser(User user) {
//
//        User userFromDB = userRepository.findByUsername(user.getEmail())
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User Not Found with -> username or email : " + user.getUsername())
//                );
//
//        if (userFromDB != null) {
//            return false;
//        } else {
//
////            user.setRoleSet(Collections.singleton(roleService.getUserRole()));
//            Role userRole = roleService.getUserRole();
//            user.setRoleSet(new HashSet<Role>(Arrays.asList(userRole)));
//            user.setEnabled(1);
//            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//
//            System.out.println("userService : " + user);
////            userRepository.save(user);
//
//            return true;
//        }
//    }
//
//    public Object allUsers() {
//        return userRepository.findAll();
//    }
//
//    public void deleteUser(Long userId) {
//        userRepository.deleteById(userId);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
//
//        User user = userRepository.findByUsername(userEmail)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User Not Found with -> username or email : " + userEmail)
//                );
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return user;
//    }

}
