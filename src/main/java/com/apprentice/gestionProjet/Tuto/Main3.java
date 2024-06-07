//package com.apprentice.gestionProjet.Tuto;
//
//import com.itextpdf.io.font.FontConstants;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Text;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class Main3 {
//    public static  final  String Abrushow = "font\\Abrushow.otf";
//    public static  final  String Really = "font\\Really.ttf";
//
//    public static void main(String[] args) throws IOException {
//
//        String path ="C:\\Users\\Moubassir TAPSOBA\\Documents\\New\\petro3.pdf";
//        PdfWriter pdfWriter = new PdfWriter(path);
//        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//        Document document = new Document(pdfDocument);
//
//        PdfFont font =  PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
//        PdfFont boldFont = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
//
//        Text text1 = new Text("Dans l'ensemble c'est bon").setFont(font);
//        Text text2 = new Text(" Finition zéro").setFont(boldFont);
//
//        Paragraph paragraph = new Paragraph()
//                .add(text1)
//                .add(text2);
//        document.add(paragraph);
//        document.close();
//
//        System.out.println("c'est tchorrrrrrrrr");
//
//
//
//    }
//}
