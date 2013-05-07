 package ap5.notes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JPanel {
	private JButton saisieB ;
	private JButton consultB ;
	private JButton quitB ;
	private JLabel nbEnreg ;
	
	public Main() {
		saisieB = new JButton("Saisie");
		consultB = new JButton("Consultation");
		quitB = new JButton("Quitter");
		nbEnreg = new JLabel(" enregistrements");
		
		setLayout(new GridLayout(4,1));
		
		saisieB.addActionListener(new ButtonController());
		consultB.addActionListener(new ButtonController());
		quitB.addActionListener(new ButtonController());
		
		add(saisieB);
		add(consultB);
		add(quitB);
		add(nbEnreg);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Main m = new Main();
		f.setContentPane(m);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);

	}
	
	class ButtonController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(quitB.equals(e.getSource()))
				System.exit(0);
			if(consultB.equals(e.getSource()))
				System.out.println("consult");
			if(saisieB.equals(e.getSource()))
				System.out.println("saisie");
			
		}
		
	}

}
