package com.bcp.exchange.infrastructure.repository;

import com.bcp.exchange.infrastructure.repository.entities.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserBank,Long> {
    Optional<UserBank> findByUsername (String username);
}

