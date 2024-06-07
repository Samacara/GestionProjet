//package com.apprentice.gestionProjet.Tuto;
//
//import com.itextpdf.io.image.ImageData;
//import com.itextpdf.io.image.ImageDataFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Image;
//import com.itextpdf.layout.element.Paragraph;
//
//import java.io.FileNotFoundException;
//import java.net.MalformedURLException;
//
//public class Main {
//    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
//        String img = "Image\\Marco.jpg";
//        ImageData data = ImageDataFactory.create(img);
//        Image image1 = new Image(data);
//        String path = "C:\\Users\\Moubassir TAPSOBA\\Documents\\New\\petro.pdf";
//        String paraText= "Si vous regardez la création de PDF, vous trouverez deux approches différentes:\n" +
//                "Les concepteurs graphiques utilisent des applications de bureau telles que Adobe Acrobat\n" +
//                "ou Adobe InDesign pour créer un document dans un processus manuel ou semi-annuel.\n" +
//                "•\n" +
//                "Dans un autre contexte, les documents PDF sont créés par programmation, en utilisant une\n" +
//                "API pour produire des fichiers PDF directement à partir d'applications logicielles, sans\n" +
//                "intervention humaine ou avec un minimum. Parfois, le document est d'abord créé dans un\n" +
//                "format intermédiaire (XML, HTML, etc.), puis converti en PDF.";
//        Paragraph paragraph1 = new Paragraph(paraText);
//        PdfWriter pdfWriter = new PdfWriter(path);
//        PdfDocument pdfDocument= new PdfDocument(pdfWriter);
//        pdfDocument.addNewPage();
//
//        Document document = new Document(pdfDocument);
//        document.add(paragraph1);
//        document.add(image1);
//        document.close();
//
//
//        System.out.println("Dans l'ensemble c'est bon");
//
//
//
//    }
//}
