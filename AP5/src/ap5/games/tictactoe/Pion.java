package ap5.games.tictactoe;

/**
 * 
 * @author charlerlin
 *
 */

public class Pion {
	public static final Pion croix;
	public static final Pion rond;
	public static final Pion vide;
	
	protected int val;
	protected char car;
	
	static{
		croix = new Pion(-1, 'X');
		rond = new Pion(1, 'O');
		vide = new Pion(0, ' ');
	}
	
	protected Pion(int v, char c){
		val = v;
		car = c;
	}
	
	public String toString(){
		return ""+car;
	}

}
