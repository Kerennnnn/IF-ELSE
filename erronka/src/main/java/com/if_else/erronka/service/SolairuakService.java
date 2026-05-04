package com.if_else.erronka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.if_else.erronka.model.Eraikina;
import com.if_else.erronka.model.Solairua;
import com.if_else.erronka.repository.EraikinaRepository;
import com.if_else.erronka.repository.SolairuaRepository;

@Service
public class SolairuakService {
    private final SolairuaRepository solairuaRepository;
    private final EraikinaRepository eraikinaRepository;

    public SolairuakService(SolairuaRepository solairuaRepository, EraikinaRepository eraikinaRepository) {
        this.solairuaRepository = solairuaRepository;
        this.eraikinaRepository = eraikinaRepository;
    }

    public List<Solairua> solairuakFiltratu(Integer search) {
        if (search != null) {
            return solairuaRepository.findBySolairuZenbakia(search);
        } else {
            return solairuaRepository.findAll();
        }
    }

    public void solairuaEzabatu(int id) {
        solairuaRepository.deleteById(id);
    }

    public Solairua solairua(Integer id) {
        if (id != null) {
            return solairuaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Solairua ez da existitzen"));
        } else {
            return new Solairua();
        }
    }

    public void solairuaGorde(Solairua solairua) {
        Integer eraikinaId = solairua.getEraikina().getIdEraikina();

        Eraikina eraikina = eraikinaRepository.findById(eraikinaId)
                .orElseThrow(() -> new RuntimeException("Eraikina ez da existitzen"));
        solairua.setEraikina(eraikina);

        solairuaRepository.save(solairua);
    }

    public List<Eraikina> eraikinak() {
        return eraikinaRepository.findAll();
    }
}
