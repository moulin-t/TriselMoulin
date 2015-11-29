package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.TypeDechet;

public class TypeDechetDAO extends DAO<TypeDechet> {

	@Override
	public boolean create(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TypeDechet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TypeDechet find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<TypeDechet> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TypeDechet find(String id)
	{
		TypeDechet unTypeDechet = null;
		ResultSet rsTypeDechet = null;
		// texte de la requête à faire
		String sql = "select * from typedechet where idTypeDechet = '"+id+"';";
		try {
			// execution de la requête
			rsTypeDechet = con.createStatement().executeQuery(sql);
			// requête qui ramène 0 ou 1 tuple
			// test du résultat
			if (rsTypeDechet.next())
			{
				unTypeDechet = new TypeDechet(rsTypeDechet.getString(1), rsTypeDechet.getString(2), 
						rsTypeDechet.getDouble(3));
				// instanciation objet unUsager à faire
			}
		}
		catch (SQLException e) {
		}
		return unTypeDechet;
	}
}
