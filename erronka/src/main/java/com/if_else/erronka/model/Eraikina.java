package com.if_else.erronka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "eraikina")
public class Eraikina {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_eraikina;
    private String eraikin_izena;
    private String kokapena;

    public Eraikina(int id_eraikina, String eraikin_izena, String kokapena) {
        this.id_eraikina = id_eraikina;
        this.eraikin_izena = eraikin_izena;
        this.kokapena = kokapena;
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
}
