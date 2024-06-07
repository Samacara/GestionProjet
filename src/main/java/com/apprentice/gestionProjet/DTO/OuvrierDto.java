package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.Ouvrier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OuvrierDto {
    private Integer id;
    private String nom;
    private String adresse;
    private String localisation;
    private LocalDate dateModification;
    private LocalDate dateCreation;


    public static OuvrierDto fromEntity(Ouvrier ouvrier){
        return OuvrierDto.builder()
                .id(ouvrier.getId())
                .dateCreation(ouvrier.getDateCreation())
                .dateModification(ouvrier.getDateModification())
                .nom(ouvrier.getNom())
                .adresse(ouvrier.getAdresse())
                .localisation(ouvrier.getLocalisation())
                .build();
    }

    public static Ouvrier toEntity(OuvrierDto ouvrierDto){
        return Ouvrier.builder()
                .id(ouvrierDto.getId())
                .nom(ouvrierDto.getNom())
                .adresse(ouvrierDto.getAdresse())
                .localisation(ouvrierDto.getLocalisation())
                .build();
    }
}
