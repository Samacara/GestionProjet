package com.apprentice.gestionProjet.DTO;


import com.apprentice.gestionProjet.Entity.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProduitDto {

    private Integer id;

    private String nomProduit;
    private String designation;
    private Integer stock;
    private CategorieDto categorie;
    private LocalDate dateModification;
    private LocalDate dateCreation;

    public static ProduitDto fromEntity(Produit produit){
        return ProduitDto.builder()
                .id(produit.getId())
                .dateCreation(produit.getDateCreation())
                .dateModification(produit.getDateModification())
                .nomProduit(produit.getNomProduit())
                .designation(produit.getDesignation())
                .stock(produit.getStock())
                .categorie(CategorieDto.fromEntity(produit.getCategorie()))
                .build();
    }

    public static  Produit toEntity(ProduitDto produitDto){
        return Produit.builder()
                .id(produitDto.getId())
                .nomProduit(produitDto.getNomProduit())
                .designation(produitDto.getDesignation())
                .stock((produitDto.getStock()))
                .categorie(CategorieDto.toEntity(produitDto.getCategorie()))
                .build();

    }

}
