package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.ProjetDto;
import com.apprentice.gestionProjet.Entity.Projet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProjetApi {

    //enregistre un projet
    @PostMapping("/api/v1/projets/creer")
    public ResponseEntity<Object> createProjet(@RequestBody ProjetDto projet);

    //Modifier un projet
    @PutMapping("/api/v1/projets/{idProjet}")
    public ResponseEntity<Object> UpdateProjet(@RequestBody ProjetDto projetDto, @PathVariable(value = "idProjet") Integer  idProjet);

    //enregistre un projet
//    @PostMapping("/api/v2/projets/creer")
//    public ResponseEntity<Object> createProjet1(@RequestBody Projet projet);

    //recupere un seul projet
    @GetMapping("/api/v1/projets/{idProjet}")
    public ResponseEntity<Object> getOneProjet(@PathVariable(value = "idProjet") Integer idProjet);


    //supprime un projet
    @DeleteMapping("api/v1/projets/{idProjet}")
    public void deleteProjet(@PathVariable(value = "idProjet") Integer idprojet);

    //recupere tous les projets
    @GetMapping("api/v1/projets")
    public ResponseEntity<Object> getAllprojets();

    @GetMapping("/api/v1/projets/{idProjet}/budget")
    public ResponseEntity<Object> getBudget(@PathVariable(value ="idProjet" ) Integer idProjet);

    @PutMapping("/api/v1/projets/{idProjet}/soustraction")
    public ResponseEntity<Object> soustractionBudget( @PathVariable(value ="idProjet" ) Integer idProjet, @RequestParam(value = "montant") Integer montant);

//    @GetMapping("/api/v1/projets/{idProjet}/ouvrier")
//    public ResponseEntity<Object> getOuvriersParProjet(@PathVariable (value ="idProjet" ) Integer idProjet);

}
