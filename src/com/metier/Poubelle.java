package com.metier;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * @author moulin-t
 * @version 1.0
 */

public class Poubelle {
	//Propri�t�s
	private String idPoubelle;
	private ArrayList<Levee> lesLevees = new ArrayList<Levee>();
	private TypeDechet nature;
	private String idHabitation;
	//Constructeurs
	/**
	 * Retourne le constructeur
	 * @param idPoubelle
	 * @param nature
	 * @param idHabitation
	 */
	public Poubelle(String idPoubelle, TypeDechet nature, String idHabitation) {
		super();
		this.idPoubelle = idPoubelle;
		this.nature = nature;
		this.idHabitation = idHabitation;
	}
	/**
	 * Retourne une poubelle sans l'habitation
	 * @param idPoubelle
	 * @param nature
	 */
	public Poubelle(String idPoubelle, TypeDechet nature) {
		super();
		this.idPoubelle = idPoubelle;
		this.nature = nature;
	}
	//Acesseurs Modificateurs
	/**
	 * Retourne idPoubelle
	 * @return idPoubelle
	 */
	public String getIdPoubelle() {
		return idPoubelle;
	}
	/**
	 * Modifie un idPoubelle
	 * @param idPoubelle
	 */
	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}
	/**
	 * Retourne les lev�es
	 * @return lesLevees
	 */
	public ArrayList<Levee> getLesLevees() {
		return lesLevees;
	}
	/**
	 * Modifie la liste des lev�es
	 * @param lesLevees
	 */
	public void setLesLevees(ArrayList<Levee> lesLevees) {
		this.lesLevees = lesLevees;
	}
	/**
	 * Retourne la nature
	 * @return nature
	 */
	public TypeDechet getNature() {
		return nature;
	}
	/**
	 * Modifie la nature
	 * @param nature
	 */
	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}
	/**
	 * Retourne l'identifiant de l'habitation
	 * @return idHabitation
	 */
	public String getIdHabitation() {
		return idHabitation;
	}
	/**
	 * Modifie l'identifiant de l'habitation
	 * @param idHabitation
	 */
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	//ToString
	@Override
	/**
	 * retourne la chaine de caract�re contenant les informations d'une poubelle
	 */
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", lesLevees=" + lesLevees.toString() + ", nature=" + nature + "]";
	}
	/**
	 * Retourne la liste des lev�es pour une poubelle, un mois d'un an
	 * @param an
	 * @param mois
	 * @return liste des lev�es pour une poubelle, un mois d'un an
	 */
	public ArrayList<Levee> getLesLevees(int an, int mois){
		ArrayList<Levee> lesLeveesMois = new ArrayList<Levee>();
		Calendar cal = Calendar.getInstance();
		int unAn, unMois;
		for(Levee l : lesLevees){
			cal.setTime(l.getLaDate());
			unAn = cal.get(Calendar.YEAR);
			unMois = cal.get(Calendar.MONTH) + 1;
			if(an == unAn && mois == unMois){
				lesLeveesMois.add(l);
			}
		}
		return lesLeveesMois;
	}
	/**
	 * Retourne le co�t des d�ch�ts pour une poubelle pour chaque lev�e
	 * @param an
	 * @param mois
	 */
	public double getCout(int an, int mois){
		double cout = 0;
		ArrayList<Levee> lesLeveesMois = this.getLesLevees(an, mois);
		for(Levee l : lesLeveesMois){
			cout = cout + l.getPoids() * nature.getTarif();
		}
		return cout;
	}
	/**
	 * Ajoute une lev�e dans la liste des lev�es
	 * @param laLevee
	 */
	public void ajoutLevee(Levee laLevee){
		this.lesLevees.add(laLevee);
	}
}
