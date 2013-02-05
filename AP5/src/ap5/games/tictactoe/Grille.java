package ap5.games.tictactoe;

public class Grille {

	protected Pion[][] grille;
	
	Grille(){
		grille = new Pion[3][3];
		this.init();
	}
	
	protected void init(){
		for(int i=0; i!=grille.length; i++){
			for(int j=0; j!=grille[i].length; j++){
				grille[i][j]=Pion.vide;
			}
		}
	}
	
	public Pion getSquare(int l, int c){
		return grille[l][c];
	}
	public void setSquare(int l, int c, Pion p){
		grille[l][c]=p;
	}
	
	public boolean fullGrid(){
		for(int i=0; i!=grille.length; i++){
			for(int j=0; j!=grille[i].length; j++){
				if(grille[i][j]==Pion.vide)
					return false;
			}
		}
		return true;
	}
	public int[] getScore(){
		int[] score = new int[8];
		
		for(int i=0; i!=grille.length; i++){	//Calcul des scores en ligne
			for(int j=0; j!=grille[i].length; j++)
				score[i] += grille[i][j].val;
		}
		
		for(int j=0; j!=grille[0].length; j++){		//Calcul des scores en colonne
			for(int i=0; i!=grille.length; i++){
				score[j+grille.length] += grille[i][j].val;
			}
		}
		
		for(int i=0; i!=grille.length; i++){ 	//Calcul du score sur la première diagonale
			score[2*grille.length] += grille[i][i].val;
		}
		
		for(int i=0; i!=grille.length; i++){ 	//Calcul du score sur la seconde diagonale
			score[2*grille.length+1] += grille[i][grille.length-1-i].val;
		}
		
		return score;
	}
	
	public String toString(){
		String ret = "\n";
		ret += "  A B C\n";
		for(int i=0; i!=grille.length; i++){
			ret += i+1 +" ";
			for(int j=0; j!=grille.length; j++){
				ret += grille[i][j] + " ";
			}
			ret += "\n";
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println("voici la grille");
		System.out.println(new Grille());
		System.out.println("fin de la grille");
	}

}
