package ap5.convert;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConvertV1 extends JPanel{
	private JTextField tEuros;
	private JTextField tPounds; 
	private JLabel lEuros;
	private JLabel lPounds; 
	private JButton eTp;
	private JButton pTe;

	public ConvertV1(){
		setLayout(new GridLayout(3,2));
		tEuros =  new JTextField();
		tPounds = new JTextField();
		lEuros = new JLabel("Euros", SwingConstants.CENTER);
		lPounds = new JLabel("Pounds", SwingConstants.CENTER);
		eTp = new JButton("Euros -> Pounds");
		eTp.addActionListener(new ButtonController());
		pTe = new JButton("Pounds -> Euros");
		pTe.addActionListener(new ButtonController());
		add(tEuros);
		add(lEuros);
		add(eTp);
		add(pTe);
		add(tPounds);
		add(lPounds);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Convert");
		f.getContentPane().add(new ConvertV1());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}

	public void changeValue(JTextField text, double val){
		text.setText(""+val);
	} 
	
	public double getValue(JTextField field){
		String s = "";
		try {
			s = field.getText();
		} catch (Exception e) {
			System.err.println(e+" Texte vide");
		}
		if(s.isEmpty()){
			System.err.println("Texte vide");
			return 0;
		}
		double val;
		try {
			val = Double.parseDouble(s);
			return val;
		} catch (Exception e) {
			System.err.println(e+" Entrée non conforme");
		}
		return 0;
	}

	class ButtonController implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Euros -> Pounds")){
				changeValue(tPounds, getValue(tEuros)*0.87375);
			}
			else{
				changeValue(tEuros, getValue(tPounds)/0.87375);
			}
		}

	}

}
