package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.CategorieApi;
import com.apprentice.gestionProjet.DTO.CategorieDto;
import com.apprentice.gestionProjet.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieController implements CategorieApi {
    private CategorieService  categorieService;
    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @Override
    public ResponseEntity<Object> savaCategorie(CategorieDto categorieDto) {
        return ResponseEntity.ok(categorieService.saveCategorie(categorieDto));
    }

    @Override
    public ResponseEntity<Object> UpdateCategorie(CategorieDto categorieDto, Integer idCategorie) {
        return ResponseEntity.ok().body(categorieService.updateCategorie(categorieDto,  idCategorie));
    }

    @Override
    public ResponseEntity<Object> GetOneCategorie(Integer idCategorie) {
        return ResponseEntity.ok().body(categorieService.getCategorieById(idCategorie));
    }

    @Override
    public ResponseEntity<Object> GetAllCategorie() {
        return ResponseEntity.ok().body(categorieService.getAllCategorie());
    }

    @Override
    public void DeleteCategorie(Integer idCategorie) {
        categorieService.DeleteCategorie(idCategorie);
    }


}
