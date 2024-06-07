//package com.apprentice.gestionProjet.Controller;
//
//import com.apprentice.gestionProjet.DTO.CategorieDto;
//import com.apprentice.gestionProjet.Service.CategorieService;
//
//import com.apprentice.gestionProjet.Service.PdfService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.ByteArrayInputStream;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/categories")
//public class PdfCatController {
//
//
//    private CategorieService categorieService;
//    private PdfService pdfService;
//    @Autowired
//    public PdfCatController(CategorieService categorieService, PdfService pdfService) {
//        this.categorieService = categorieService;
//        this.pdfService = pdfService;
//    }
//
//    @GetMapping(value = "/pdf")
//    public ResponseEntity<ByteArrayInputStream> getPdf() {
//        List<CategorieDto> categories = categorieService.getAllCategorie();
//        ByteArrayInputStream bis = pdfService.generatePdf();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=categories.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(bis);
//    }
//}
