package com.borman.geneobook.repository;

import com.borman.geneobook.entity.LoggedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggedUserRepository extends JpaRepository<LoggedUser, Long> {


}
