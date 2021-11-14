package com.borman.geneabook.service;

import com.borman.geneabook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> userOptional = userService.findByEmail(email);

        if (userOptional.isPresent()) {

            Set<GrantedAuthority> grantedAuthorities = new HashSet<>(userOptional.get().getRoleSet());
            return new org.springframework.security.core.userdetails.User(
                    userOptional.get().getEmail(), userOptional.get().getPassword(), grantedAuthorities);
        }

        return null;
    }
}
