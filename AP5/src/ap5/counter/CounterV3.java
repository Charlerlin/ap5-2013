package ap5.counter;

import java.awt.*;
import javax.swing.*;


public class CounterV3 extends JPanel {
	private static final long serialVersionUID = 1L;
	protected JLabel value;

	public CounterV3() {
		setLayout(new GridLayout(2,1));
		value = new JLabel("0", SwingConstants.CENTER);
		add(value);
		JPanel buttons = new JPanel();
		JButton inc = new JButton("+");
		JButton dec = new JButton("-");
		inc.addActionListener(new ButtonListenerV3(this));
		dec.addActionListener(new ButtonListenerV3(this));
		buttons.add(inc);
		buttons.add(dec);
		add(buttons);
	}
	
	public void changeValue(int i){
		int newValue = Integer.parseInt(value.getText()) + i;
		value.setText(""+newValue);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Counter");
		f.getContentPane().add(new CounterV3());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}
