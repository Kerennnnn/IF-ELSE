package com.if_else.erronka.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "eraikina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Eraikina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEraikina;

    @Column(name = "eraikin_izena")
    private String eraikinIzena;

    private String kokapena;

    @OneToMany(mappedBy = "eraikina")
    private List<Solairua> solairuak;

}