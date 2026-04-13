package com.if_else.erronka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.if_else.erronka.model.GailuElektronikoa;

@Repository
public interface GailuElektronikoaRepository extends JpaRepository<GailuElektronikoa, Integer> {

}
