package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.ReglementPret;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReglementPretDto {

    private Integer id;
    private  Integer montantReglement;
    private PretDto pret;

    public static  ReglementPretDto fromEntity(ReglementPret reglementPret){
        return ReglementPretDto.builder()
                .id(reglementPret.getId())
                .montantReglement(reglementPret.getMontantReglement())
                .pret(PretDto.fromEntity(reglementPret.getPret()))
                .build();
    }

    public static ReglementPret toEntity(ReglementPretDto reglementPretDto){
        return ReglementPret.builder()
                .id(reglementPretDto.getId())
                .montantReglement(reglementPretDto.getMontantReglement())
                .pret(PretDto.toEntity(reglementPretDto.getPret()))
                .build();

    }
}
