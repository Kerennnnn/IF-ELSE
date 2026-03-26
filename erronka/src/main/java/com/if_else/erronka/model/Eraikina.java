package com.if_else.erronka.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "eraikina")
public class Eraikina {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_eraikina;

    private String eraikin_izena;
    private String kokapena;

    @OneToMany(mappedBy="eraikina")
    private ArrayList<Solairua> solairuak;

    public Eraikina(String eraikin_izena, int id_eraikina, String kokapena, ArrayList<Solairua> solairuak) {
        this.eraikin_izena = eraikin_izena;
        this.id_eraikina = id_eraikina;
        this.kokapena = kokapena;
        this.solairuak = solairuak;
    }

    public int getId_eraikina() {
        return id_eraikina;
    }

    public void setId_eraikina(int id_eraikina) {
        this.id_eraikina = id_eraikina;
    }

    public String getEraikin_izena() {
        return eraikin_izena;
    }

    public void setEraikin_izena(String eraikin_izena) {
        this.eraikin_izena = eraikin_izena;
    }

    public String getKokapena() {
        return kokapena;
    }

    public void setKokapena(String kokapena) {
        this.kokapena = kokapena;
    }

    public ArrayList<Solairua> getSolairuak() {
        return solairuak;
    }

    public void setSolairuak(ArrayList<Solairua> solairuak) {
        this.solairuak = solairuak;
    }


}