package com.if_else.erronka.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.if_else.erronka.model.Erabiltzailea;

public class CustomUserDetails implements UserDetails {

    private final Erabiltzailea erabiltzailea;

    public CustomUserDetails(Erabiltzailea erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(
                        erabiltzailea.getRola().getIzena()));
    }

    @Override
    public String getPassword() {
        return erabiltzailea.getPasahitza();
    }

    @Override
    public String getUsername() {
        return erabiltzailea.getErabiltzaileIzena();
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

    public Erabiltzailea getErabiltzailea() {
        return erabiltzailea;
    }
}
