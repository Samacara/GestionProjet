//package com.apprentice.gestionProjet.Tuto;
//
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Text;
//
//import java.io.IOException;
//
//public class Main4 {
//    public static final String abrushow = "font\\Abrushow.otf";
//    public static final String really = "font\\Really.ttf";
//
//    public static void main(String[] args) throws IOException {
//
//        String path = "C:\\Users\\Moubassir TAPSOBA\\Documents\\New\\petro4.pdf";
//        PdfWriter pdfWriter = new PdfWriter(path);
//        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//        Document document = new Document(pdfDocument);
//
//        PdfFont abrushow1 = PdfFontFactory.createFont(abrushow, true);
//        PdfFont really1 = PdfFontFactory.createFont(really, true);
//
//        Text text1 = new Text("Samacara le riche").setFont(abrushow1);
//        Text text2 = new Text(" Petro Dollar").setFont(really1);
//
//        Paragraph paragraph = new Paragraph()
//                .add(text1)
//                        .add(text2);
//
//        document.add(paragraph);
//        document.close();
//        System.out.println("La Yoro Gangang");
//    }
//}