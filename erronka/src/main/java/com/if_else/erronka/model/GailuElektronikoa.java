package com.if_else.erronka.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gailu_elektronikoa")
public class GailuElektronikoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_gailu_elektronikoa;

    @ManyToOne
    @JoinColumn(name = "id_gela")
    private Gela gela;

    private String mota;
    private String marka;
    private LocalDate garantia_amaiera;
    private LocalDate erosketa_data;

    public GailuElektronikoa(LocalDate erosketa_data, LocalDate garantia_amaiera, Gela gela, int id_gailu_elektronikoa,
            String marka, String mota) {
        this.erosketa_data = erosketa_data;
        this.garantia_amaiera = garantia_amaiera;
        this.gela = gela;
        this.id_gailu_elektronikoa = id_gailu_elektronikoa;
        this.marka = marka;
        this.mota = mota;
    }

    public int getId_gailu_elektronikoa() {
        return id_gailu_elektronikoa;
    }

    public void setId_gailu_elektronikoa(int id_gailu_elektronikoa) {
        this.id_gailu_elektronikoa = id_gailu_elektronikoa;
    }

    public Gela getGela() {
        return gela;
    }

    public void setGela(Gela gela) {
        this.gela = gela;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public LocalDate getGarantia_amaiera() {
        return garantia_amaiera;
    }

    public void setGarantia_amaiera(LocalDate garantia_amaiera) {
        this.garantia_amaiera = garantia_amaiera;
    }

    public LocalDate getErosketa_data() {
        return erosketa_data;
    }

    public void setErosketa_data(LocalDate erosketa_data) {
        this.erosketa_data = erosketa_data;
    }

}
