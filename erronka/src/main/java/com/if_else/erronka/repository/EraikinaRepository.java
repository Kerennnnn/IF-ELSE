package com.if_else.erronka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.if_else.erronka.model.Eraikina;

@Repository
public interface EraikinaRepository extends JpaRepository<Eraikina, Integer> {
    List<Eraikina> findByEraikinIzenaContainingOrKokapenaContaining(String eraikinIzena, String kokapena);
}
