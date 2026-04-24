package com.if_else.erronka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.if_else.erronka.model.GailuElektronikoa;
import com.if_else.erronka.repository.GailuElektronikoaRepository;

@Service
public class GailuElektronikoakService {
    private final GailuElektronikoaRepository gailuElektronikoaRepository;

    public GailuElektronikoakService(GailuElektronikoaRepository gailuElektronikoaRepository) {
        this.gailuElektronikoaRepository = gailuElektronikoaRepository;
    }

    public List<GailuElektronikoa> gailuakFiltratu(String search, String egoera) {
        if (egoera != null) {
            if (!egoera.equals("Egoera guztiak")) {
                return gailuElektronikoaRepository.findByEgoera(egoera);
            } else {
                return gailuElektronikoaRepository.findAll();
            }
        } else if (search != null) {
            return gailuElektronikoaRepository.findByIzenaContainingOrMarkaContaining(search, search);
        } else {
            return gailuElektronikoaRepository.findAll();
        }
    }

    public long gailuakKontatu(String egoera) {
        if (!egoera.equals("Egoera guztiak")) {
            return gailuElektronikoaRepository.countByEgoera(egoera);
        } else {
            return gailuElektronikoaRepository.count();
        }
    }

    public String gailuarenEgoera(String egoera) {
        if (egoera != null) {
            return egoera;
        } else {
            return "Egoera guztiak";
        }

    }

    public void gailuaEzabatu(int id) {
        gailuElektronikoaRepository.deleteById(id);
    }

}
