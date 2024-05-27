package com.apprentice.gestionProjet.Controller.API;

import com.apprentice.gestionProjet.DTO.PaiementOuvrierDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface PaiementOuvrierApi {

    //enregistre un paiementOuvrier
    @PostMapping("/api/v1/paiementOuvriers/{idProjetOuvrier}")
    public ResponseEntity<Object>  savePaiementOuvrier(@PathVariable(value = "idProjetOuvrier") Integer idProjetOuvrier, @RequestBody PaiementOuvrierDto paiementOuvrierDto);

    //Modifier un paiementOuvrier
    @PutMapping("/api/v1/paiementOuvriers/{idPaiementOuvrier}")
    public  ResponseEntity<Object> UpdatepaiementOuvriers(@RequestBody PaiementOuvrierDto paiementOuvrierDto, @PathVariable(value = "idPaiementOuvrier") Integer idPaiementOuvrier);

    //recuperer un paiementOuvrier
    @GetMapping("/api/v1/paiementOuvriers/{idPaiementOuvrier}")
    public  ResponseEntity<Object> getOnePaiementOuvrier(@PathVariable (value = "idPaiementOuvrier") Integer idPaiementOuvrier);

    //supprimer un PaiementOuvrier
    @DeleteMapping("/api/v1/paiementOuvriers/{idPaiementOuvrier}")
    public void deleteOnePaiementOuvrier(@PathVariable (value = "idPaiementOuvrier") Integer idPaiementOuvrier);

    //recuperer tout les  paiementOuvriers
    @GetMapping("/api/v1/paiementOuvriers")
    public  ResponseEntity<Object> getAllPaiementOuvriers();
}
