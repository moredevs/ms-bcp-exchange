package com.bcp.exchange.infrastructure.repository;

import com.bcp.exchange.infrastructure.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

