package ap5.apiBatailleNavale;

import batailleNavale.modele.BatailleNavale;
import batailleNavale.modele.CaseNotFoundException;
import batailleNavale.modele.Joueur;

/**
 * 
 * @author charlerlin
 *
 */

public class JoueurRandom extends Joueur{

	public JoueurRandom(String name, BatailleNavale plateau) {
		super(name, plateau);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void joue() {
		BatailleNavale bn = this.getModele();
		int h = (int)(Math.random() * bn.getHauteur());
		int l = (int)(Math.random() * bn.getLargeur());
		try {
			bn.tir(h, l);
		} catch (CaseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
