package ap5.counter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CounterV0 extends JPanel implements ActionListener {
	protected JLabel value;
	public CounterV0(){
		setLayout(new GridLayout(2,1));
		value = new JLabel("0", SwingConstants.CENTER);
		add(value);
		JPanel buttons = new JPanel();
		JButton inc = new JButton("+");
		JButton dec = new JButton("-");
		inc.addActionListener(this);
		dec.addActionListener(this);
		buttons.add(inc);
		buttons.add(dec);
		add(buttons);
	}
	
	public void changeValue(int i){
		int newValue = Integer.parseInt(value.getText()) + i;
		value.setText(""+newValue);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("+")){
			changeValue(+1);
		}
		else {
			changeValue(-1);
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Counter");
		f.getContentPane().add(new CounterV0());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}
