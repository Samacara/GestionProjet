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
@Table(name = "sortie")
public class Sortie extends BaseEntity{


    private String intitule;

    @ManyToOne
    @JoinColumn(name = "idProjet")
    private Projet projet;

    @OneToMany(mappedBy = "sortie")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    List<SortieProduit>sortieProduits ;
}
