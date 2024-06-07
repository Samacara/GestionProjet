//package com.apprentice.gestionProjet.Service;
//
//import com.apprentice.gestionProjet.DTO.OuvrierDto;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
////import com.itextpdf.layout.Document;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//
//import com.itextpdf.layout.property.UnitValue;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.util.List;
//
//@Service
//public class PdfGeneratorService {
//
//    public ByteArrayInputStream generateOuvriersPdf(List<OuvrierDto> ouvriers) {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try (PdfDocument pdfDoc = new PdfDocument(new PdfWriter(out));
//             Document document = new Document(pdfDoc)) {
//
//            document.add(new Paragraph("Liste des Ouvriers").setFontSize(18).setBold());
//
//            float[] columnWidths = {1, 3, 3, 3, 2};
//            Table table = new Table(UnitValue.createPercentArray(columnWidths));
//            table.setWidth(UnitValue.createPercentValue(100));
//
//            table.addHeaderCell("ID");
//            table.addHeaderCell("Nom");
//            table.addHeaderCell("Adresse");
//            table.addHeaderCell("Localisation");
//
//
//            for (OuvrierDto ouvrier : ouvriers) {
//                table.addCell(ouvrier.getId().toString());
//                table.addCell(ouvrier.getNom());
//                table.addCell(ouvrier.getAdresse());
//                table.addCell(ouvrier.getLocalisation());
//
//            }
//
//            document.add(table);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return new ByteArrayInputStream(out.toByteArray());
//    }
//}
