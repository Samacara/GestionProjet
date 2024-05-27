package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.ProjetDto;
import com.apprentice.gestionProjet.DTO.ProjetOuvrierDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ProjetOuvrierApi {
    //enregistre un projetOuvrier
    @PostMapping("/api/v1/projetsOuvriers/projets/{projetId}/ouvriers/{ouvrierId}")
    public ResponseEntity<Object> createProjetOuvrier(@PathVariable(value ="projetId" ) Integer projetId, @PathVariable(value ="ouvrierId" ) Integer ouvrierId, @RequestBody ProjetOuvrierDto projetOuvrierDto);

    //Modifier un projet
    @PutMapping("/api/v1/projetsOuvriers/{idProjetOuvrier}")
    public ResponseEntity<Object> UpdateProjetOuvrier(@RequestBody ProjetOuvrierDto projetOuvrierDto, @PathVariable(value = "idProjetOuvrier") Integer  idProjetOuvrier);

    //recupere un seul projet
    @GetMapping("/api/v1/projetsOuvriers/{idProjetOuvrier}")
    public ResponseEntity<Object> getOneProjetOuvrier(@PathVariable(value = "idProjetOuvrier") Integer idProjetOuvrier);


    //supprime un projet
    @DeleteMapping("api/v1/projetsOuvriers/{idProjetOuvrier}")
    public void deleteProjet(@PathVariable(value = "idProjetOuvrier") Integer idProjetOuvrier);

    //recupere tous les projets
    @GetMapping("api/v1/projetsOuvriers")
    public ResponseEntity<Object> getAllprojetsOuvriers();

    @GetMapping("api/v2/projetsOuvriers")
    public ResponseEntity<Object> getOuvriersByProjet(@PathVariable (value = "idProjet")Integer idProjet);
//
//    @PostMapping("/api/v1/projetsOuvriers/differe/{idProjetOuvrier}")
//    public ResponseEntity<Object> effectuerPaiementDiffere(@PathVariable (value = "idProjetOuvrier") Integer idProjetOuvrier, @RequestParam Integer montant);



//    @GetMapping("/api/v1/projetsOuvrier/{idProjetOuvrier}/budget")
//    public ResponseEntity<Object> getBudget(@PathVariable(value ="idProjetOuvrier" ) Integer idProjetOuvrier);
//
//    @PutMapping("/api/v1/projetsOuvrier/{idProjetOuvrier}/soustraction")
//    public ResponseEntity<Object> soustractionBudget( @PathVariable(value ="idProjetOuvrier" ) Integer idProjet, @RequestParam(value = "montant") Integer montant);

}
