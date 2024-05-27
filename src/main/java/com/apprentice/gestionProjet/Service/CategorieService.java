package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.CategorieDto;

import java.util.List;

public interface CategorieService {

    public CategorieDto saveCategorie(CategorieDto categorieDto);

    public  CategorieDto updateCategorie(CategorieDto categorieDto, Integer idCategorie);

    public CategorieDto getCategorieById(Integer idCategorie);

    public List<CategorieDto> getAllCategorie();

    public void DeleteCategorie(Integer idCategorie);
}
