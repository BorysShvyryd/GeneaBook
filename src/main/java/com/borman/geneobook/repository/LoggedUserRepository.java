package com.borman.geneobook.repository;

import com.borman.geneobook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggedUserRepository extends JpaRepository<User, Long> {


}
