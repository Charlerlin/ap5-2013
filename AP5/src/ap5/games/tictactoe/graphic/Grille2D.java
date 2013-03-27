//package ap5.games.tictactoe.graphic;
//
//import java.awt.GridLayout;
//
//import javax.swing.JPanel;
//
//public class Grille2D extends JPanel{
//	protected Pion2D[][] grille;
//	protected GridLayout gridL; 
//
//	Grille2D(){
//		grille = new Pion2D[3][3];
//		gridL = new GridLayout(3, 3);	
//		this.setLayout(gridL);
//		this.init();
//	}
//
//	protected void init(){
//		for(int i=0; i!=gridL.getRows(); i++){
//			for(int j=0; j!=gridL.getColumns(); j++){
//				grille[i][j]=Pion2D.vide;
//				this.add(grille[i][j]);
//			}
//		}
//	}
//
//	public Pion2D getSquare(int l, int c){
//		return grille[l][c];
//	}
//	public void setSquare(int l, int c, Pion2D p){
//		grille[l][c]=p;
//	}
//
//	public boolean fullGrid(){
//		for(int i=0; i!=grille.length; i++){
//			for(int j=0; j!=grille[i].length; j++){
//				if(grille[i][j]==Pion2D.vide)
//					return false;
//			}
//		}
//		return true;
//	}
//	public int[] getScore(){
//		int[] score = new int[8];
//
//		for(int i=0; i!=grille.length; i++){	//Calcul des scores en ligne
//			for(int j=0; j!=grille[i].length; j++)
//				score[i] += grille[i][j].val;
//		}
//
//		for(int j=0; j!=grille[0].length; j++){		//Calcul des scores en colonne
//			for(int i=0; i!=grille.length; i++){
//				score[j+grille.length] += grille[i][j].val;
//			}
//		}
//
//		for(int i=0; i!=grille.length; i++){ 	//Calcul du score sur la première diagonale
//			score[2*grille.length] += grille[i][i].val;
//		}
//
//		for(int i=0; i!=grille.length; i++){ 	//Calcul du score sur la seconde diagonale
//			score[2*grille.length+1] += grille[i][grille.length-1-i].val;
//		}
//
//		return score;
//	}
//}
