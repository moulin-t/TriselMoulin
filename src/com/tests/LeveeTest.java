package com.tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;

public class LeveeTest {
	private Date d1 = null;
	private Date d2 = null;
	private SimpleDateFormat dateFormat = null;
	private Calendar cal = null;
	private Levee le1 = null;
	private Levee le2 = null;
	
	@Before
	public void setUp() throws Exception {
		// format de la date
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		cal = Calendar.getInstance();
		try
		{
			// instanciation date de lev�e au format français
			d1 = dateFormat.parse("15/05/2015");
			// instanciation objet Lev�e avec les deux constructeurs
			le1 = new Levee(d1, 5, "p1");
			le2 = new Levee(2, d1, 10.5, "p2");
		} catch (ParseException e){
			e.printStackTrace();
		} 
	}

	@Test
	public void testLevee() {
		// test existence objet 
		// v�rifier les 2 instanciations
		assertNotNull(le1);
		assertNotNull(le2);
	}

	@Test
	public void testGetLaDate() {

		// � faire sur les 2 objets pour v�rifier les affectations 
		// dans les 2  constructeurs
		// r�cup�ration date de la lev�e l1 avec manipulation de date
		cal.setTime(le1.getLaDate());
		int year = cal.get(Calendar.YEAR);
		// extraction du mois mettre + 1 car d�marre � 0 et non pas 1
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		// comparaison des �l�ments extraits
		assertEquals(year,2015);
		assertEquals(month, 5);
		assertEquals(day, 15);
		// date de lev�e l2 avec dateFormat
		assertEquals("15/05/2015", dateFormat.format(le2.getLaDate()));
	
	}
	

	@Test
	public void testSetLaDate() {
		// changement de date, peut-�tre fait sur un seul objet
		try
		{
			// instanciation date de lev�e au format fran�ais
			d2 = dateFormat.parse("30/06/2015");
			// changement date de lev�e
			le1.setLaDate(d2);
			assertEquals("30/06/2015", dateFormat.format(le1.getLaDate()));

		} catch (ParseException e){
			e.printStackTrace();
		} 
	}

	@Test
	public void testGetPoids() {
		// � faire sur les 2 objets
		// situation de r�ussite
		assertTrue(le1.getPoids() == 5);
		// situation d'�chec
		assertFalse(le1.getPoids() == 0);
		// situation de r�ussite
		assertTrue(le2.getPoids() == 10.5);
		// situation d'�chec
		assertFalse(le2.getPoids() == 0);
	}
	@Test
	public void testGetIdPoubelle() {
		// � faire sur les 2 objets
		assertEquals(le1.getIdPoubelle(), "p1");
		assertNotEquals(le1.getIdPoubelle(), "");
		assertEquals(le2.getIdPoubelle(), "p2");
		assertNotEquals(le2.getIdPoubelle(), "");
	}
	@Test
	public void testGetIdLevee() {
		// � faire sur les 2 objets
		assertTrue(le1.getIdLevee() == 0);
		assertFalse(le1.getIdLevee() == 999);
		assertTrue(le2.getIdLevee() == 2);
		assertFalse(le2.getIdLevee() == 999);
	}
	@Test
	public void testSetPoids() {
		// peut-�tre fait sur un seul objet
		le1.setPoids(10);
		assertFalse(le1.getPoids() == 5);
		assertTrue(le1.getPoids() == 10);
		le2.setPoids(15);
		assertFalse(le2.getPoids() == 5);
		assertTrue(le2.getPoids() == 15);
		}
	@Test
	public void testToString() {
		String attenduL1 = "Levee [idLevee=0, laDate=Fri May 15 00:00:00 CEST 2015, poids=5.0, idPoubelle=p1]";
		String attenduL2 = "Levee [idLevee=2, laDate=Fri May 15 00:00:00 CEST 2015, poids=10.5, idPoubelle=p2]";
		assertEquals(le1.toString(), attenduL1);
		assertNotEquals(le1.toString(), "");
		assertEquals(le2.toString(), attenduL2);
		assertNotEquals(le2.toString(), "");
	}
}
