package com.apprentice.gestionProjet.Controller.API;

import com.itextpdf.text.DocumentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface CatPdfApi {
    @GetMapping("/api/v1/list/categories")
    public ResponseEntity<byte[]> generateCategoriesPdf() ;
}
