package com.apprentice.gestionProjet.Controller.API;


import com.apprentice.gestionProjet.DTO.DepenseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface DepenseApi {
    //enregistre une depense
    @PostMapping("/api/v1/depenses/projets/{projetId}")
    public ResponseEntity<Object> CreateDepense(@RequestBody DepenseDto depense, @PathVariable(value = "projetId") Integer projetId);

    //modifier une depense
    @PutMapping("/api/v1/depenses/{idDepense}")
    ResponseEntity<Object> UpdateDepense(@RequestBody DepenseDto depenseDto, @PathVariable(value = "idDepense") Integer idDepense);

    //recupere une seule depense
    @GetMapping("/api/v1/depenses/{idDepense}")
    public ResponseEntity<Object> getOneDepense(@PathVariable(value = "idDepense") Integer idDepense);

    //supprime une projet
    @DeleteMapping("/api/v1/depenses/{idDepense}")
    public void DeleteDepense(@PathVariable(value = "idDepense") Integer idDepense);

    //recupere toutes les depenses
    @GetMapping("api/v1/depenses")
    public ResponseEntity<Object> getAllDepenses();

}


