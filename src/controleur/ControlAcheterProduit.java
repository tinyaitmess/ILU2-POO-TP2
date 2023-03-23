package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
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
	
	public void verifierSuffisanceProduit (String nomAcheteur,int nbProduit,String nomVendeur)
	{
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int nbVendre=etal.getQuantite();
		if (nbVendre==0)
			System.out.println(nomAcheteur+" veut acheter"+nbProduit+etal.getProduit()+" malheureusement il ny en a plus");
		else if (nbVendre-nbProduit<0)
			{
			System.out.println(nomAcheteur+" veut acheter"+nbProduit+etal.getProduit()+ "malheureusement "+nomVendeur+ "n'en a que "+etal.getQuantite());
			etal.acheterProduit(nbVendre);
			}else {
			System.out.println(nomAcheteur+" achete"+nbProduit+etal.getProduit());
			etal.acheterProduit(nbProduit);
		}
	}
	
	
	
	
}
