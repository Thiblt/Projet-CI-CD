package fr.digininamic.enumerations;

import org.junit.Test;
import static org.junit.Assert.*;

import fr.diginamic.enumerations.Saison;

public class TestSaison {

	@Test
	public void valueOfLibelleTest() {
		Saison saisonE=Saison.ETE;
		
		assertEquals(saisonE, Saison.valueOfLibelle("Eté"));
	}
	@Test
	public void valueOfLibelleTestNull() {
		
		assertNull( Saison.valueOfLibelle(null));
	}
}
