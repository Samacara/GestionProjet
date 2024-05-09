package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.ProjetApi;
import com.apprentice.gestionProjet.DTO.ProjetDto;
import com.apprentice.gestionProjet.Entity.Projet;
import com.apprentice.gestionProjet.Service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ProjetController implements ProjetApi {
    private ProjetService projetService;

     @Autowired
    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @Override
    public ResponseEntity<Object> createProjet(ProjetDto projet) {
        return ok().body(projetService.saveProjet(projet));
    }

    @Override
    public ResponseEntity<Object> UpdateProjet(ProjetDto projetDto, Integer idProjet) {
        return ok().body(projetService.updateProjetById(projetDto, idProjet));
    }

//    @Override
//    public ResponseEntity<Object> createProjet1(Projet projet) {
//        return ok().body(projetService.saveProjet1(projet));
//    }


    @Override
    public ResponseEntity<Object> getOneProjet(Integer idProjet) {
        return ok().body(projetService.getById(idProjet));
    }

    @Override
    public void deleteProjet(Integer idprojet) {
        projetService.deleteById(idprojet);
    }

    @Override
    public ResponseEntity<Object> getAllprojets() {
        return ok().body(projetService.getallprojet());
    }

    @Override
    public ResponseEntity<Object> getBudget(Integer idProjet) {
        return ok().body(projetService.getBudget(idProjet));
    }

    @Override
    public ResponseEntity<Object> soustractionBudget(Integer idProjet, Integer montant) {

        return ok().body(projetService.soustractionBudget(idProjet, montant));
//        try {
//            projetService.soustractionBudget(idProjet, montant);
//            return ResponseEntity.ok("Soustraction effectuée avec succès.");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
    }

    @Override
    public ResponseEntity<Object> getOuvriersParProjet(Integer idProjet) {
        return ok().body(projetService.getOuvriersParProjet(idProjet));
    }


//    @Override
//    public ResponseEntity<Object> soustraireDuBudget( Integer idProjet, Integer montant) {
//        return ok().body(projetService.soustraireDuBudget(idProjet, montant));
//    }
}