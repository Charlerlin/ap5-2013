package ap5.convert;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConvertV2 extends JPanel{
	private JTextField tEuros;
	private JTextField tPounds; 
	private JLabel lEuros;
	private JLabel lPounds; 
	private JComboBox choix;
	
	private final String EUROStoPOUNDS = "Euros -> Pounds";
	private final String POUNDStoEUROS = "Pounds -> Euros";

	public ConvertV2(){
		setLayout(new FlowLayout());
		tEuros =  new JTextField();
//		tEuros.setColumns(10);
		tPounds = new JTextField();
//		tPounds.setColumns(10);
		lEuros = new JLabel("Euros", SwingConstants.CENTER);
		lPounds = new JLabel("Pounds", SwingConstants.CENTER);
		choix = new JComboBox(new String[] {EUROStoPOUNDS, POUNDStoEUROS});
		choix.addActionListener(new ButtonController());
		add(tEuros);
		add(lEuros);
		add(choix);
		add(tPounds);
		add(lPounds);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Convert");
		f.getContentPane().add(new ConvertV2());
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
			JComboBox cb = (JComboBox)e.getSource();
			String s = (String)cb.getSelectedItem();
			
			if(s.equals(EUROStoPOUNDS)){
				changeValue(tPounds, getValue(tEuros)*0.87375);
			}
			else{
				changeValue(tEuros, getValue(tPounds)/0.87375);
			}
		}

	}

}
