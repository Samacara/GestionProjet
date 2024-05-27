package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.ProduitDto;

import java.util.List;

public interface ProduitService {

    public List<ProduitDto> getAllProduit();

    public ProduitDto saveProduit( Integer idCategorie,ProduitDto produitDto);

    public ProduitDto UpdateProduit(ProduitDto produitDto, Integer idProduit);

    public ProduitDto getOneProduit(Integer idProduit);

    public Integer getStockByProduit(Integer idProduit);

    public ProduitDto soustractionStock(Integer idProduit, Integer quantiteASoustraire);

    public void deleteProduit(Integer idProduit);
}
