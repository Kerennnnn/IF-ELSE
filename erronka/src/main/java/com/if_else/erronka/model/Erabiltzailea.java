package com.if_else.erronka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "erabiltzailea")
public class Erabiltzailea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_erabiltzailea;

    private String izena;
    private String abizena;
    private int telefonoa;
    private String pasahitza;
    private String erabiltzaile_izena;
    private String posta_kodea;
    
    @ManyToOne
    @JoinColumn(name = "id_rola")
    private Rola rola;

    public Erabiltzailea(String abizena, String erabiltzaile_izena, int id_erabiltzailea, String izena, String pasahitza, String posta_kodea, Rola rola, int telefonoa) {
        this.abizena = abizena;
        this.erabiltzaile_izena = erabiltzaile_izena;
        this.id_erabiltzailea = id_erabiltzailea;
        this.izena = izena;
        this.pasahitza = pasahitza;
        this.posta_kodea = posta_kodea;
        this.rola = rola;
        this.telefonoa = telefonoa;
    }

    public int getId_erabiltzailea() {
        return id_erabiltzailea;
    }

    public void setId_erabiltzailea(int id_erabiltzailea) {
        this.id_erabiltzailea = id_erabiltzailea;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    public int getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(int telefonoa) {
        this.telefonoa = telefonoa;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public String getErabiltzaile_izena() {
        return erabiltzaile_izena;
    }

    public void setErabiltzaile_izena(String erabiltzaile_izena) {
        this.erabiltzaile_izena = erabiltzaile_izena;
    }

    public String getPosta_kodea() {
        return posta_kodea;
    }

    public void setPosta_kodea(String posta_kodea) {
        this.posta_kodea = posta_kodea;
    }

    public Rola getRola() {
        return rola;
    }

    public void setRola(Rola rola) {
        this.rola = rola;
    }


}
