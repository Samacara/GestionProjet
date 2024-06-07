package com.apprentice.gestionProjet.Print;

import com.apprentice.gestionProjet.DTO.CategorieDto;
import com.apprentice.gestionProjet.Service.CategorieService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class CatPdfService {

    private final CategorieService categorieService;

    @Autowired
    public CatPdfService(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    public byte[]  generateCategoriePdf()  {
        List<CategorieDto> categories = categorieService.getAllCategorie();

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add Title
            Font font = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Liste des Catégories", font);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));

            // Create a table with 2 columns
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);

            // Add table headers
            PdfPCell hcell;
            Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

            hcell = new PdfPCell(new Phrase("ID", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Description", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            // Add data to the table
            for (CategorieDto categorie : categories) {
                PdfPCell cell;

                cell = new PdfPCell(new Phrase(categorie.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(categorie.getDescription()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
            }

            document.add(table);
            document.close();
        }catch (DocumentException e){
            e.printStackTrace();
        }
        return  out.toByteArray();
    }
}