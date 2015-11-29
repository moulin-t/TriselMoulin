package com.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.persistance.HabitationDAO;

public class FacturePdf {
	private String[] convMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre",
	                                       "Octobre", "Novembre", "Décembre"};
	
	@SuppressWarnings("deprecation")
	public void GenerePdf(String idH, int an, int mois){
		HabitationDAO hDao = new HabitationDAO();
		Habitation h = hDao.find(idH);
		Document doc = new Document();
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			String dateA = format.format(date);
			String[] dateB = dateA.split("-");
			double coutTotal = 0.0;
			PdfWriter.getInstance(doc, new FileOutputStream("facture.pdf"));
			doc.open();
			Paragraph p;
			PdfPTable table;
			PdfPCell cel;
			Image ima = Image.getInstance("Trisel.jpg");
			doc.add(ima);
			p = new Paragraph("Facture du mois de " + convMois[mois-1]);
			p.setAlignment(Element.ALIGN_RIGHT);
			doc.add(p);
			p = new Paragraph("Editée le " + dateB[0] + " " + convMois[Integer.parseInt(dateB[1])-1] + " " + dateB[2]);
			p.setAlignment(Element.ALIGN_RIGHT);
			p.setSpacingAfter(30);
			doc.add(p);
			p = new Paragraph(h.getUsager().getPrenom() + " " + h.getUsager().getNom());
			p.setIndentationLeft(350);
			doc.add(p);
			p = new Paragraph(h.getAdresseRue());
			p.setIndentationLeft(350);
			doc.add(p);
			p = new Paragraph(h.getAdresseVille());
			p.setIndentationLeft(350);
			p.setSpacingAfter(30);
			doc.add(p);
			p = new Paragraph("Code usager : " + h.getUsager().getIdUsager());
			doc.add(p);
			p = new Paragraph("Récapitulatif des pesées au mois de : " + convMois[mois-1]);
			doc.add(p);
			ArrayList<Poubelle> poubs = h.getLesPoubelles();
			for(Poubelle poub : poubs){
				table = new PdfPTable(4);
				p = new Paragraph("Poubelle : " + poub.getIdPoubelle() + "  Nature des déchets : " + poub.getNature().getLibelle());
				cel = new PdfPCell(p);
				cel.setColspan(4);
				table.addCell(cel);
				p = new Paragraph("Date de pesée");
				cel = new PdfPCell(p);
				table.addCell(cel);
				p = new Paragraph("Nombre de kg");
				cel = new PdfPCell(p);
				table.addCell(cel);
				p = new Paragraph("Prix HT au kg");
				cel = new PdfPCell(p);
				table.addCell(cel);
				p = new Paragraph("Total HT");
				cel = new PdfPCell(p);
				table.addCell(cel);
				for(Levee lev : poub.getLesLevees(an, mois)){
					p = new Paragraph(lev.getLaDate().toString());
					cel = new PdfPCell(p);
					table.addCell(cel);
					p = new Paragraph(String.valueOf(lev.getPoids()));
					cel = new PdfPCell(p);
					table.addCell(cel);
					p = new Paragraph(String.valueOf(poub.getNature().getTarif()));
					cel = new PdfPCell(p);
					table.addCell(cel);
					p = new Paragraph(String.valueOf(lev.getPoids() + poub.getNature().getTarif()));
					cel = new PdfPCell(p);
					table.addCell(cel);
				}
				p = new Paragraph("Total HT");
				p.setAlignment(Element.ALIGN_RIGHT);
				cel = new PdfPCell(p);
				cel.setColspan(3);
				table.addCell(cel);
				p = new Paragraph(String.valueOf(poub.getCout(an, mois)));
				cel = new PdfPCell(p);
				table.addCell(cel);
				table.setSpacingAfter(30);
				doc.add(table);
				coutTotal += poub.getCout(an, mois);
			}
			table = new PdfPTable(4);
			p = new Paragraph("Total général HT");
			p.setAlignment(Element.ALIGN_RIGHT);
			cel = new PdfPCell(p);
			cel.setColspan(3);
			table.addCell(cel);
			p = new Paragraph(String.valueOf(coutTotal));
			cel = new PdfPCell(p);
			table.addCell(cel);
			p = new Paragraph("Montant TVA");
			p.setAlignment(Element.ALIGN_RIGHT);
			cel = new PdfPCell(p);
			cel.setColspan(3);
			table.addCell(cel);
			p = new Paragraph(String.valueOf(coutTotal*0.2));
			cel = new PdfPCell(p);
			table.addCell(cel);
			p = new Paragraph("Total TTC");
			p.setAlignment(Element.ALIGN_RIGHT);
			cel = new PdfPCell(p);
			cel.setColspan(3);
			table.addCell(cel);
			p = new Paragraph(String.valueOf(coutTotal*1.2));
			cel = new PdfPCell(p);
			table.addCell(cel);
			doc.add(table);
			doc.close();
			Runtime.getRuntime().exec("explorer.exe facture.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
