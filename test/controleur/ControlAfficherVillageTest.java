package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Gaulois asterix;
	private Chef abracourcix;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	void setUp() throws Exception {
		village= new Village("Le village des irreductibles",10,5);
		asterix= new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		abracourcix =new Chef("abracourcix", 2, village);
		village.setChef(abracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() { 
		assertNotNull(controlAfficherVillage, "Le constructeur ne peut pas renvoyer un null");
	}

	@Test
	void testDonnerNomsVillageois() {
		assertNotNull(controlAfficherVillage.donnerNomsVillageois());
		System.out.println(controlAfficherVillage.donnerNomsVillageois());
	}

	@Test
	void testDonnerNomVillage() {
		String nomVillage="Le village des irreductibles";
		assertNotNull(controlAfficherVillage.donnerNomVillage());
		assertEquals(nomVillage,controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(5,controlAfficherVillage.donnerNbEtals());
	}

}
