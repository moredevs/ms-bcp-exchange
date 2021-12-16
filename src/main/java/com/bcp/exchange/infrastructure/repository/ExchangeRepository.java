package com.bcp.exchange.infrastructure.repository;

import com.bcp.exchange.infrastructure.repository.entities.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    Optional<Exchange> findByOriginCurrencyAndTargetCurrency(String originCurrency, String targetCurrency);
}

