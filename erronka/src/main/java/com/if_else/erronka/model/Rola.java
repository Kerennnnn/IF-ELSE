package com.if_else.erronka.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rola")
public class Rola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rola;
    private String izena;
    @OneToMany(mappedBy = "rola")
    private ArrayList<Erabiltzailea> erabiltzaileak;

    public Rola(ArrayList<Erabiltzailea> erabiltzaileak, int id_rola, String izena) {
        this.erabiltzaileak = erabiltzaileak;
        this.id_rola = id_rola;
        this.izena = izena;
    }

    public int getId_rola() {
        return id_rola;
    }

    public void setId_rola(int id_rola) {
        this.id_rola = id_rola;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public ArrayList<Erabiltzailea> getErabiltzaileak() {
        return erabiltzaileak;
    }

    public void setErabiltzaileak(ArrayList<Erabiltzailea> erabiltzaileak) {
        this.erabiltzaileak = erabiltzaileak;
    }

}
