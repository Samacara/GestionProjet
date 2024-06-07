package com.apprentice.gestionProjet.Controller.API;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;

public interface OuvreirPdfApi {


    @GetMapping("/api/v2/list/ouvriers")
    public ResponseEntity<byte[]> OuvrierListPdf();
}
