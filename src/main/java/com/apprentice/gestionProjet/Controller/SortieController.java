package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.SortieApi;
import com.apprentice.gestionProjet.DTO.SortieDto;
import com.apprentice.gestionProjet.Service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortieController implements SortieApi {
    private SortieService sortieService;
    @Autowired
    public SortieController(SortieService sortieService) {
        this.sortieService = sortieService;
    }

    @Override
    public ResponseEntity<Object> saveSorties(SortieDto sortieDto, Integer idProjet) {
        return ResponseEntity.ok().body(sortieService.saveSortie(sortieDto, idProjet));
    }

    @Override
    public ResponseEntity<Object> updateSorties(SortieDto sortieDto, Integer idSortie) {
        return ResponseEntity.ok().body(sortieService.updateSortie(sortieDto, idSortie));
    }

    @Override
    public ResponseEntity<Object> GetOneSortie(Integer idSortie) {
        return ResponseEntity.ok().body(sortieService.GetOneSortie(idSortie));
    }

    @Override
    public ResponseEntity<Object> GetAllSortie() {
        return ResponseEntity.ok().body(sortieService.getAllSortie());
    }

    @Override
    public void DeleteSortie(Integer idSortie) {

    }
}
