package com.if_else.erronka.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "erabiltzailea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Erabiltzailea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idErabiltzailea;

    private String izena;
    private String abizena;
    private int telefonoa;
    private String pasahitza;

    @Column(name = "erabiltzaile_izena")
    private String erabiltzaileIzena;

    @Column(name = "posta_kodea")
    private String postaKodea;

    @ManyToOne
    @JoinColumn(name = "id_rola")
    private Rola rola;

    @OneToMany(mappedBy = "erabiltzailea")
    private List<Administrazioa> administrazioak;

}
