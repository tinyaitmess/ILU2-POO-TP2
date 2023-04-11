package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Gaulois asterix;
	private Chef abracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	void setUp() throws Exception {
		village= new Village("Le village des irreductibles",10,5);
		asterix= new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		abracourcix =new Chef("abracourcix", 2, village);
		village.setChef(abracourcix);
		controlVerifierIdentite= new ControlVerifierIdentite(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite,"constructeur non vide");
	}

	@Test
	void testVerifierIdentite() {
		//village.installerVendeur(asterix, "produit", 0);
		assertNotNull(controlVerifierIdentite.verifierIdentite("Asterix"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("maman"));
	}

}
