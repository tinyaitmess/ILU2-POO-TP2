package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void afficherVendeurs(String[] vendeurs) {
		for (int i = 0; i < vendeurs.length; i++) {
			System.out.println(i+1 +"-" + vendeurs[i]);
		}
	}
	
	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Désolé, seuls les habitants du village peuvent acheter !");
		}
		System.out.println("Quel produit voulez-vous acheter ? \n");
		String produit = scan.nextLine();
		System.out.println("Chez quel commecant voulez-vous acheter des fleurs ?");
		String[] vendeurs =controlAcheterProduit.trouverVendeurs(produit);
		afficherVendeurs(vendeurs);
	}
}
