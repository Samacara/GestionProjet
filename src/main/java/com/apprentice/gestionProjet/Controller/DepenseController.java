package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.DepenseApi;
import com.apprentice.gestionProjet.DTO.DepenseDto;
import com.apprentice.gestionProjet.Service.DepenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class DepenseController implements DepenseApi {
    private DepenseService depenseService;



    @Autowired
    public DepenseController(DepenseService depenseService) {
        this.depenseService = depenseService;
    }

    @Override
    public ResponseEntity<Object> CreateDepense(DepenseDto depense, Integer projetId) {
        return ok().body(depenseService.saveDepense(projetId, depense));
    }

    @Override
    public ResponseEntity<Object> UpdateDepense(DepenseDto depenseDto, Integer idDepense) {
        return ok().body(depenseService.updateDepenseById(depenseDto, idDepense));
    }

    @Override
    public ResponseEntity<Object> getOneDepense(Integer idDepense) {
        return ok().body(depenseService.getDepenseById(idDepense));
    }

    @Override
    public void DeleteDepense(Integer idDepense) {
        depenseService.deleteDepenseById(idDepense);
    }



    @Override
    public ResponseEntity<Object> getAllDepenses() {
        return ok().body(depenseService.getallDepense());
    }
}
