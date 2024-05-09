package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.OuvrierApi;
import com.apprentice.gestionProjet.DTO.OuvrierDto;
import com.apprentice.gestionProjet.Service.OuvrierService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OuvrierController implements OuvrierApi {

    private OuvrierService ouvrierService;

    @Autowired
    public OuvrierController(OuvrierService ouvrierService) {
        this.ouvrierService = ouvrierService;
    }

    @Override
    public ResponseEntity<Object> CreateOuvier(OuvrierDto ouvrier) {
        return ResponseEntity.ok().body(ouvrierService.saveOuvrier(ouvrier));
    }

    @Override
    public ResponseEntity<Object> UpdateOuvrier(OuvrierDto ouvrierDto, Integer idOuvier) {
        return ResponseEntity.ok().body(ouvrierService.updateOuvrierById(ouvrierDto, idOuvier));
    }

    @Override
    public ResponseEntity<Object> getOneOuvier(Integer idOuvier) {
        return ResponseEntity.ok().body(ouvrierService.getOuvrierById(idOuvier));
    }

    @Override
    public void DeleteOuvier(Integer idOuvier) {
        ouvrierService.deleteOuvrierById(idOuvier);

    }

    @Override
    public ResponseEntity<Object> getAllOuviers() {
        return ResponseEntity.ok().body(ouvrierService.getallOuvrier());
    }
}
