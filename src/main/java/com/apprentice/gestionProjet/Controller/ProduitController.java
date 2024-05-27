package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.ProduitApi;
import com.apprentice.gestionProjet.DTO.ProduitDto;
import com.apprentice.gestionProjet.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController implements ProduitApi {
    private ProduitService produitService;
    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }


    @Override
    public ResponseEntity<Object> saveProduit(Integer idCategorie, ProduitDto produitDto) {
        return ResponseEntity.ok().body(produitService.saveProduit(idCategorie,produitDto));
    }

    @Override
    public ResponseEntity<Object> Update(ProduitDto produitDto, Integer idProduit) {
        return ResponseEntity.ok().body(produitService.UpdateProduit(produitDto, idProduit));

    }

    @Override
    public ResponseEntity<Object> getOneProduit(Integer idProduit) {
        return ResponseEntity.ok().body(produitService.getOneProduit(idProduit));
    }

    @Override
    public ResponseEntity<Object> getAllProduit() {
        return ResponseEntity.ok().body(produitService.getAllProduit());
    }

    @Override
    public ResponseEntity<Object> getStockByProduit(Integer idProduit) {
        return ResponseEntity.ok().body(produitService.getStockByProduit(idProduit));
    }

    @Override
    public void DeleteProduit(Integer idProduit) {
        produitService.deleteProduit(idProduit);
    }
}
