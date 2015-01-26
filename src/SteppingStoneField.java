import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


public class SteppingStoneField {
	public ArrayList<ArrayList<Color>> data = new ArrayList<ArrayList<Color>>();
	private Random r = new Random();
	private Color[] colors = {Color.BLACK, Color.WHITE, Color.YELLOW, Color.GREEN, Color.PINK};
	public int m;
	public int n;
	public int k;
	public boolean initialized;
	public int steps;
	public int changeFromx = -1;
	public int changeTox = -1;
	public int changeFromy = -1;
	public int changeToy = -1;
	
	public void initialize(int setm, int setn, int setk) {
		data.clear();
		m = setm;
		n = setn;
		k = setk;
		//create m color arrays
		for (int iii = 0; iii<m; iii++) {
			ArrayList<Color> tempArray = new ArrayList<Color>();
			//for each color array add n colors
			for (int jjj=0; jjj<n; jjj++) tempArray.add(colors[r.nextInt(k)]);
			data.add(tempArray);
		}
		initialized = true;
		steps = 0;
	}
	
	public void step() {
		//choose square
		changeFromx = r.nextInt(m);
		changeFromy = r.nextInt(n);
		
		//determine random adjacent
		changeTox = (changeFromx+(r.nextInt(3)-1)) % m;
		changeToy = (changeFromy+(r.nextInt(3)-1)) % n;
		while((changeTox==changeFromx) && (changeToy==changeFromy)) {
			changeTox = (changeFromx+(r.nextInt(3)-1)) % m;
			changeToy = (changeFromy+(r.nextInt(3)-1)) % n;
		}
		if(changeTox<0) changeTox += m;
		if(changeToy<0) changeToy += n;
		
		data.get(changeTox).set(changeToy, data.get(changeFromx).get(changeFromy));
		steps++;
	}
}
