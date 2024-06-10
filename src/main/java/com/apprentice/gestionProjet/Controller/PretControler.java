package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.PretApi;
import com.apprentice.gestionProjet.DTO.PretDto;
import com.apprentice.gestionProjet.Service.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class PretControler implements PretApi {
    private PretService pretService;
    @Autowired
    public PretControler(PretService pretService) {
        this.pretService = pretService;
    }

    @Override
    public ResponseEntity<Object> savePret(PretDto pretDto) {
        return ResponseEntity.ok().body(pretService.savePret(pretDto));
    }

    @Override
    public ResponseEntity<Object> UpdatePret(PretDto pretDto, Integer idPret) {
        return ResponseEntity.ok().body(pretService.updatePret(pretDto, idPret));
    }

    @Override
    public ResponseEntity<Object> getOnePret(Integer idPret) {
        return ResponseEntity.ok().body(pretService.getPretById(idPret));
    }


    @Override
    public ResponseEntity<Object> getPret() {
        return ResponseEntity.ok().body(pretService.getAllPret());
    }

    @Override
    public void deletePret(Integer idPret) {
        pretService.deletePret(idPret);

    }

    @Override
    public ResponseEntity<List<PretDto>> getPretsInPeriods(String dateDebut, String dateFin) {
        List<PretDto> prets = pretService.getAllPretByPeriod(dateDebut, dateFin);
        return new ResponseEntity<>(prets, HttpStatus.OK);
    }

    @GetMapping("/prets")
    public ResponseEntity<List<PretDto>> getPretsInPeriod(
            @RequestParam("dateDebut") String dateDebut,
            @RequestParam("dateFin") String dateFin) {
        List<PretDto> prets = pretService.getAllPretByPeriod(dateDebut, dateFin);
        return new ResponseEntity<>(prets, HttpStatus.OK);
    }


    }



