package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.CategorieDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CategorieApi {

    @PostMapping("/api/v1/categories/creer")
    public ResponseEntity<Object> savaCategorie(@RequestBody CategorieDto categorieDto);

    @PutMapping("/api/v1/categories/{idCategorie}")
    public ResponseEntity<Object> UpdateCategorie(@RequestBody CategorieDto categorieDto, @PathVariable(value = "idCategorie") Integer idCategorie);

    @GetMapping("/api/v1/categories/{idCategorie}")
    public ResponseEntity<Object> GetOneCategorie(@PathVariable(value = "idCategorie") Integer idCategorie);

    @GetMapping("/api/v1/categories")
    public ResponseEntity<Object> GetAllCategorie();

    @DeleteMapping("/api/v1/categories/{idCategorie}")
    public void DeleteCategorie(@PathVariable(value = "idCategorie") Integer idCategorie);
}
