package ap5.games.tictactoe;

import java.util.Scanner;

import ap5.games.IGame;
import ap5.games.Joueur;

/**
 * 
 * @author charlerlin
 *
 */

public class TicTacToe implements IGame {
	protected Grille grille;
	protected Joueur j1;
	protected Joueur j2;
	protected Pion j1Sym;
	protected Pion j2Sym;

	public TicTacToe(){
		grille = new Grille();
		j1Sym = Pion.croix;
		j2Sym = Pion.rond;
	}

	@Override
	public void start() {
		Pion currentPion = j1Sym;
		while(!grille.fullGrid() && gameOver()==null){
			System.out.println(grille);
			System.out.println("C'est au joueur "+currentPion.car+" de jouer.");
			int move =-1;
			boolean validMove = false; 
			while(!validMove){
				move = enterCoords();
				validMove = validMove(move);
			}
			doMove(currentPion, move);
			if(currentPion==j1Sym)
				currentPion = j2Sym;
			else
				currentPion = j1Sym;
		}
		if(gameOver()==null && grille.fullGrid()){
			System.out.println(grille);
			System.out.println("C'est un match nul.");
		}
		else{
			System.out.println(grille);
			System.out.println("Bravo, c'est le joueur "+gameOver().car+" qui a gagné !");
		}
	}


	protected int enterCoords(){
		int ret=-1;
		int col=-1;
		int lin=-1;
		boolean validCoords = false;
		while(!validCoords){
			System.out.print("Entrer les coordonnées à jouer (ex : A1) : ");
			Scanner sc = new Scanner(System.in);
			String entry = sc.nextLine();

			if(!entry.isEmpty()){
				switch(entry.charAt(0)){ //étude de la colonne
				case 'A' : col = 0;
				break;
				case 'B' : col = 1;
				break;
				case 'C' : col = 2;
				break;
				default : col = -1;
				}
				if(entry.length()>1){
					switch(entry.charAt(1)){ //étude de ligne
					case '1' : lin = 0;
					break;
					case '2' : lin = 1;
					break;
					case '3' : lin = 2;
					break;
					default : lin = -1;
					}
				}
			}
			if(col==-1 || lin==-1){
				System.out.println("Entrée invalide, recommencez !");
			}
			else{
				validCoords = true;
			}
		}
		ret = col*10+lin;
		return ret;
	}

	protected boolean validMove(int move){
		int col = move/10;
		int lin = move%10;
		if(grille.getSquare(lin,col)==Pion.vide)
			return true;
		else
			return false;
	}

	protected Pion gameOver(){
		int getScore = getScore();
		if(getScore==0)
			return null;
		else if(getScore==-3)
			return j1Sym;
		else
			return j2Sym;
	}
	protected int getScore(){
		int[] score = grille.getScore();
		for(int i=0; i!=score.length; i++){
			if(score[i]==3 || score[i]==-3)
				return score[i];
		}
		return 0;
	}

	public boolean doMove(Pion sym, int move){
		if(validMove(move)){
			int col = move/10;
			int lin = move%10;
			grille.setSquare(lin, col, sym);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TicTacToe jeu = new TicTacToe();
		int coords = jeu.enterCoords();
		System.out.println("int : "+coords);
		System.out.println("ligne : "+coords%10+", colonne : "+coords/10);
	}

}
