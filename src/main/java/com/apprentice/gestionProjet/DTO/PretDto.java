package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.Pret;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class PretDto {
    private Integer id;
    private String nomBanque;
    private String motif;
    private Integer montant;
    private Integer rembousser;
    private String date;
    private LocalDate dateModification;
    private LocalDate dateCreation;

    public static  PretDto fromEntity(Pret pret){
        return PretDto.builder()
                .id(pret.getId())
                .dateCreation(pret.getDateCreation())
                .dateModification(pret.getDateModification())
                .nomBanque(pret.getNomBanque())
                .motif(pret.getMotif())
                .montant(pret.getMontant())
                .rembousser(pret.getRembousser())
                .date(String.valueOf(pret.getDate()))
                .build();
    }

    public static Pret toEntity(PretDto pretDto){
        return Pret.builder()
                .id(pretDto.getId())
                .nomBanque(pretDto.getNomBanque())
                .motif(pretDto.getMotif())
                .montant(pretDto.getMontant())
                .rembousser(pretDto.getRembousser())
                .date(LocalDate.parse(pretDto.getDate()))
                .build();
    }
}
