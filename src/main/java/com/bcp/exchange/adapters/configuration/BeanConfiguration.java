package com.bcp.exchange.adapters.configuration;

import com.bcp.exchange.ExchangeApplication;
import com.bcp.exchange.adapters.persistance.ExchangeRepositoryImpl;
import com.bcp.exchange.adapters.persistance.LogRepositoryImpl;
import com.bcp.exchange.application.services.ExchangeService;
import com.bcp.exchange.application.services.LoggingService;
import com.bcp.exchange.infrastructure.repository.LogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ExchangeApplication.class)
public class BeanConfiguration {

    @Bean
    ExchangeService exchangeService(ExchangeRepositoryImpl repository) {
        return new ExchangeService(repository);
    }
    @Bean
    LoggingService loggingService(LogRepositoryImpl repository) {
        return new LoggingService(repository);
    }

}
