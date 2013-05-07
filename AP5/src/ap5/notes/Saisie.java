package ap5.notes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Saisie extends JPanel{
	private JLabel saisie;
	private JLabel nomL;
	private JLabel prenomL;
	private JLabel noteL;
	
	private JTextField nomT;
	private JTextField prenomT;
	private JTextField noteT;
	
	private JButton okB;
	private JButton cancelB;
	
	public Saisie() {
		saisie = new JLabel("Saisie d'une note");
		nomL = new JLabel("Nom : ");
		prenomL = new JLabel("Prenom : ");
		noteL = new JLabel("Note : ");
		
		nomT = new JTextField();
		prenomT = new JTextField();
		noteT = new JTextField();
	}
}
