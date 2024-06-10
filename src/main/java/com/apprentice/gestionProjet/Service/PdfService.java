package com.apprentice.gestionProjet.Service;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

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