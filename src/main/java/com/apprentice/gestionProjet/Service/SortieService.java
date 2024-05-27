package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.SortieDto;
import com.apprentice.gestionProjet.Entity.Sortie;

import java.util.List;

public interface SortieService {

    public SortieDto saveSortie(SortieDto sortieDto, Integer idProjet );

    public SortieDto updateSortie(SortieDto sortieDto, Integer idSortie);

    public SortieDto GetOneSortie(Integer idSortie);

    public List<SortieDto> getAllSortie();

    public void deleteSortie(Integer idSortie);
}
