package com.apprentice.gestionProjet.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projet")

public class Projet extends BaseEntity{


    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;

    @Column(name = "budget")
    private Integer budget;

    @OneToMany(mappedBy = "projet")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Depense> depenses;

    @OneToMany(mappedBy = "projet")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<ProjetOuvrier> projetOuvriers;

    @OneToMany(mappedBy = "projet")
    List<Sortie> sorties;

}