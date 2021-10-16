package com.borman.geneobook.repository;

import com.borman.geneobook.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByUser_Email(String email);

    Optional<UserProfile> findUserProfileById(Long id);

//    List<UserProfile> findAllBy;
}
