package com.apprentice.gestionProjet.Controller;

//import com.apprentice.gestionProjet.Controller.API.OuvreirPdfApi;
//import com.apprentice.gestionProjet.DTO.OuvrierDto;
//import com.apprentice.gestionProjet.Service.OuvrierService;
//import com.apprentice.gestionProjet.Service.PdfGeneratorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.ByteArrayInputStream;
//import java.util.List;

import com.apprentice.gestionProjet.Controller.API.OuvreirPdfApi;
import com.apprentice.gestionProjet.Service.PdfService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
@RestController
public class OuvrierPdfController implements OuvreirPdfApi {
    private PdfService pdfService;

    @Autowired
    public OuvrierPdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    public ResponseEntity<byte[]> OuvrierListPdf() {
        byte[] bis = pdfService.generatePdf();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=example.pdf");

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

        return new ResponseEntity<>(bis, headers, HttpStatus.OK);


    }


}
