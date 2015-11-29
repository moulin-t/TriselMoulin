package com.persistance;

import java.sql.Connection;
import java.util.*;
//classe DAO generique indiqu�e par DAO<T>
	public abstract class DAO<T> {
	   protected   Connection con=AccesBd.getInstance();
	   
	   public DAO(){
	      this.con = AccesBd.getInstance();
	   }
	   
	   /**
	    * M�thode de cr�ation
	    * @param obj
	    * @return boolean 
	    */
	   public  abstract boolean create(T obj);
	   /**
	    * M�thode pour effacer
	    * @param obj
	    * @return boolean 
	    */
	   public  abstract boolean delete(T obj);
	   /**
	    * M�thode de mise � jour
	    * @param obj
	    * @return boolean
	    */
	   public  abstract boolean update(T obj);
	   /**
	    * M�thode de recherche des informations
	    * @param id
	    * @return T
	    */
	   public  abstract T find(int id);
	   /**
	    * M�thode de recherche des informations
	    * @return ArrayList<T>
	    */
	   public  abstract T find(String id);
	   /**
	    * M�thode de recherche des informations
	    * @return ArrayList<T>
	    */
	   public abstract ArrayList<T> retrieve();
	}

