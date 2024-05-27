package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.PaiementOuvrierApi;
import com.apprentice.gestionProjet.DTO.PaiementOuvrierDto;
import com.apprentice.gestionProjet.Service.PaiementOuvrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaiementOuvrierController implements PaiementOuvrierApi {

    private PaiementOuvrierService paiementOuvrierService;

    @Autowired
    public PaiementOuvrierController(PaiementOuvrierService paiementOuvrierService) {
        this.paiementOuvrierService = paiementOuvrierService;
    }

    @Override
    public ResponseEntity<Object> savePaiementOuvrier(Integer idProjetOuvrier, PaiementOuvrierDto paiementOuvrierDto) {
        return ResponseEntity.ok().body(paiementOuvrierService.savepaiementOuvrier(idProjetOuvrier, paiementOuvrierDto));
    }

    @Override
    public ResponseEntity<Object> UpdatepaiementOuvriers(PaiementOuvrierDto paiementOuvrierDto, Integer idPaiementOuvrier) {
        return ResponseEntity.ok().body(paiementOuvrierService.UpdatePaiementOuvrier(paiementOuvrierDto, idPaiementOuvrier));
    }

    @Override
    public ResponseEntity<Object> getOnePaiementOuvrier(Integer idPaiementOuvrier) {
        return ResponseEntity.ok().body(paiementOuvrierService.GetPaiementOuvrierById(idPaiementOuvrier));
    }

    @Override
    public void deleteOnePaiementOuvrier(Integer idPaiementOuvrier) {
        paiementOuvrierService.deletpaiementouvrier(idPaiementOuvrier);

    }

    @Override
    public ResponseEntity<Object> getAllPaiementOuvriers() {
        return ResponseEntity.ok().body(paiementOuvrierService.getallpaiementOuvrier());
    }
}
