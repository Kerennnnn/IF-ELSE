package com.if_else.erronka.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Gela")
public class Gela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_gela;

    @ManyToOne
    @JoinColumn(name = "id_solairua")
    private Solairua solairua;

    private int gela_zenbakia;

    @OneToMany(mappedBy = "gela")
    private ArrayList<GailuElektronikoa> gailuElektronikoak;

    public Gela(ArrayList<GailuElektronikoa> gailuElektronikoak, int gela_zenbakia, int id_gela, Solairua solairua) {
        this.gailuElektronikoak = gailuElektronikoak;
        this.gela_zenbakia = gela_zenbakia;
        this.id_gela = id_gela;
        this.solairua = solairua;
    }

    public int getId_gela() {
        return id_gela;
    }

    public void setId_gela(int id_gela) {
        this.id_gela = id_gela;
    }

    public Solairua getSolairua() {
        return solairua;
    }

    public void setSolairua(Solairua solairua) {
        this.solairua = solairua;
    }

    public int getGela_zenbakia() {
        return gela_zenbakia;
    }

    public void setGela_zenbakia(int gela_zenbakia) {
        this.gela_zenbakia = gela_zenbakia;
    }

    public ArrayList<GailuElektronikoa> getGailuElektronikoak() {
        return gailuElektronikoak;
    }

    public void setGailuElektronikoak(ArrayList<GailuElektronikoa> gailuElektronikoak) {
        this.gailuElektronikoak = gailuElektronikoak;
    }

}