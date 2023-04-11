package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abracourcix;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Init ....");
		village = new Village("le village des irreductibles",10,5);
		abracourcix =new Chef("abracourcix", 2, village);
		village.setChef(abracourcix);
	}

	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Constructeur ne peut pas être null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine",10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertTrue(controlEmmenager.isHabitant("abracourcix"));
		assertFalse(controlEmmenager.isHabitant("barbapapa"));
		controlEmmenager.ajouterDruide("Panoramix", 5, 2, 8);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Panoramix", 5, 2, 8);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine",10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
	}

}
