package com.apprentice.gestionProjet;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;


import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class PrintPayement {
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {

        String imgScr = "Image\\Marco.jpg";
        ImageData data = ImageDataFactory.create(imgScr);
        Image image1 = new Image(data);
        String path= "C:\\Users\\Moubassir TAPSOBA\\Documents\\New\\same.pdf";
        String paraText= "pluie ne mouille pas le vent, mais vent pousse pluie";
        Paragraph paragraph1 = new Paragraph(paraText);
        PdfWriter pdfWriter = new PdfWriter(path);


        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        document.add(paragraph1);
        document.add(image1);

        document.close();

        System.out.println("Hello word");

    }
}
