package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieDto {

    private  Integer id;
    private String description;
    private LocalDate dateModification;

    private LocalDate dateCreation;

    public static CategorieDto fromEntity(Categorie categorie){
        return CategorieDto.builder()
                .id(categorie.getId())
                .dateCreation(categorie.getDateCreation())
                .dateModification(categorie.getDateModification())
                .description(categorie.getDescription())
                .build();
    }
    public static Categorie toEntity(CategorieDto categorieDto){
        return Categorie.builder()
                .id(categorieDto.getId())
                .description(categorieDto.getDescription())
                .build();
    }
}
