package com.if_else.erronka.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "gailu_elektronikoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GailuElektronikoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGailuElektronikoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gela")
    private Gela gela;

    private String izena;
    private String mota;
    private String marka;
    private String modelo;
    private String serie;
    private String egoera;
    private String deskribapena;

    @Column(name = "garantia_amaiera")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate garantiaAmaiera;

    @Column(name = "erosketa_data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate erosketaData;

    @OneToMany(mappedBy = "gailuElektronikoa")
    private List<Administrazioa> administrazioak;

}
