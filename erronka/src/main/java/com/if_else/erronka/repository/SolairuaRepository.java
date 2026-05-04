package com.if_else.erronka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.if_else.erronka.model.Solairua;

@Repository
public interface SolairuaRepository extends JpaRepository<Solairua, Integer> {
    List<Solairua> findBySolairuZenbakiaContaining(int solairuZenbakia);
}
