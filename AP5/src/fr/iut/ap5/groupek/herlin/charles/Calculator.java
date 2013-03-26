package fr.iut.ap5.groupek.herlin.charles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author charlerlin
 *
 */

public class Calculator extends JPanel{
	protected Display disp;
	protected Keypad keyp;
	
	public Calculator(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		disp = new Display();
		//keyp = new Keypad();
		this.add(disp);
		//this.add(keyp);
	}
	
	public ButtonController addBL(Keypad kp){
		return new ButtonController(this);
	}

	
	public static void main(String[] args) {
		JFrame f = new JFrame("Keypad");
		f.getContentPane().add(new Calculator());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}

}
