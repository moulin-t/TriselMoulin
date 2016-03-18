package com.persistance;

import java.sql.*;

//	 classe permettant l'ouverture, la fermeture de la base //mysql bd_trisel sur localhost 
public class AccesBd {
	// description des propri�t�s
	private  static Connection con=null;
	private static String url;
	public static Connection  getInstance() {
		// acc�s direct sans source de donn�es odbc
		url="jdbc:mysql://localhost/db_trisel";
		if (con==null)
		{
			try
			{// chargement du driver, librairie mysql connector li�e au projet
				Class.forName("com.mysql.jdbc.Driver");
				// connexion utilisateur root, pas de mdp
				con=DriverManager.getConnection(url,"moulin-t","mythibaud");
			}
			// ouverture de la connexion
			catch (ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
				System.out.println("échec driver");
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage());
				System.out.println("échec de connexion bd ");
			}
		}

		return con;
	}
	//	 fermeture de la connexion
	public static void close(){
		try { 
			con.close();
		}
		catch(Exception e) {e.printStackTrace();
		System.out.println("probl�me lors de la fermeture");}
	}
}


