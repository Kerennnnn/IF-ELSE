package com.if_else.erronka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.if_else.erronka.model.GailuElektronikoa;
import com.if_else.erronka.model.Gela;
import com.if_else.erronka.repository.GailuElektronikoaRepository;
import com.if_else.erronka.repository.GelaRepository;

@Service
public class GailuElektronikoakService {
    private final GailuElektronikoaRepository gailuElektronikoaRepository;
    private final GelaRepository gelaRepository;

    public GailuElektronikoakService(GailuElektronikoaRepository gailuElektronikoaRepository,
            GelaRepository gelaRepository) {
        this.gailuElektronikoaRepository = gailuElektronikoaRepository;
        this.gelaRepository = gelaRepository;
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

    public GailuElektronikoa gailua(Integer id) {
        if (id != null) {
            return gailuElektronikoaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Gailua ez da existitzen"));
        } else {
            return new GailuElektronikoa();
        }
    }

    public void gailuaGorde(GailuElektronikoa gailuElektronikoa) {
        Integer gelaId = gailuElektronikoa.getGela().getIdGela();

        Gela gela = gelaRepository.findById(gelaId)
                .orElseThrow(() -> new RuntimeException("Gela ez da existitzen"));
        gailuElektronikoa.setGela(gela);

        gailuElektronikoaRepository.save(gailuElektronikoa);
    }

    public List<Gela> gelak() {
        return gelaRepository.findAll();
    }

}
