package com.apprentice.gestionProjet.DTO;


import com.apprentice.gestionProjet.Entity.Projet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjetDto {
    private Integer id;

    private String  libelle;
    private  String description;
    private  Integer budget;
    private LocalDate dateModification;
    private LocalDate dateCreation;


    public static ProjetDto fromEntity(Projet projet){
        return ProjetDto.builder()
                .id(projet.getId())
                .dateCreation(projet.getDateCreation())
                .dateModification(projet.getDateModification())
                .libelle(projet.getLibelle())
                .description(projet.getDescription())
                .budget(projet.getBudget())
                .build();

    }

    public static Projet toEntity(ProjetDto projetDto){
        return Projet.builder()

                .id(projetDto.getId())
                .libelle(projetDto.getLibelle())
                .description(projetDto.getDescription())
                .budget(projetDto.getBudget())
                .build();
    }
}