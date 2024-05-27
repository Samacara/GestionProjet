package com.apprentice.gestionProjet.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ouvrier")

public class Ouvrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
