package fr.iut.ap5.groupek.herlin.charles;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author charlerlin
 *
 */

//Cette classe est encore inerte du à un problème de conception qui empêchait de la relier à la classe principale
public class Keypad extends JPanel{
	protected JButton b0;
	protected JButton b1;
	protected JButton b2;
	protected JButton b3;
	protected JButton b4;
	protected JButton b5;
	protected JButton b6;
	protected JButton b7;
	protected JButton b8;
	protected JButton b9;
	protected JButton bdot;
	protected JButton beq;
	protected JButton bplus;
	protected JButton bminus;
	protected JButton bmult;
	protected JButton bdiv;
	
	protected Calculator calc;
	
	
	public Keypad(Calculator c){
		this.setLayout(new GridLayout(4,4,10,10));
		this.createButtons();
		this.addButtons();
		calc = c;
	}
	
	protected void createButtons(){
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bdot = new JButton(".");
		beq = new JButton("=");
		beq.addActionListener(new ButtonController(this));
		bplus = new JButton("+");
		bminus = new JButton("-");
		bmult = new JButton("*");
		bdiv = new JButton("/");
		bplus.addActionListener(new ButtonController(this));
		bminus.addActionListener(new ButtonController(this));
		bmult.addActionListener(new ButtonController(this));
		bdiv.addActionListener(new ButtonController(this));
	}
	protected void addButtons(){
		this.add(b7);
		this.add(b8);
		this.add(b9);
		this.add(bdiv);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(bmult);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(bminus);
		this.add(b0);
		this.add(bdot);
		this.add(beq);
		this.add(bplus);
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Keypad");
		f.getContentPane().add(new Keypad(null));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}
