package fr.iut.ap5.groupek.herlin.charles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener {
	//cette classe inutile devait servir à connecter le clavier à l'écran via la calculatrice
	protected Calculator calc;
	
	public ButtonController(Calculator calc){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("=")){
			calc.disp.compute();
		}
	}

}
