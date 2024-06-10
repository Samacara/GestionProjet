package com.apprentice.gestionProjet.DTO;


import com.apprentice.gestionProjet.Entity.Depense;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepenseDto{
    private Integer id;

    private String motif;

    private Integer montant;

    private LocalDate dateModification;

    private LocalDate dateCreation;

    private ProjetDto projet;


    public static DepenseDto fromEntity(Depense depense){
        return DepenseDto.builder()
                .id(depense.getId())
                .dateCreation(depense.getDateCreation())
                .dateModification(depense.getDateModification())
                .montant(depense.getMontant())
                .motif(depense.getMotif())
                .projet(ProjetDto.fromEntity(depense.getProjet()))
                .build();
    }
    public static Depense toEntity(DepenseDto depenseDto){
        return Depense.builder()
                .id(depenseDto.getId())
                .montant(depenseDto.getMontant())
                .motif(depenseDto.getMotif())
                .projet(ProjetDto.toEntity(depenseDto.getProjet()))
                .build();
    }
}
