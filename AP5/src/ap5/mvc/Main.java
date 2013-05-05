package ap5.mvc;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Main {
	/*public static void main(String[] args) {
	    RVBModel model = new Model(33,33,34);
	    TextualView vue = new TextualView(model);
	    RandomControler controler = new RandomControler(model);
	    controler.go(15);
	  }//*/
	public static void main(String[] args) throws InterruptedException {
		RVBModel model = new Model(33,33,34);
		TextualView txv = new TextualView(model);
		JPanel p = new GraphicalView(model, Color.RED, Color.GREEN,
				Color.BLUE);
		JFrame f = new JFrame("GraphicalView");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(p);
		f.pack();
		f.setVisible(true);
		
		JFrame f2 = new TextView(model);
		f2.setName("TextView");
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.pack();
		f2.setVisible(true);
		
		JFrame f3 = new SliderView(model);
		f3.setName("SliderView");
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f3.pack();
		f3.setVisible(true);
		RandomControler rc = new RandomControler(model);
		//rc.go(15);
	}//*/

}
