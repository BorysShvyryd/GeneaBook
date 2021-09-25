package com.borman.geneobook.repository;

import com.borman.geneobook.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneoRepository extends JpaRepository<UserProfile, Long> {

}