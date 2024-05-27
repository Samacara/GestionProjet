package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.Pret;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class PretDto {
    private Integer id;
    private String nomBanque;
    private String motif;
    private Integer montant;
    private Integer rembousser;
    private Date date;

    public static  PretDto fromEntity(Pret pret){
        return PretDto.builder()
                .id(pret.getId())
                .nomBanque(pret.getNomBanque())
                .motif(pret.getMotif())
                .montant(pret.getMontant())
                .rembousser(pret.getRembousser())
                .date(pret.getDate())
                .build();
    }

    public static Pret toEntity(PretDto pretDto){
        return Pret.builder()
                .id(pretDto.getId())
                .nomBanque(pretDto.getNomBanque())
                .motif(pretDto.getMotif())
                .montant(pretDto.getMontant())
                .rembousser(pretDto.getRembousser())
                .date(pretDto.getDate())
                .build();
    }
}
