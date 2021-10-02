package com.borman.geneobook.service;

import com.borman.geneobook.entity.Role;
import com.borman.geneobook.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getAdminRole() {
        Long roleId = roleRepository.findByName("ADMIN");
        return roleRepository.findById(roleId).orElse(new Role());
    }

    public Role getUserRole() {
        Long roleId = roleRepository.findByName("USER");
        return roleRepository.findById(roleId).orElse(new Role());
    }
}
