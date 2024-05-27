package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.SortieDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface SortieApi {

    @PostMapping("/api/v1/sorties/creer/{idProjet}")
    public ResponseEntity<Object> saveSorties(@RequestBody SortieDto sortieDto, @PathVariable ( value = "idProjet") Integer idProjet);

    @PutMapping("/api/v1/sorties/{idSortie}")
    public ResponseEntity<Object> updateSorties(@RequestBody SortieDto sortieDto, @PathVariable ( value = "idSortie") Integer idSortie);

    @GetMapping("/api/v1/sorties/{idSortie}")
    public ResponseEntity<Object> GetOneSortie( @PathVariable ( value = "idSortie") Integer idSortie);

    @GetMapping("/api/v1/sorties")
    public ResponseEntity<Object> GetAllSortie();

    @DeleteMapping("/api/v1/sorties/{idSortie}")
    public void DeleteSortie( @PathVariable ( value = "idSortie") Integer idSortie);
}
