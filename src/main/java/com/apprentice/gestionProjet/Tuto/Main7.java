//package com.apprentice.gestionProjet.Tuto;
//
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.element.Table;
//
//import java.io.FileNotFoundException;
//import java.net.MalformedURLException;
//
//public class Main7 {
//    public static void main(String[] args) throws FileNotFoundException {
//
//        String path = "C:\\Users\\Moubassir TAPSOBA\\Documents\\New\\petro7.pdf";
//        PdfWriter pdfWriter = new PdfWriter(path);
//        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//        Document document = new Document(pdfDocument);
//
//        float columnwidth [] = {200f, 50f, 100f};
//        Table table = new Table(columnwidth);
//
//        document.close();
//        System.out.println("Dans l'ensemble c'est bon!!!");
//
//
//    }
//}
