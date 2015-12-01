package com.metier;

public class Facture {
	private int idF;
	private int anF;
	private int moisF;
	private String nomF;
	private String idHabitation;
	public Facture(int idF, int anF, int moisF, String nomF, String idHabitation) {
		super();
		this.idF = idF;
		this.anF = anF;
		this.moisF = moisF;
		this.nomF = nomF;
		this.idHabitation = idHabitation;
	}
	public Facture(int anF, int moisF, String nomF, String idHabitation) {
		super();
		this.anF = anF;
		this.moisF = moisF;
		this.nomF = nomF;
		this.idHabitation = idHabitation;
	}
	public int getIdF() {
		return idF;
	}
	public void setIdF(int idF) {
		this.idF = idF;
	}
	public int getAnF() {
		return anF;
	}
	public void setAnF(int anF) {
		this.anF = anF;
	}
	public int getMoisF() {
		return moisF;
	}
	public void setMoisF(int moisF) {
		this.moisF = moisF;
	}
	public String getNomF() {
		return nomF;
	}
	public void setNomF(String nomF) {
		this.nomF = nomF;
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	@Override
	public String toString() {
		return "Facture [idF=" + idF + ", anF=" + anF + ", moisF=" + moisF + ", nomF=" + nomF + ", idHabitation="
				+ idHabitation + "]";
	}
}
