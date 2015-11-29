package com.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Habitation;
import com.metier.Poubelle;
import com.metier.Usager;

public class HabitationDAO extends DAO<Habitation> {

	@Override
	public boolean create(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Habitation find(String  id)
	{
		Habitation hab = null ;
		Usager u = null;
		Poubelle pb = null;
		String  sqlHab, sqlPoubelle; 
		ResultSet rsHab, rsPoubelle;
		PoubelleDAO pbDAO = new PoubelleDAO();
		UsagerDAO uDAO = new UsagerDAO();
		// requête de sélection de l'habitation à écrire
		sqlHab = "select * from habitation where idHabitation = '"+id+"';";
		try {
			// exécution requête
			rsHab = con.createStatement().executeQuery(sqlHab);
			// test  lecture car 0 ou 1 tuple
			if (rsHab.next())
			{   
				// récupération de l’objet Usager avec uDAO
				u = uDAO.find(rsHab.getString("idUsager"));
				// instanciation objet habitation
				hab = new Habitation(rsHab.getString("idHabitation"), rsHab.getString("adresseRue"), 
						rsHab.getString("adresseVille"), u);
				// requête de recherche des idPoubelle de l'habitation 
				sqlPoubelle = "select poubelle.idPoubelle from poubelle "
						+ "where idHabitation = '"+id+"';";
				// exécution requête de recherche des poubelles
				rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
				// parcours des poubelles,  requête ramène 0 ou n tuples
				while (rsPoubelle.next()) {
					// récupération objet Poubelle avec pbDAO
					pb = pbDAO.find(rsPoubelle.getString(1));
					// ajout de la poubelle à l'habitation
					hab.ajoutPoubelle(pb);
				}
			}
		}
		catch (SQLException e)  { 
		}
		return hab;
	}
	
	public ArrayList<Habitation> retrieve()
	{
		// déclaration et instanciation collection
		ArrayList<Habitation> lesHabs = new ArrayList<Habitation>();
		// déclaration jeu d’enregistrement
		ResultSet rsHab = null;
		// requête de sélection des idhabitation
		String sql = "select idHabitation from habitation;";
		try {
			rsHab = con.createStatement().executeQuery(sql);
			while  (rsHab.next())
			{
				// Appel à la méthode find qui ramène un objet habitation à rajouter à la collection
				lesHabs.add(this.find(rsHab.getString(1)));
			}
		}
		catch (SQLException e)  { 
		}
		// on retourne la collection de travail
		return lesHabs;
	}

	@Override
	public Habitation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
