package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Facture;

public class FactureDAO extends DAO<Facture> {

	@Override
	public boolean create(Facture obj) {
		String sqlEx = "select * from facture where anF = " + obj.getAnF() + 
				" and moisF = " + obj.getMoisF() + 
				" and idHabitation = '" + obj.getIdHabitation() + "';";
		try {
			ResultSet rsF = con.createStatement().executeQuery(sqlEx);
			if(!rsF.next()){
				String sqlAdd = "insert into facture (anF, moisF, nomF, idHabitation) values (" + obj.getAnF() + ","
						+ " " + obj.getMoisF() + ", '" + obj.getNomF() + "', '" + obj.getIdHabitation() + "');";
				con.createStatement().executeUpdate(sqlAdd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Facture find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Facture> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
