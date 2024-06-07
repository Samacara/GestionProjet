package com.apprentice.gestionProjet.DTO;


import com.apprentice.gestionProjet.Entity.ProjetOuvrier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProjetOuvrierDto {

    private Integer id;
    private Integer salaire;
    private Integer regler;
    private ProjetDto  projet;
    private OuvrierDto ouvrier;
    private LocalDate dateModification;
    private LocalDate dateCreation;

    public static ProjetOuvrierDto fromEntity(ProjetOuvrier projetOuvrier){

        return ProjetOuvrierDto.builder()
                .id(projetOuvrier.getId())
                .dateCreation(projetOuvrier.getDateCreation())
                .dateModification(projetOuvrier.getDateModification())
                .salaire(projetOuvrier.getSalaire())
                .regler(projetOuvrier.getRegler())
                .projet(ProjetDto.fromEntity(projetOuvrier.getProjet()))
                .ouvrier(OuvrierDto.fromEntity(projetOuvrier.getOuvrier()))
                .build();

    }

    public static ProjetOuvrier toEntity(ProjetOuvrierDto projetOuvrierDto){

        return ProjetOuvrier.builder()
                .id(projetOuvrierDto.getId())
                .salaire(projetOuvrierDto.getSalaire())
                .regler(projetOuvrierDto.getRegler())
                .ouvrier(OuvrierDto.toEntity(projetOuvrierDto.getOuvrier()))
                .projet(ProjetDto.toEntity(projetOuvrierDto.getProjet()))
                .build();

    }
}
