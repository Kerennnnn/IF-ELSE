package com.if_else.erronka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rola")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRola;

    private String izena;

}
