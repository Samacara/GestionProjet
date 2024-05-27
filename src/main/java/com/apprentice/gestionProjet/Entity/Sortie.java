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
@Table(name = "sortie")
public class Sortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String intitule;

    @ManyToOne
    @JoinColumn(name = "idProjet")
    private Projet projet;

    @OneToMany(mappedBy = "sortie")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    List<SortieProduit>sortieProduits ;
}
