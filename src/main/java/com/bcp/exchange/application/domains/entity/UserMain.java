package com.bcp.exchange.application.domains.entity;

import com.bcp.exchange.infrastructure.repository.entities.UserBank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class UserMain implements UserDetails {


    private String username;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;


    public UserMain(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserMain build(UserBank userBank){
        List<GrantedAuthority> authorities =
                userBank.getRoles()
                        .stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toList());
        return new UserMain(userBank.getUsername(),
                userBank.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
