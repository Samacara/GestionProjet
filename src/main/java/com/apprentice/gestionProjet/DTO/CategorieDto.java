package com.apprentice.gestionProjet.DTO;

import com.apprentice.gestionProjet.Entity.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieDto {

    private  Integer id;
    private String description;

    public static CategorieDto fromEntity(Categorie categorie){
        return CategorieDto.builder()
                .id(categorie.getId())
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
