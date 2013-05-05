package ap5.mvc;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class SliderView extends JFrame implements Observer {
	
	private JLabel lr, lv, lb;
	protected JSlider sr, sv, sb;
	protected RVBModel model;
	
	public SliderView(RVBModel m) {
		model = m;
		this.model.addObserver(this);
		this.setLayout(new GridLayout(3, 2));
		lr = new JLabel("R=");
		lv = new JLabel("V=");
		lb = new JLabel("B=");
		sr = new JSlider();
		sr.addChangeListener(new SliderController(this));
		sv = new JSlider();
		sv.addChangeListener(new SliderController(this));
		sb = new JSlider();
		sb.addChangeListener(new SliderController(this));
		this.add(lr);
		this.add(sr);
		this.add(lv);
		this.add(sv);
		this.add(lb);
		this.add(sb);
		sr.setValue(model.getR());
		sv.setValue(model.getV());
		sb.setValue(model.getB());
	}

	@Override
	public void update(Observable o, Object arg) {
		sr.setValue(model.getR());
		sv.setValue(model.getV());
		sb.setValue(model.getB());
	}

}
