package com.if_else.erronka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.if_else.erronka.model.Eraikina;
import com.if_else.erronka.repository.EraikinaRepository;

@Service
public class EraikinakService {
    private final EraikinaRepository eraikinaRepository;

    public EraikinakService(EraikinaRepository eraikinaRepository) {
        this.eraikinaRepository = eraikinaRepository;
    }

    public List<Eraikina> eraikinakFiltratu(String search) {
        if (search != null) {
            return eraikinaRepository.findByEraikinIzenaContainingOrKokapenaContaining(search, search);
        } else {
            return eraikinaRepository.findAll();
        }
    }

    public void eraikinaEzabatu(int id) {
        eraikinaRepository.deleteById(id);
    }

    public Eraikina eraikina(Integer id) {
        if (id != null) {
            return eraikinaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Eraikina ez da existitzen"));
        } else {
            return new Eraikina();
        }
    }

    public void eraikinaGorde(Eraikina eraikina) {
        eraikinaRepository.save(eraikina);
    }
}
