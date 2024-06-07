//package com.apprentice.gestionProjet.Tuto;
//
//import com.itextpdf.io.image.ImageData;
//import com.itextpdf.io.image.ImageDataFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Cell;
//import com.itextpdf.layout.element.Image;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//
//import java.io.FileNotFoundException;
//import java.net.MalformedURLException;
//
//public class Main6 {
//
//    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
//
//        String path = "C:\\Users\\Moubassir TAPSOBA\\Documents\\New\\petro6.pdf";
//        PdfWriter pdfWriter = new PdfWriter(path);
//        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//        Document document = new Document(pdfDocument);
//
//        float columnwidth [] = {200f, 50f, 100f};
//        Table table = new Table(columnwidth);
//        Cell cell_ll = new Cell();
//        cell_ll.add("Item");
//        table.addCell(cell_ll);
//
//        table.addCell(new Cell().add("Qty"));
//        table.addCell(new Cell().add("Available"));
//
//        table.addCell(new Cell().add("Mango"));
//        table.addCell(new Cell().add("2 Kg"));
//        table.addCell(new Cell().add("Yes"));
//
//        table.addCell(new Cell().add("Orange"));
//        table.addCell(new Cell().add("5 Kg"));
//        table.addCell(new Cell().add("No"));
//
//        table.addCell(new Cell().add("Avocat"));
//        table.addCell(new Cell().add("3 Kg"));
//        table.addCell(new Cell().add("Yes"));
//        document.add(table);
//        document.close();
//        System.out.println("Dans l'ensemble c'est bon!!!");
//
//
//    }
//}