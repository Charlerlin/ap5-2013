package ap5.mvc;

import java.util.Observable;
import java.util.Observer;

public class TextualView implements Observer {
	
	private RVBModel model;
	
	public TextualView(RVBModel m) {
		model = m;
		m.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(model);
	}

}
