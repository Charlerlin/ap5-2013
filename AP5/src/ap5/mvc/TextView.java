package ap5.mvc;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextView extends JFrame implements Observer {
	
	private JLabel lr, lv, lb;
	protected JTextField tr, tv, tb;
	protected RVBModel model;
	
	public TextView(RVBModel m) {
		model = m;
		this.model.addObserver(this);
		this.setLayout(new GridLayout(3, 2));
		lr = new JLabel("R=");
		lv = new JLabel("V=");
		lb = new JLabel("B=");
		tr = new JTextField(""+model.getR());
		tr.addKeyListener(new KeyController(this));
		tv = new JTextField(""+model.getV());
		tv.addKeyListener(new KeyController(this));
		tb = new JTextField(""+model.getB()); 
		tb.addKeyListener(new KeyController(this));
		this.add(lr);
		this.add(tr);
		this.add(lv);
		this.add(tv);
		this.add(lb);
		this.add(tb);
		tr.setText(""+model.getR());
		tv.setText(""+model.getV());
		tb.setText(""+model.getB());
	}

	@Override
	public void update(Observable o, Object arg) {
		tr.setText(""+model.getR());
		tv.setText(""+model.getV());
		tb.setText(""+model.getB());
	}

}
