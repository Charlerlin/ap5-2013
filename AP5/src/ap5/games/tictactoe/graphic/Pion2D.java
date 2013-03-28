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
		croix = 'X';
		rond = 'O';
		vide = ' ';
	}
	
	protected Pion2D(int v, char c, int xa, int ya){
		setText(""+c);
		val = v; 
		car = c;
		x=xa;
		y=ya;
	}

}
