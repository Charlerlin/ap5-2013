package ap5.counter;

import java.awt.event.*;

class ButtonListenerV3 implements ActionListener {
	protected CounterV3 cvm;
	public ButtonListenerV3(CounterV3 cvm){
		this.cvm = cvm;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("+")) cvm.changeValue(+1);
		else cvm.changeValue(-1);
	}
}