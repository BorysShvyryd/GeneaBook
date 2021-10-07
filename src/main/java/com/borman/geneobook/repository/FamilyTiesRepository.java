package com.borman.geneobook.repository;

import com.borman.geneobook.entity.FamilyTies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyTiesRepository extends JpaRepository<FamilyTies, Long> {

}
