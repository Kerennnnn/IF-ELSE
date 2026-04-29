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
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "Mesedez, gela bat sartu")
    private Gela gela;

    @NotBlank(message = "Mesedez, izena sartu")
    @Size(max = 50, message = "Gehienez 50 karaktere")
    private String izena;

    @NotBlank(message = "Mesedez, mota bat sartu")
    @Size(max = 20, message = "Gehienez 20 karaktere")
    private String mota;

    @NotBlank(message = "Mesedez, marka bat sartu")
    @Size(max = 20, message = "Gehienez 20 karaktere")
    private String marka;

    @NotBlank(message = "Mesedez, modelo bat sartu")
    @Size(max = 20, message = "Gehienez 20 karaktere")
    private String modelo;

    @NotBlank(message = "Mesedez, serie bat sartu")
    @Size(max = 50, message = "Gehienez 50 karaktere")
    private String serie;

    @NotBlank(message = "Mesedez, egoera bat sartu")
    private String egoera;

    @NotBlank(message = "Mesedez, deskribapena bat sartu")
    @Size(max = 100, message = "Gehienez 100 karaktere")
    private String deskribapena;

    @Column(name = "garantia_amaiera")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Mesedez, data bat sartu")
    @Future(message = "Mesedez, sartu baliozko data bat (ezin da iraganekoa izan)")
    private LocalDate garantiaAmaiera;

    @Column(name = "erosketa_data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Mesedez, data bat sartu")
    @PastOrPresent(message = "Mesedez, sartu baliozko data bat (ezin da etorkizunekoa izan)")
    private LocalDate erosketaData;

    @OneToMany(mappedBy = "gailuElektronikoa")
    private List<Administrazioa> administrazioak;

}
