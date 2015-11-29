package com.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.metier.Usager;

public class UsagerTest {
private Usager u1 = null;
private Usager u2 = null;
	@Before
	public void setUp() throws Exception {
		u1 = new Usager("u1", "Dupont", "Laurent", "user1", "mdp1");
		u2 = new Usager("u2", "Albert", "André", "user2", "mdp2");
	}
	@Test
	public void testUsager() {
		assertNotNull(u1);
		assertNotNull(u2);
	}

	@Test
	public void testGetIdUsager() {
		assertEquals(u1.getIdUsager(), "u1");
		assertNotEquals(u1.getIdUsager(), "test");
		assertEquals(u2.getIdUsager(), "u2");
		assertNotEquals(u2.getIdUsager(), "test");
	}

	@Test
	public void testGetNom() {
		assertEquals(u1.getNom(), "Dupont");
		assertNotEquals(u1.getNom(), "test");
		assertEquals(u2.getNom(), "Albert");
		assertNotEquals(u2.getNom(), "test");
	}

	
	@Test
	public void testGetPrenom() {
		assertEquals(u1.getPrenom(), "Laurent");
		assertNotEquals(u1.getPrenom(), "test");
		assertEquals(u2.getPrenom(), "André");
		assertNotEquals(u2.getPrenom(), "test");
	}
	
	@Test
	public void testGetNomUser() {
		assertEquals(u1.getNomUser(), "user1");
		assertEquals(u2.getNomUser(), "user2");
	}
	
	@Test
	public void testGetMotDePasse() {
		assertEquals(u1.getMotDePasse(), "mdp1");
		assertEquals(u2.getMotDePasse(), "mdp2");
	}
	
	@Test
	public void testSetNomUser() {
		u1.setNomUser("user1");
		assertEquals(u1.getNomUser(), "user1");
	}
	
	@Test
	public void testSetMotDePasse() {
		u1.setMotDePasse("azrzz");
		assertEquals(u1.getMotDePasse(), "azrzz");
	}
	
		
	@Test
	public void testToString() {
		String attenduU1 = "Usager [idUsager=u1, nom=Dupont, prenom=Laurent, nomUser=user1, motDePasse=mdp1]";
		String attenduU2 = "Usager [idUsager=u2, nom=Albert, prenom=André, nomUser=user2, motDePasse=mdp2]";
		assertEquals(u1.toString(), attenduU1);
		assertEquals(u2.toString(), attenduU2);
	}
}
