package com.bcp.exchange.application.ports.out;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepositoryPort {
    UserDetails loadUserByUsername(String username);
}
