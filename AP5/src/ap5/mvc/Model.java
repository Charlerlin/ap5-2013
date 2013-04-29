package ap5.mvc;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable implements RVBModel{
	private int r, v, b;

	public Model(int r, int v, int b) {
		this.r = r;
		this.v = v;
		this.b = b;
	}

	public Model(){
		new Model(0,0,0);
	}

	@Override
	public int get(int idx) {
		switch(idx){
		case 0 : return getR();
		case 1 : return getV();
		case 2 : return getB();
		default : return 0;
		}
	}

	@Override
	public int getB() {
		return b;
	}

	@Override
	public int getR() {
		return r;
	}

	@Override
	public int getV() {
		return v;
	}

	@Override
	public void set(int idx, int value) {
		switch(idx){
		case 0 : setR(value);
		case 1 : setV(value);
		case 2 : setB(value);
		}

	}

	@Override
	public void setB(int b) {
		double oldR = this.r;
		double oldV = this.v;
		double oldB = this.b;
		this.b = b; 
		v = (int)((100-b)*(oldV/(oldR+oldV))); 
		r = (int)((100-b)*(oldR/(oldR+oldV))); 
		setChanged();
		notifyObservers();
		
	}

	@Override
	public void setR(int r) {
		double oldR = this.r;
		double oldV = this.v;
		double oldB = this.b;
		this.r = r;
		v = (int)((100-r)*(oldV/(oldV+oldB))); 
		b = (int)((100-r)*(oldB/(oldV+oldB))); 
		setChanged();
		notifyObservers();
	}

	@Override
	public void setV(int v) {
		double oldR = this.r;
		double oldV = this.v;
		double oldB = this.b;
		this.v = v; 
		r = (int)((100-v)*(oldR/(oldR+oldB))); 
		b = (int)((100-v)*(oldB/(oldR+oldB))); 
		setChanged();
		notifyObservers();
	}
	

	@Override
	public String toString() {
		return "r="+r+" v="+v+" b="+b;
	}

	public static void main(String[] args) {  
		/*RVBModel m = new Model(33,33,34);
		System.out.println(m);
		m.setR(50);
		System.out.println(m);*/
	}


}
