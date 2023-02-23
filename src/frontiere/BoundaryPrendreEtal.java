package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis desolee " + nomVendeur + " je vais regarder " + "si je peux trouver un etal");
		} else {
			System.out.println("Bonjour " + nomVendeur + " , je vais regarder si je peux vous trouver un etal");

			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Desolee " + nomVendeur + " je n'ai plus d'etal qui ne soit pas deja occupe");
			} else {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un etal pour vous !");
				System.out.println("Mais il me faudrait quelque renseignements :");
				String produit = Clavier.entrerString("Quel produit souhaitez-vous vendre ?");
				int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous vendre ?");
				int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				if (numeroEtal != -1) {
					System.out.println("Le vendeur " + nomVendeur + " s'est installe a l'etal n°" + numeroEtal);
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		// TODO a completer

	}
}
