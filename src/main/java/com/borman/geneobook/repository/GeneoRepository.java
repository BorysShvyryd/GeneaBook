package com.borman.geneobook.repository;

import com.borman.geneobook.entity.GeneoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneoRepository extends JpaRepository<GeneoUser, Long> {

}