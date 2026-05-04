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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "solairua")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Solairua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolairua;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_eraikina")
    @NotNull(message = "Mesedez, eraikin bat sartu")
    private Eraikina eraikina;

    @Column(name = "solairu_zenbakia")
    @NotBlank(message = "Mesedez, solairu zenbakia sartu")
    @Min(0)
    @Max(120)
    private int solairuZenbakia;

    @OneToMany(mappedBy = "solairua")
    private List<Gela> gelak;

}