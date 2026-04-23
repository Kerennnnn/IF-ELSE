package com.if_else.erronka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.if_else.erronka.model.GailuElektronikoa;

@Repository
public interface GailuElektronikoaRepository extends JpaRepository<GailuElektronikoa, Integer> {
    List<GailuElektronikoa> findByEgoera(String egoera);

    List<GailuElektronikoa> findByIzenaContainingOrMarkaContaining(String izena, String marka);

    long countByEgoera(String egoera);

}
