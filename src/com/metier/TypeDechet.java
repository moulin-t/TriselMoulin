package com.metier;

/**
 * 
 * @author moulin-t
 * @version 1.0
 */

public class TypeDechet {
	//Propri�t�s
	private String code;
	private String libelle;
	private double tarif;
	//Constructeur
	/**
	 * Retourne un type de d�chets
	 * @param code
	 * @param libelle
	 * @param tarif
	 */
	public TypeDechet(String code, String libelle, double tarif) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.tarif = tarif;
	}
	//Acesseurs Modificateurs
	/**
	 * Retourne le code du type de d�chets
	 * @return code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Modifie le code du type de d�chets
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * Retourne le libelle du type de d�chet
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * Modifie le libelle du type de d�chet
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * Retourne le tarif du type de d�chets
	 * @return tarif
	 */
	public double getTarif() {
		return tarif;
	}
	/**
	 * Modifie le tarif du type de d�chets
	 * @param tarif
	 */
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	//ToString
	@Override
	/**
	 * retourne la chaine de caract�re contenant les informations d'un type de d�chets
	 */
	public String toString() {
		return "TypeDechet [code=" + code + ", libelle=" + libelle + ", tarif=" + tarif + "]";
	}
}
