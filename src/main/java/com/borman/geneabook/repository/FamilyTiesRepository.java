package com.borman.geneabook.repository;

import com.borman.geneabook.entity.FamilyTies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyTiesRepository extends JpaRepository<FamilyTies, Long> {

}
