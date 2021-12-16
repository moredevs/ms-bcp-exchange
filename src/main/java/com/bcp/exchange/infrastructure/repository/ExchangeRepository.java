package com.bcp.exchange.infrastructure.repository;

import com.bcp.exchange.infrastructure.repository.entities.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange,Long> {
 }

