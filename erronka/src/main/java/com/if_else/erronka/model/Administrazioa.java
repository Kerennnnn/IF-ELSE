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
@Table(name = "Administrazioa")
public class Administrazioa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_administrazioa;

    @ManyToOne
    @JoinColumn(name = "id_gailu_elektronikoa")
    private GailuElektronikoa gailuElektronikoa;

    @ManyToOne
    @JoinColumn(name = "id_erabiltzailea")
    private Erabiltzailea erabiltzailea;

    private String egindako_aldaketak;
    private LocalDate aldaketa_data;

    public Administrazioa(LocalDate aldaketa_data, String egindako_aldaketak, Erabiltzailea erabiltzailea,
            GailuElektronikoa gailuElektronikoa, int id_administrazioa) {
        this.aldaketa_data = aldaketa_data;
        this.egindako_aldaketak = egindako_aldaketak;
        this.erabiltzailea = erabiltzailea;
        this.gailuElektronikoa = gailuElektronikoa;
        this.id_administrazioa = id_administrazioa;
    }

    public int getId_administrazioa() {
        return id_administrazioa;
    }

    public void setId_administrazioa(int id_administrazioa) {
        this.id_administrazioa = id_administrazioa;
    }

    public GailuElektronikoa getGailuElektronikoa() {
        return gailuElektronikoa;
    }

    public void setGailuElektronikoa(GailuElektronikoa gailuElektronikoa) {
        this.gailuElektronikoa = gailuElektronikoa;
    }

    public Erabiltzailea getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(Erabiltzailea erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    public String getEgindako_aldaketak() {
        return egindako_aldaketak;
    }

    public void setEgindako_aldaketak(String egindako_aldaketak) {
        this.egindako_aldaketak = egindako_aldaketak;
    }

    public LocalDate getAldaketa_data() {
        return aldaketa_data;
    }

    public void setAldaketa_data(LocalDate aldaketa_data) {
        this.aldaketa_data = aldaketa_data;
    }

}
