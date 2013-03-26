package fr.iut.ap5.groupek.herlin.charles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author charlerlin
 *
 */

public class Display extends JPanel{
	protected JTextField op1;
	protected JTextField op2;
	protected JComboBox op; 
	protected JButton equals;
	protected JLabel result;

	public static final char PLUS = '+';
	public static final char MINUS = '-';
	public static final char MULT = '*';
	public static final char DIV = '/';

	public Display(){
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.createElements();
		this.addElements();
		this.setPreferredSize(new Dimension(300, 25));
	}

	/**
	 * créer les éléments du blocs
	 */
	protected void createElements(){
		op1 = new JTextField();
		op1.addKeyListener(new KeyController());
		op2 = new JTextField();
		op2.addKeyListener(new KeyController());
		op = new JComboBox(new String[] {""+PLUS, ""+MINUS, ""+MULT, ""+DIV});
		equals = new JButton(" = ");
		equals.addActionListener(new ButtonController());
		result = new JLabel("0");
	}
	/**
	 * ajoute les éléments créés au bloc
	 */
	protected void addElements(){
		this.add(op1);
		this.add(op);
		this.add(op2);
		this.add(equals);
		this.add(result);
	}

	/**
	 * calcule et change l'affichage
	 * @param op1
	 * @param op2
	 */
	protected void compute(double op1, double op2){
		if(op.getSelectedItem().equals("+")){
			double res = op1 + op2;
			result.setText(""+res);
		}
		else if(op.getSelectedItem().equals("-")){
			double res = op1 - op2;
			result.setText(""+res);
		}
		else if(op.getSelectedItem().equals("*")){
			double res = op1 * op2;
			result.setText(""+res);
		}
		else if(op.getSelectedItem().equals("/")){
			if(op2!=0){
				double res = op1 / op2;
				result.setText(""+res);
			}
			else{
				result.setText("Erreur");
			}
		}
	}
	
	/**
	 * récupère les opérandes et appelle le calcul
	 */
	public void compute(){
		if(!op1.getText().isEmpty() && !op2.getText().isEmpty()){
			double op1n = 0;
			double op2n = 0;
			try {
				op1n = Double.parseDouble(op1.getText());
			} catch (Exception e2) {
				System.err.println("L'opérande 1 n'est pas correcte.");
			}
			try {
				op2n = Double.parseDouble(op2.getText());
			} catch (Exception e2) {
				System.err.println("L'opérande 2 n'est pas correcte.");
			}
			compute(op1n, op2n);
		}
	}

	/**
	 * classe qui devait permettre de changer l'opérateur depuis le clavier
	 * @param opc
	 */
	public void changeOp(char opc){
		switch(opc){
		case PLUS : op.setSelectedItem(PLUS);
		break; 
		case MINUS : op.setSelectedItem(MINUS);
		break;
		case MULT : op.setSelectedItem(MULT);
		break;
		case DIV : op.setSelectedItem(DIV);
		break;
		}
	}

	/**
	 * classe interne de controle du bouton =
	 * @author charlerlin
	 *
	 */
	class ButtonController implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				compute();
		}
	}

	/**
	 * classe interne pour gérer la frappe de Entrée
	 * @author charlerlin
	 *
	 */
	class KeyController extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				compute();
			}
		}
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Keypad");
		f.getContentPane().add(new Display());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		f.setPreferredSize(new Dimension(400, 75));
		f.pack();
		f.setVisible(true);
	}

}
