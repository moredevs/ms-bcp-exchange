package com.bcp.exchange.infrastructure.security;

import com.bcp.exchange.application.domains.entity.UserMain;
import com.bcp.exchange.infrastructure.repository.UserRepository;
import com.bcp.exchange.infrastructure.repository.entities.UserBank;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserBank> userBank = repository.findByUsername(username);
        if (!userBank.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return UserMain.build(userBank.get());
    }
}
