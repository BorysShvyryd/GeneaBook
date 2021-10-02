package com.borman.geneobook.repository;

import com.borman.geneobook.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Long findByName(String name);
}
