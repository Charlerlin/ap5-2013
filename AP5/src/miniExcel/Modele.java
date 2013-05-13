package miniExcel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Modele extends AbstractTableModel {
	
	ArrayList<String> listeEtu, nomCols;
	float[][] notes;
	
	public Modele() {
		nomCols = new ArrayList<String>();
		nomCols.add("Noms");
		nomCols.add("DS1");
		nomCols.add("DS2");
		nomCols.add("TP1");
		nomCols.add("TP2");
		nomCols.add("Finale");
		
		listeEtu.add("Antoine");
		listeEtu.add("Benjamin");
		listeEtu.add("Charles");
		listeEtu.add("Damien");
		listeEtu.add("MOYENNE");
		
		notes = new float[][] {{11,12,13,14,},{10,10,11,11},{15,16,17,18},{8,10,12,20}};
	}

	@Override
	public int getColumnCount() {
		return nomCols.size();
	}

	@Override
	public int getRowCount() {
		return listeEtu.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {
		if(lin<getRowCount() && col<getColumnCount()){
			if(lin==0)
				return nomCols.get(col);
			if(col==0)
				return listeEtu.get(lin-1);
			if(col==getColumnCount()-1)
				return finale(lin-1);
			if(lin==getRowCount()-1)
				return moyenne(col);
		}
		return null;
	}
	
	public Object moyenne(int col){
		double moy=0;
		for(int i=1; i<notes[i].length; i++){
			moy+= notes[i][col];
		}
		moy/=notes.length;
		return 0;
	}
	public Object finale(int lin){
		double moy=0;
		for(int i=1; i<notes.length; i++){
			moy+= notes[lin][i];
		}
		moy/=notes[0].length;
		return 0;
	}
	
}
