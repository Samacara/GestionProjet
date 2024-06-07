//package com.apprentice.gestionProjet.Tuto;
//
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.List;
//
//import java.io.FileNotFoundException;
//import java.net.MalformedURLException;
//
//public class Main2 {
//
//    public static void main(String[] args) throws FileNotFoundException {
//
//        List list1 = new List();
//        list1.add("Java");
//        list1.add("Android");
//        list1.add("Kotlin");
//        list1.add("C");
//
//
//        String path = "C:\\Users\\Moubassir TAPSOBA\\Documents\\New\\petro2.pdf";
//        PdfWriter pdfWriter = new PdfWriter(path);
//        PdfDocument pdfDocument= new PdfDocument(pdfWriter);
//        pdfDocument.addNewPage();
//
//        Document document = new Document(pdfDocument);
//        document.add(list1);
//        document.close();
//
//
//        System.out.println("Dans l'ensemble c'est bon, finition zéro");
//
//
//
//    }
//    }
