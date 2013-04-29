package ap5.mvc;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextView extends JFrame implements Observer {
	
	private JLabel lr, lv, lb;
	private JTextField tr, tv, tb;
	private RVBModel model;
	
	public TextView(RVBModel m) {
		model = m;
		this.setLayout(new GridLayout(3, 2));
		lr = new JLabel("R=");
		lv = new JLabel("V=");
		lb = new JLabel("B=");
		tr = new JTextField(""+model.getR());
		tv = new JTextField(""+model.getV());
		tb = new JTextField(""+model.getB()); 
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
		// TODO Auto-generated method stub

	}

}
