package com.persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.metier.Levee;

public class LeveeDAO extends DAO<Levee> {

	@Override
	public boolean create(Levee obj) {
		boolean ok = true;
		java.sql.Date laDateSql = new java.sql.Date(obj.getLaDate().getTime());
		String sql = "insert into Levee(laDate, poids, idPoubelle) values('" + laDateSql +"', "+obj.getPoids()+", '"+obj.getIdPoubelle()+"');";
		try {
			con.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	@Override
	public boolean delete(Levee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Levee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Levee find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Levee> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Levee find(String id)
	{
		Levee uneLevee = null;
		ResultSet rsLevee = null;
		// texte de la requête à faire
		String sql = "select * from levee where idLevee = '"+id+"';";
		try {
			// execution de la requête
			rsLevee = con.createStatement().executeQuery(sql);
			// requête qui ramène 0 ou 1 tuple
			// test du résultat
			if (rsLevee.next())
			{
				// instanciation objet uneLevee
				Date laDate = new Date(rsLevee.getDate(2).getTime());
				int idL = rsLevee.getInt(1);
				Double poidsL = rsLevee.getDouble(3);
				String idPL = rsLevee.getString(4);
				uneLevee = new Levee(idL, laDate, poidsL, idPL);
			}
		}
		catch (SQLException e) {
		}
		return uneLevee;
	}
}
