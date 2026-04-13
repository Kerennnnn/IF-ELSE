package com.if_else.erronka.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.if_else.erronka.model.Erabiltzailea;
import com.if_else.erronka.repository.ErabiltzaileaRepository;
import com.if_else.erronka.security.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ErabiltzaileaRepository erabiltzaileRepository;

    public CustomUserDetailsService(ErabiltzaileaRepository erabiltzaileRepository) {
        this.erabiltzaileRepository = erabiltzaileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        Erabiltzailea erabiltzailea = erabiltzaileRepository
                .findByErabiltzaileIzena(username)
                .orElseThrow(() -> new UsernameNotFoundException("Erabiltzailea ez da existitzen!"));

        return new CustomUserDetails(erabiltzailea);
    }
}
