package com.apprentice.gestionProjet.Service;

import com.apprentice.gestionProjet.DTO.ProduitDto;
import com.apprentice.gestionProjet.DTO.SortieDto;
import com.apprentice.gestionProjet.DTO.SortieProduitDto;
import com.apprentice.gestionProjet.Entity.Sortie;
import com.apprentice.gestionProjet.Entity.SortieProduit;
import com.apprentice.gestionProjet.Repository.SortieProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SortieProduitServiceImpl implements SortieProduitService{
    private SortieProduitRepository sortieProduitRepository;
    private SortieService sortieService;
    private ProduitService produitService;
    @Autowired
    public SortieProduitServiceImpl(SortieProduitRepository sortieProduitRepository, SortieService sortieService, ProduitService produitService) {
        this.sortieProduitRepository = sortieProduitRepository;
        this.sortieService = sortieService;
        this.produitService = produitService;
    }

    @Override
    public SortieProduitDto saveSortieProduit(SortieProduitDto sortieProduitDto, Integer idSortie, Integer idProduit) {

        ProduitDto foundProduit= produitService.getOneProduit(idProduit);
        SortieDto foundSortie = sortieService.GetOneSortie(idSortie);
        Integer nouveauStock= foundProduit.getStock() - sortieProduitDto.getQuantite();
        if (foundSortie !=null &&  nouveauStock >= 0){

            sortieProduitDto.setProduit(foundProduit);
            sortieProduitDto.setSortie(foundSortie);
            produitService.soustractionStock(foundProduit.getId(), sortieProduitDto.getQuantite());
            sortieProduitDto.setProduit(foundProduit);
            SortieProduit sp = sortieProduitRepository.save(SortieProduitDto.toEntity(sortieProduitDto) );
            return SortieProduitDto.fromEntity(sp);
        } else {
            throw new IllegalArgumentException("La quantité du produit excède le stock disponible pour ce produit.");
        }
    }

    @Override
    public SortieProduitDto UpdateSortieProduit(SortieProduitDto sortieProduitDto, Integer idSortieProduit) {

        SortieProduit foundSP= sortieProduitRepository.findById(idSortieProduit).get();
        if (foundSP !=null){
            foundSP.setId(sortieProduitDto.getId());
            foundSP.setQuantite(sortieProduitDto.getQuantite());
            foundSP.setSortie(SortieProduitDto.toEntity(sortieProduitDto).getSortie());
            foundSP.setProduit(SortieProduitDto.toEntity(sortieProduitDto).getProduit());

            SortieProduit sp= sortieProduitRepository.save(SortieProduitDto.toEntity(sortieProduitDto));
            return SortieProduitDto.fromEntity(sp);

        }
        return null;
    }

    @Override
    public SortieProduitDto getOneSortieProduit(Integer idSortieProduit) {

        SortieProduit sp = sortieProduitRepository.findById(idSortieProduit).get();
        return SortieProduitDto.fromEntity(sp);
    }

    @Override
    public List<SortieProduitDto> getAllSortieProduit() {
        List<SortieProduit> datas = sortieProduitRepository.findAll();
        List<SortieProduitDto> list = new ArrayList<>();
        for (SortieProduit sp: datas){
            list.add(SortieProduitDto.fromEntity(sp));
        }
        return list;
    }

    @Override
    public void deleteSortieProduit(Integer idSortieProduit) {
        sortieProduitRepository.deleteById(idSortieProduit);

    }
}
