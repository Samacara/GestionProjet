package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.ReglementPretApi;
import com.apprentice.gestionProjet.DTO.ReglementPretDto;
import com.apprentice.gestionProjet.Service.ReglementPretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReglementPretController implements ReglementPretApi {
    private ReglementPretService reglementPretService;
    @Autowired
    public ReglementPretController(ReglementPretService reglementPretService) {
        this.reglementPretService = reglementPretService;
    }

    @Override
    public ResponseEntity<Object> saveReglement(ReglementPretDto reglementPretDto, Integer idPret) {
        return ResponseEntity.ok().body(reglementPretService.saveReglementPret(idPret, reglementPretDto));
    }

    @Override
    public ResponseEntity<Object> UpdateReglement(Integer idReglement, ReglementPretDto reglementPretDto) {
        return ResponseEntity.ok().body(reglementPretService.updateReglementPret(idReglement, reglementPretDto));
    }

    @Override
    public ResponseEntity<Object> getReglementById(Integer idReglement) {
        return ResponseEntity.ok().body(reglementPretService.getReglementPretById(idReglement));
    }

    @Override
    public ResponseEntity<Object> getAllReglement() {
        return ResponseEntity.ok().body(reglementPretService.getAllReglementPret());
    }

    @Override
    public void deleteReglement(Integer idReglement) {
        reglementPretService.deleteReglementPret(idReglement);

    }
}
