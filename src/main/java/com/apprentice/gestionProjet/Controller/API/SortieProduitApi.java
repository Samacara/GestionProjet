package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.SortieProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface SortieProduitApi {

    @PostMapping("/api/v1/sortieProduits/sorties/{idSortie}/produits/{idProduit}")
    public ResponseEntity<Object> saveSortieProduit(@RequestBody SortieProduitDto sortieProduitDto, @PathVariable(value = "idSortie")Integer idSortie, @PathVariable( value = "idProduit")Integer idProduit);

    @PutMapping("/api/v1/sortieProduits/{idSortieProduit}")
    public ResponseEntity<Object> updateSortieProduit(@RequestBody SortieProduitDto sortieProduitDto, @PathVariable(value = "idSortieProduit") Integer idSortieProduit);

    @GetMapping("/api/v1/sortieProduits/{idSortieProduit}")
    public ResponseEntity<Object> getOneSortieProduit(@PathVariable(value = "idSortieProduit") Integer idSortieProduit);

    @GetMapping("/api/v1/sortieProduits")
    public ResponseEntity<Object> getAllSortieProduit();

    @DeleteMapping("/api/v1/sortieProduits/{idSortieProduit}")
    public void deleteSortieProduit(@PathVariable("idSortieProduit") Integer idSortieProduit);

}
