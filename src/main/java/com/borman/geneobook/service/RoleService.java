package com.borman.geneobook.service;

import com.borman.geneobook.entity.Role;
import com.borman.geneobook.repository.RoleRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getAdminRole() {
        Role role = roleRepository.findByName("ADMIN")
                .orElseThrow(() ->
                        new UsernameNotFoundException("Not role : ADMIN"));
        return role;
    }

    public Role getUserRole() {
        Role role = roleRepository.findByName("USER")
                .orElseThrow(() ->
                        new UsernameNotFoundException("Not role : USER"));
        return role;
    }
}
