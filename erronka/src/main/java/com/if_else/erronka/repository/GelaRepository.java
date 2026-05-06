package com.if_else.erronka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.if_else.erronka.model.Gela;

@Repository
public interface GelaRepository extends JpaRepository<Gela, Integer> {
    List<Gela> findByGelaZenbakia(int gelaZenbakia);
}
