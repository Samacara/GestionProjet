package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.SortieProduitApi;
import com.apprentice.gestionProjet.DTO.SortieProduitDto;
import com.apprentice.gestionProjet.Service.SortieProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class SortieProduitController implements SortieProduitApi {
    private SortieProduitService sortieProduitService;
    @Autowired
    public SortieProduitController(SortieProduitService sortieProduitService) {
        this.sortieProduitService = sortieProduitService;
    }

    @Override
    public ResponseEntity<Object> saveSortieProduit(SortieProduitDto sortieProduitDto, Integer idSortie, Integer idProduit) {
        return ResponseEntity.ok().body(sortieProduitService.saveSortieProduit(sortieProduitDto, idSortie, idProduit));
    }

    @Override
    public ResponseEntity<Object> updateSortieProduit(SortieProduitDto sortieProduitDto, Integer idSortieProduit) {
        return ResponseEntity.ok().body(sortieProduitService.UpdateSortieProduit(sortieProduitDto, idSortieProduit));
    }

    @Override
    public ResponseEntity<Object> getOneSortieProduit(Integer idSortieProduit) {
        return ResponseEntity.ok().body(sortieProduitService.getOneSortieProduit(idSortieProduit));
    }

    @Override
    public ResponseEntity<Object> getAllSortieProduit() {
        return ResponseEntity.ok().body(sortieProduitService.getAllSortieProduit());
    }

    @Override
    public void deleteSortieProduit(Integer idSortieProduit) {
        sortieProduitService.deleteSortieProduit(idSortieProduit);

    }
}
