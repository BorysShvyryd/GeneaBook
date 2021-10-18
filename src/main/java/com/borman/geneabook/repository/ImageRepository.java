package com.borman.geneabook.repository;

import com.borman.geneabook.entity.UserPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<UserPhoto, Long> {

}
