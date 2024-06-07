package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.SortieProduit;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SortieProduitDto {

    private Integer id;
    private Integer quantite;
    private LocalDate dateModification;
    private LocalDate dateCreation;
    private SortieDto sortie;
    private ProduitDto produit;


    public static  SortieProduitDto fromEntity(SortieProduit sortieProduit){
        return SortieProduitDto.builder()
                .id(sortieProduit.getId())
                .dateCreation(sortieProduit.getDateCreation())
                .dateModification(sortieProduit.getDateModification())
                .quantite(sortieProduit.getQuantite())
                .produit(ProduitDto.fromEntity(sortieProduit.getProduit()))
                .sortie(SortieDto.fromEntity(sortieProduit.getSortie()))
                .build();

    }
    public static SortieProduit toEntity(SortieProduitDto sortieProduitDto){
        return SortieProduit.builder()
                .id(sortieProduitDto.getId())
                .quantite(sortieProduitDto.getQuantite())
                .produit(ProduitDto.toEntity( sortieProduitDto.getProduit()))
                .sortie(SortieDto.toEntity(sortieProduitDto.getSortie()))
                .build();
    }
}
