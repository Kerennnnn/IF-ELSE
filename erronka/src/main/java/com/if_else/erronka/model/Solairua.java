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
@Table(name = "solairua")
public class Solairua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_solairua;

    @ManyToOne
    @JoinColumn(name = "id_eraikina")
    private Eraikina eraikina;

    private int solairu_zenbakia;

    @OneToMany(mappedBy = "solairua")
    private ArrayList<Gela> gelak;

    public Solairua(Eraikina eraikina, ArrayList<Gela> gelak, int id_solairua, int solairu_zenbakia) {
        this.eraikina = eraikina;
        this.gelak = gelak;
        this.id_solairua = id_solairua;
        this.solairu_zenbakia = solairu_zenbakia;
    }

    public int getId_solairua() {
        return id_solairua;
    }

    public void setId_solairua(int id_solairua) {
        this.id_solairua = id_solairua;
    }

    public Eraikina getEraikina() {
        return eraikina;
    }

    public void setEraikina(Eraikina eraikina) {
        this.eraikina = eraikina;
    }

    public int getSolairu_zenbakia() {
        return solairu_zenbakia;
    }

    public void setSolairu_zenbakia(int solairu_zenbakia) {
        this.solairu_zenbakia = solairu_zenbakia;
    }

    public ArrayList<Gela> getGelak() {
        return gelak;
    }

    public void setGelak(ArrayList<Gela> gelak) {
        this.gelak = gelak;
    }


}