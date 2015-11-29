package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleDAO extends DAO<Poubelle> {

	@Override
	public boolean create(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Poubelle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Poubelle find(String id)
	{
		Poubelle p = null;
		TypeDechet typeD = null;
		Levee lv = null;
		ResultSet rsPoubelle = null;
		ResultSet rsLevee = null;
		// instanciation objets DAO car on va faire appel au find
		// pour ne pas tout faire de redondance
		LeveeDAO lvDAO = new LeveeDAO();
		TypeDechetDAO tdDAO = new TypeDechetDAO();
		// recherche de la poubelle concernée dans la base à écrire
		String sqlPoubelle = "select * from poubelle where idPoubelle = '"+id+"';";
		try {
			// exécution de la requête à écrire
				rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
				// test d’existence à écrire
			if (rsPoubelle.next()) {
				// appel à tdDAO pour récupérer l’objet TypeDechet // instanciation objet poubelle
				typeD = tdDAO.find(rsPoubelle.getString(2));
				p = new Poubelle(rsPoubelle.getString(1), typeD, rsPoubelle.getString(3));
				// requête recherche des id des levées pour la poubelle
				String sqlLevees = "select idLevee from levee, poubelle "
						+ "where poubelle.idPoubelle = levee.idPoubelle and levee.idPoubelle = '"+id+"';";
				// exécution de la requête
				rsLevee = con.createStatement().executeQuery(sqlLevees);
				// parcours des levées de la poubelle 0 ou n tuples
				while (rsLevee.next()) {
					// appel à la méthode find de lvDAO pour récupérer objet levee
					lv = lvDAO.find(rsLevee.getString(1));
					// ajout levée à la poubelle
					p.ajoutLevee(lv);
				}
			}
		}
		catch (SQLException e) {
		}
		return p;
	}
	
	@Override
	public ArrayList<Poubelle> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
