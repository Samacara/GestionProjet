package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.Ouvrier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OuvrierDto {
    private Integer id;
    private String nom;
    private String adresse;
    private String localisation;
    private Integer salaire;

    public static OuvrierDto fromEntity(Ouvrier ouvrier){
        return OuvrierDto.builder()
                .id(ouvrier.getId())
                .nom(ouvrier.getNom())
                .adresse(ouvrier.getAdresse())
                .localisation(ouvrier.getLocalisation())
                .salaire(ouvrier.getSalaire())
                .build();
    }

    public static Ouvrier toEntity(OuvrierDto ouvrierDto){
        return Ouvrier.builder()
                .id(ouvrierDto.getId())
                .nom(ouvrierDto.getNom())
                .adresse(ouvrierDto.getAdresse())
                .localisation(ouvrierDto.getLocalisation())
                .salaire(ouvrierDto.getSalaire())
                .build();
    }
}
