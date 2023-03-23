package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String vendeur) {
		return controlVerifierIdentite.verifierIdentite(vendeur);
	}
	
	public String[] trouverVendeurs(String produit) {
		Gaulois[] vendeursProduit=village.rechercherVendeursProduit(produit);
		int nbVendeursProduit=vendeursProduit.length;
		String[] nomVendeurs = new String[nbVendeursProduit];
		for (int i=0;i<=nbVendeursProduit;i++) {
			nomVendeurs[i]=vendeursProduit[i].getNom();
		}
		return nomVendeurs;
	}
	
	
}
