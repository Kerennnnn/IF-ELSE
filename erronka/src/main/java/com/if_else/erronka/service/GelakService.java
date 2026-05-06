package com.if_else.erronka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.if_else.erronka.model.Gela;
import com.if_else.erronka.model.Solairua;
import com.if_else.erronka.repository.GelaRepository;
import com.if_else.erronka.repository.SolairuaRepository;

@Service
public class GelakService {
    private final GelaRepository gelaRepository;
    private final SolairuaRepository solairuaRepository;

    public GelakService(GelaRepository gelaRepository, SolairuaRepository solairuaRepository) {
        this.gelaRepository = gelaRepository;
        this.solairuaRepository = solairuaRepository;
    }

    public List<Gela> gelakFiltratu(Integer search) {
        if (search != null) {
            return gelaRepository.findByGelaZenbakia(search);
        } else {
            return gelaRepository.findAll();
        }
    }

    public void gelaEzabatu(int id) {
        gelaRepository.deleteById(id);
    }

    public Gela gela(Integer id) {
        if (id != null) {
            return gelaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Gela ez da existitzen"));
        } else {
            return new Gela();
        }
    }

    public void gelaGorde(Gela gela) {
        Integer solairuaId = gela.getSolairua().getIdSolairua();

        Solairua solairua = solairuaRepository.findById(solairuaId)
                .orElseThrow(() -> new RuntimeException("Solairua ez da existitzen"));
        gela.setSolairua(solairua);

        gelaRepository.save(gela);
    }

    public List<Solairua> solairuak() {
        return solairuaRepository.findAll();
    }

}
