package ap5.mvc;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {

	protected TextView tv;

	public KeyController(TextView t) {
		tv = t;
	}
	@Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(tv.tb.equals(e.getSource()))
				try {
					tv.model.setB(Integer.parseInt(tv.tb.getText()));
				} catch (Exception e2) {
					System.err.println("Cannot parse Blue");
				}
			if(tv.tr.equals(e.getSource()))
				try {
					tv.model.setR(Integer.parseInt(tv.tr.getText()));
				} catch (Exception e2) {
					System.err.println("Cannot parse Red");
				}
			if(tv.tv.equals(e.getSource()))
				try {
					tv.model.setV(Integer.parseInt(tv.tv.getText()));
				} catch (Exception e2) {
					System.err.println("Cannot parse Green");
				}
			
		}
	}
}
