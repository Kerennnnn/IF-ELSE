package com.if_else.erronka.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Administrazioa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrazioa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdministrazioa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gailu_elektronikoa")
    private GailuElektronikoa gailuElektronikoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_erabiltzailea")
    private Erabiltzailea erabiltzailea;

    @Column(name = "egindako_aldaketak")
    private String egindakoAldaketak;

    @Column(name = "aldaketa_data")
    private LocalDate aldaketaData;

}
