package ap5.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderController implements ChangeListener {
	
	protected SliderView slv;
	
	public SliderController(SliderView s){
		slv = s;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource().equals(slv.sb)){
			slv.model.setB(slv.sb.getValue());
		}
		if(e.getSource().equals(slv.sr)){
			slv.model.setR(slv.sr.getValue());
		}
		if(e.getSource().equals(slv.sv)){
			slv.model.setV(slv.sv.getValue());
		}
		
	}

}
