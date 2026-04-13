package com.if_else.erronka.model;

import java.util.List;

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
@Table(name = "Gela")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solairua")
    private Solairua solairua;

    @Column(name = "gela_zenbakia")
    private int gelaZenbakia;

    @OneToMany(mappedBy = "gela")
    private List<GailuElektronikoa> gailuElektronikoak;

}