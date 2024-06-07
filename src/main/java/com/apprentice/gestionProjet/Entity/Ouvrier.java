package com.apprentice.gestionProjet.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ouvrier")

public class Ouvrier extends BaseEntity {


    private String nom;

    private String adresse;

    private String localisation;


//
//    @ManyToOne
//    @JoinColumn(name = "idProjetOuvrier")
//    private ProjetOuvrier projetOuvrier;

    @OneToMany(mappedBy = "ouvrier")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<ProjetOuvrier> projetOuvriers;













//    @ManyToMany
//    @JoinTable(
//            name = "projet_ouvrier",
//            joinColumns = @JoinColumn(name = "idDepense"),
//            inverseJoinColumns = @JoinColumn(name = "idOuvrier"))
//    private List<Ouvrier> ouvriers;

//    @OneToMany(mappedBy = "ouvrier")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //private List<Projet> projets;
}
