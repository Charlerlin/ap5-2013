package ap5.apiBatailleNavale;

import batailleNavale.modele.BatailleNavale;

/**
 * 
 * @author charlerlin
 *
 */

public class BatailleNavaleTexte {
	
	public static void main(String[] args) {
		BatailleNavale jeu = new BatailleNavale(10, 10);
		JoueurRandom batman = new JoueurRandom("Batman", jeu);
		JoueurRandom pacman = new JoueurRandom("Pacman", jeu);
		jeu.addJoueurs( batman, pacman);
		jeu.ajouteBateauxRandom(0);
		jeu.ajouteBateauxRandom(1);
		System.out.println(jeu);
		while(jeu.gagnant()==null){
			batman.joue();
			pacman.joue();
			System.out.println(jeu);
		}
		System.out.println(jeu.gagnant());
		
	}
}
