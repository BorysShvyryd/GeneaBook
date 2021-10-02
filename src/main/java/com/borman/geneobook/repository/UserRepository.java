package com.borman.geneobook.repository;

import com.borman.geneobook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = :userEmail")
    User findByUserEmail(@Param("userEmail") String userEmail);

    @Override
    List<User> findAll();

    @Override
    void deleteById(Long aLong);
}