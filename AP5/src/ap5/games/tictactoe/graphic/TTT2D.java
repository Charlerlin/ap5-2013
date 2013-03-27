//package ap5.games.tictactoe.graphic;
//
//import java.awt.Container;
//import java.util.Scanner;
//
//import javax.swing.BoxLayout;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//import ap5.games.IGame;
//import ap5.games.Joueur;
//
//public class TTT2D extends JFrame implements IGame{
//	protected Grille2D grille;
//	protected Joueur j1;
//	protected Joueur j2;
//	protected Pion2D j1Sym;
//	protected Pion2D j2Sym;
//	protected JLabel invite;
//
//	public TTT2D(){
//		grille = new Grille2D();
//		j1Sym = Pion2D.croix;
//		j2Sym = Pion2D.rond;
//		Container pane = this.getContentPane();
//		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
//		invite = new JLabel("Jeu de TicTacToe");
//		pane.add(invite);
//		pane.add(grille);
//	}
//
//	@Override
//	public void start() {
//		Pion2D currentPion = j1Sym;
//		while(!grille.fullGrid() && gameOver()==null){
//			//afficher la grille ou rafraichir
//			invite.setText("C'est au joueur "+currentPion.car+" de jouer.");
//			int move =-1;
//			boolean validMove = false; 
//			while(!validMove){
//				move = enterCoords();
//				validMove = validMove(move);
//			}
//			doMove(currentPion, move);
//			if(currentPion==j1Sym)
//				currentPion = j2Sym;
//			else
//				currentPion = j1Sym;
//		}
//		if(gameOver()==null && grille.fullGrid()){
//			//rafraichir la grille
//			invite.setText("C'est un match nul.");
//		}
//		else{
//			//rafraichir la grille
//			invite.setText("Bravo, c'est le joueur "+gameOver().car+" qui a gagné !");
//		}
//	}
//
//
//	protected int enterCoords(){
//		int ret=-1;
//		int col=-1;
//		int lin=-1;
//		boolean validCoords = false;
//		while(!validCoords){
//			System.out.print("Entrer les coordonnées à jouer (ex : A1) : ");
//			Scanner sc = new Scanner(System.in);
//			String entry = sc.nextLine();
//
//			if(!entry.isEmpty()){
//				switch(entry.charAt(0)){ //étude de la colonne
//				case 'A' : col = 0;
//				break;
//				case 'B' : col = 1;
//				break;
//				case 'C' : col = 2;
//				break;
//				default : col = -1;
//				}
//				if(entry.length()>1){
//					switch(entry.charAt(1)){ //étude de ligne
//					case '1' : lin = 0;
//					break;
//					case '2' : lin = 1;
//					break;
//					case '3' : lin = 2;
//					break;
//					default : lin = -1;
//					}
//				}
//			}
//			if(col==-1 || lin==-1){
//				System.out.println("Entrée invalide, recommencez !");
//			}
//			else{
//				validCoords = true;
//			}
//		}
//		ret = col*10+lin;
//		return ret;
//	}
//
//	protected boolean validMove(int move){
//		int col = move/10;
//		int lin = move%10;
//		if(grille.getSquare(lin,col)==Pion2D.vide)
//			return true;
//		else
//			return false;
//	}
//
//	protected Pion2D gameOver(){
//		int getScore = getScore();
//		if(getScore==0)
//			return null;
//		else if(getScore==-3)
//			return j1Sym;
//		else
//			return j2Sym;
//	}
//	protected int getScore(){
//		int[] score = grille.getScore();
//		for(int i=0; i!=score.length; i++){
//			if(score[i]==3 || score[i]==-3)
//				return score[i];
//		}
//		return 0;
//	}
//
//	public boolean doMove(Pion2D currentPion, int move){
//		if(validMove(move)){
//			int col = move/10;
//			int lin = move%10;
//			grille.setSquare(lin, col, currentPion);
//			return true;
//		}
//		return false;
//	}
//
//	public static void main(String[] args) {
//		JFrame TTT = new TTT2D();
//		TTT.pack();
//		TTT.setVisible(true);
//	}
//}
