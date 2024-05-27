package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.ProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ProduitApi {
    @PostMapping("/api/v1/produits/categories/{idCategorie}")
    public ResponseEntity<Object> saveProduit( @PathVariable(value = "idCategorie") Integer idCategorie, @RequestBody ProduitDto produitDto);



    @PutMapping("/api/v1/produits/{idProduit}")
    public ResponseEntity<Object> Update(@RequestBody ProduitDto produitDto, @PathVariable(value = "idProduit") Integer idProduit);

    @GetMapping("/api/v1/produits/{idProduit}")
    public ResponseEntity<Object> getOneProduit(@PathVariable(value = "idProduit") Integer idProduit);

    @GetMapping("/api/v1/produits")
    public ResponseEntity<Object> getAllProduit();

    @GetMapping("/api/v1/produits/{idProduit}/produit")
    public ResponseEntity<Object> getStockByProduit(@PathVariable(value = "idProduit") Integer idProduit);

    @DeleteMapping("/api/v1/produits/{idProduit}")
    public void DeleteProduit(@PathVariable (value = "idProduit") Integer idProduit);
}
