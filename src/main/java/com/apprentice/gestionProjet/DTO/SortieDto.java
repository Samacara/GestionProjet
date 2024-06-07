package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.Sortie;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SortieDto {
    private Integer id;
    private String intitule;
    private LocalDate dateModification;
    private LocalDate dateCreation;
    private ProjetDto projet;

    public static SortieDto fromEntity(Sortie sortie){
        return SortieDto.builder()
                .id(sortie.getId())
                .dateCreation(sortie.getDateCreation())
                .dateModification(sortie.getDateModification())
                .intitule(sortie.getIntitule())
                .projet(ProjetDto.fromEntity(sortie.getProjet()))
                .build();
    }

    public static Sortie toEntity(SortieDto sortieDto){
        return Sortie.builder()
                .id(sortieDto.getId())
                .intitule(sortieDto.getIntitule())
                .projet(ProjetDto.toEntity(sortieDto.getProjet()))
                .build();
    }
}
