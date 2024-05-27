package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.ProduitDto;
import com.apprentice.gestionProjet.Entity.Produit;
import com.apprentice.gestionProjet.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class ProduitServiceImpl implements ProduitService{

    private ProduitRepository produitRepository;
    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public List<ProduitDto> getAllProduit() {
        List<Produit> datas = produitRepository.findAll();
        List<ProduitDto> list= new ArrayList<>();
        for (Produit pr: datas){
            list.add(ProduitDto.fromEntity(pr));
        }

        return list;
    }

    @Override
    public ProduitDto saveProduit(Integer idCategorie, ProduitDto produitDto) {
        Produit pr = produitRepository.save(ProduitDto.toEntity(produitDto));
        return ProduitDto.fromEntity(pr);
    }

    @Override
    public ProduitDto UpdateProduit(ProduitDto produitDto, Integer idProduit) {
        Produit foundProduit = produitRepository.findById(idProduit).get();
        if (foundProduit !=null){
            foundProduit.setNomProduit(produitDto.getNomProduit());
            foundProduit.setId(produitDto.getId());
            foundProduit.setDesignation(produitDto.getDesignation());
            foundProduit.setStock(produitDto.getStock());
            foundProduit.setCategorie(ProduitDto.toEntity(produitDto).getCategorie());

            Produit pro = produitRepository.save(ProduitDto.toEntity(produitDto));
            return ProduitDto.fromEntity(pro);
        }
        return null;
    }

    @Override
    public ProduitDto getOneProduit(Integer idProduit) {

        Produit pro = produitRepository.findById(idProduit).get();
        return ProduitDto.fromEntity(pro);
    }

    @Override
    public Integer getStockByProduit(Integer idProduit) {
        Produit pr = produitRepository.findById(idProduit)
                .orElseThrow(() -> new IllegalArgumentException("le produit n'existe pas"));
        return pr.getStock();
    }

    @Override
    public ProduitDto soustractionStock(Integer idProduit, Integer quantiteASoustraire) {
        Produit pro = produitRepository.findById(idProduit)
                .orElseThrow(() -> new IllegalArgumentException("Produit non trouvé"));
        int stockRestant = pro.getStock() - quantiteASoustraire;

        if (stockRestant >= 0){
            pro.setStock(stockRestant);

            Produit pr= produitRepository.save(pro);
            return ProduitDto.fromEntity(pr);
        } else {
            throw new IllegalArgumentException("La quantité à soustraire dépasse le stock disponible.");
        }
    }

    @Override
    public void deleteProduit(Integer idProduit) {

        produitRepository.deleteById(idProduit);

    }
}
