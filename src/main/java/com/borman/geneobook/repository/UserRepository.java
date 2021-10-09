package com.borman.geneobook.repository;

import com.borman.geneobook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from User u where u.email = :userEmail")
//    Optional<User> findByUserEmail(@Param("userEmail") String userEmail);

    @Query("select u from User u where u.email = :userEmail")
    Optional<User> findByUsername(@Param("userEmail") String userEmail);

//    Boolean existsByUsernameAndEmail(String username, String email);

    Boolean existsByEmail(String email);

    @Override
    List<User> findAll();
}