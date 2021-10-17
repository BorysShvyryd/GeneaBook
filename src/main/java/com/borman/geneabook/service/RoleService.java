package com.borman.geneabook.service;

import com.borman.geneabook.entity.Role;
import com.borman.geneabook.repository.RoleRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getAdminRole() {
        Role role = roleRepository.findByName("ROLE_ADMIN")
                .orElseThrow(() ->
                        new UsernameNotFoundException("Not role : ADMIN"));
        return role;
    }

    public Role getUserRole() {
        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() ->
                        new UsernameNotFoundException("Not role : USER"));
        return role;
    }
}
