package fr.iut.ap5.groupek.herlin.charles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author charlerlin
 *
 */
public class ButtonController implements ActionListener {
	//cette classe inutile devait servir à connecter le clavier à l'écran via la calculatrice
	protected Keypad keyp;
	
	public ButtonController(Keypad keyp){
		this.keyp = keyp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("=")){
			keyp.calc.disp.compute();
		}
		if(e.getActionCommand().equals("+")){
			keyp.calc.disp.changeOp(Display.PLUS);
		}
		if(e.getActionCommand().equals("-")){
			keyp.calc.disp.changeOp(Display.MINUS);
		}
		if(e.getActionCommand().equals("*")){
			keyp.calc.disp.changeOp(Display.MULT);
		}
		if(e.getActionCommand().equals("/")){
			keyp.calc.disp.changeOp(Display.DIV);
		}
	}

}
