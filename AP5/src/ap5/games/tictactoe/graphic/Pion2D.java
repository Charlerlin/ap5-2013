package ap5.games.tictactoe.graphic;

import javax.swing.JButton;

public class Pion2D extends JButton{
	
	public static final char croix;
	public static final char rond;
	public static final char vide;
	
	protected int val;
	protected char car;
	protected int x;
	protected int y; 
	
	static{
		croix = new Pion2D(-1, 'X');
		rond = new Pion2D(1, 'O');
		vide = new Pion2D(0, ' ');
	}
	
	protected Pion2D(int v, char c){
		setText(""+c);
		val = v; 
		car = c;
	}

}
