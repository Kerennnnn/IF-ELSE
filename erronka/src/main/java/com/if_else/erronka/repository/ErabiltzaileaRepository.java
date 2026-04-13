package com.if_else.erronka.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.if_else.erronka.model.Erabiltzailea;

@Repository
public interface ErabiltzaileaRepository extends JpaRepository<Erabiltzailea, Integer> {
    Optional<Erabiltzailea> findByErabiltzaileIzena(String erabiltzaileIzena);
}
