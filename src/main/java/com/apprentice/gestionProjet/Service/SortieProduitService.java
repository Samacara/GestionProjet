package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.SortieProduitDto;

import java.util.List;

public interface SortieProduitService {

    public SortieProduitDto saveSortieProduit(SortieProduitDto sortieProduitDto, Integer idSortie, Integer idProduit);

    public SortieProduitDto UpdateSortieProduit(SortieProduitDto sortieProduitDto, Integer idSortieProduit);

    public SortieProduitDto getOneSortieProduit(Integer idSortieProduit);

    public List<SortieProduitDto> getAllSortieProduit();

    public void deleteSortieProduit(Integer idSortieProduit);
}
