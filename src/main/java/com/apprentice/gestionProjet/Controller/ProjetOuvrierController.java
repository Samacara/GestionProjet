package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.ProjetOuvrierApi;
import com.apprentice.gestionProjet.DTO.ProjetOuvrierDto;
import com.apprentice.gestionProjet.Service.ProjetOuvrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjetOuvrierController implements ProjetOuvrierApi {

    private ProjetOuvrierService projetOuvrierService;
    @Autowired
    public ProjetOuvrierController(ProjetOuvrierService projetOuvrierService) {
        this.projetOuvrierService = projetOuvrierService;
    }






    @Override
    public ResponseEntity<Object> createProjetOuvrier(Integer projetId, Integer ouvrierId, ProjetOuvrierDto projetOuvrierDto) {
        return ResponseEntity.ok().body(projetOuvrierService.saveProjetOuvrier(projetId, ouvrierId,projetOuvrierDto));
    }

    @Override
    public ResponseEntity<Object> UpdateProjetOuvrier(ProjetOuvrierDto projetOuvrierDto, Integer idProjetOuvrier) {
        return ResponseEntity.ok().body(projetOuvrierService.updateProjetOuvrierById(projetOuvrierDto, idProjetOuvrier));
    }

    @Override
    public ResponseEntity<Object> getOneProjetOuvrier(Integer idProjetOuvrier) {
        return ResponseEntity.ok().body(projetOuvrierService.getProjetOuvrierById(idProjetOuvrier));
    }

    @Override
    public void deleteProjet(Integer idProjetOuvrier) {
        projetOuvrierService.deleteProjetOuvrierById(idProjetOuvrier);
    }

    @Override
    public ResponseEntity<Object> getAllprojetsOuvriers() {
        return ResponseEntity.ok().body(projetOuvrierService.getallprojetsOuvriers());
    }

    @Override
    public ResponseEntity<Object> getOuvriersByProjet(Integer idProjet) {
        return null;
    }


}
