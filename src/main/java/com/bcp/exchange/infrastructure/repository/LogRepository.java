package com.bcp.exchange.infrastructure.repository;

import com.bcp.exchange.infrastructure.repository.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,Long> {
}

