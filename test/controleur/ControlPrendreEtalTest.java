package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village ;
	private Gaulois asterix;
	private Chef abracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	
	
	@BeforeEach
	void setUp() throws Exception {
		village= new Village("Le village des irreductibles",10,1);
		asterix= new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		abracourcix =new Chef("abracourcix", 2, village);
		village.setChef(abracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal,"cons ne peut pas renvoyer un null");
	}

	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Asterix", "produit", 2);
		assertFalse(controlPrendreEtal.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		assertEquals(0,controlPrendreEtal.prendreEtal("Asterix", "produit", 2));
		
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
		assertFalse(controlPrendreEtal.verifierIdentite("blabla"));
	}

}
