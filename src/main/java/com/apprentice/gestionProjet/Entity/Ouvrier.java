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
@Table(name = "ouvrierprojet")

public class Ouvrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String adresse;

    private String localisation;

    private Integer salaire;


    @OneToMany(mappedBy = "ouvrier")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Projet> projets;
}
