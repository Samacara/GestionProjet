package com.apprentice.gestionProjet.Service;
//
//import com.apprentice.gestionProjet.DTO.CategorieDto;
//import com.itextpdf.io.font.constants.StandardFonts;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public byte[] generatePdf() {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
    try {


        PdfWriter.getInstance(document, out);
        document.open();
        document.add(new Paragraph("Hello, World!"));
        document.close();
    } catch (DocumentException e){
         e.printStackTrace();
    }

        return out.toByteArray();

    }
}