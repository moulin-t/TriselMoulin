package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Usager;

public class UsagerDAO extends DAO<Usager> {

	@Override
	public boolean create(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usager find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usager> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Usager find(String id)
	{
		Usager unUsager = null;
		ResultSet rsUsager = null;
		// texte de la requête à faire
		String sql = "select * from usager where idUsager = '"+id+"';";
		try {
			// execution de la requête
			rsUsager = con.createStatement().executeQuery(sql);
			// requête qui ramène 0 ou 1 tuple
			// test du résultat
			if (rsUsager.next())
			{
				unUsager = new Usager(rsUsager.getString("idUsager"), rsUsager.getString("nom"), 
						rsUsager.getString("prenom"), rsUsager.getString("nomUser"), rsUsager.getString("motDePasse"));
				// instanciation objet unUsager à faire
			}
		}
		catch (SQLException e) {
		}
		return unUsager;
	}
}
