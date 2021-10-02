package com.borman.geneobook.repository;

import com.borman.geneobook.entity.LoggedUser;
import com.borman.geneobook.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<LoggedUser, Long> {

    @Query("select l from LoggedUser l where l.email = :userEmail")
    LoggedUser findByUserEmail(@Param("userEmail") String userEmail);

    @Override
    List<LoggedUser> findAll();

    @Override
    void deleteById(Long aLong);
}