package com.apprentice.gestionProjet.Controller;

import com.apprentice.gestionProjet.Controller.API.CatPdfApi;
import com.apprentice.gestionProjet.Print.CatPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CatPdfController implements CatPdfApi {
    private final CatPdfService catPdfService;
    @Autowired
    public CatPdfController(CatPdfService catPdfService) {
        this.catPdfService = catPdfService;
    }


    public ResponseEntity<byte[]> generateCategoriesPdf() {
        byte[] bis = catPdfService.generateCategoriePdf();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=categories.pdf");

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

        return new ResponseEntity<>(bis, headers, HttpStatus.OK);
    }
}
