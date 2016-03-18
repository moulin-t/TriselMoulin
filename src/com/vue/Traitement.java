package com.vue;

import java.util.Scanner;

import com.pdf.FacturePdf;
import com.util.InsertionLevee;

public class Traitement {

	public static void main(String[] args) {
		int choix = 0;
		Scanner in = new Scanner(System.in);
		while (choix != 3) {
			System.out.println("Menu général");
			System.out.println("1- Insersion des levées");
			System.out.println("2- Edition des factures");
			System.out.println("3- Quitter");
			System.out.println("Donnez votre choix");
			choix = in.nextInt();
			switch (choix){
			case 1 :
				insertion();
				break;
			case 2 :
				facturation();
			case 3 :
				break;
			}
			private static void insertion(){
				InsertionLevee.traitementLevee();
			}
			private static void facturation(){
				int mois, an; String idH;
				System.out.println("Saisissez l'identifiant de l'habitation souhaitée.");
				idH = in.nextLine();
				System.out.println("Saisissez le mois de la facture.");
				mois = in.nextInt();
				System.out.println("Saisissez l'année de la facture.");
				an = in.nextInt();
				FacturePdf.GenerePdf(idH, an, mois);
				break;
			}
		}
	}
}