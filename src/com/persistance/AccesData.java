package com.persistance;

import java.sql.Connection;
import java.util.ArrayList;

import com.metier.*;

public class AccesData {
	private static Connection con = AccesBd.getInstance();
	public static ArrayList<Habitation> getLesHabitations(){
		HabitationDAO hDao = new HabitationDAO();
		return hDao.retrieve();
	}
}
