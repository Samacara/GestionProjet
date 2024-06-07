//package com.apprentice.gestionProjet.Tuto;
//
//import com.itextpdf.io.font.FontConstants;
//import com.itextpdf.kernel.color.Color;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Text;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class Main5 {
//    public static void main(String[] args) throws IOException {
//
//    String path = "C:\\Users\\Moubassir TAPSOBA\\Documents\\New\\petro5.pdf";
//    PdfWriter pdfWriter = new PdfWriter(path);
//    PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//    Document document = new Document(pdfDocument);
//
//    PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
//
//
//    Text text1 = new Text("Normal").setFont(font);
//    Text text2 = new Text("\nBold").setFont(font).setBold();
//    Text text3 = new Text("\nItalic").setFont(font).setItalic();
//    Text text4 = new Text("\nUnderline").setFont(font).setUnderline();
//    Text text5 = new Text("\nBold Italic").setFont(font).setBold().setItalic();
//    Text text6 = new Text("\nBold").setFont(font).setFontColor(Color.BLUE);
//    Text text7 = new Text("\nBold").setFont(font).setBold().setStrokeColor(Color.GREEN);
//    Text text8 = new Text("\nText Rendering")
//            .setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.STROKE)
//            .setStrokeColor(Color.RED)
//            .setStrokeWidth(0.5f);
//
//        Paragraph paragraph = new Paragraph()
//                .add(text1)
//                .add(text2)
//                .add(text3)
//                .add(text4)
//                .add(text5)
//                .add(text6)
//                .add(text7)
//                .add(text8);
//
//    document.add( paragraph);
//    document.close();
//    System.out.println("validé!!!!!!!!!!!!");
//}
//
//}