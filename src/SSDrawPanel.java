import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class SSDrawPanel extends JPanel implements MouseListener, ActionListener {
	
	SteppingStoneField field = new SteppingStoneField();
	private Timer timer;
	public int sizeX;
	public int sizeY;
	public int m;
	public int n;
	public int k;
	private static final long serialVersionUID = 1L;
	
	public SSDrawPanel(int x, int y, int setm, int setn, int setk, int speed) {
		timer = new Timer(speed, this);
		
		sizeX = x;
		sizeY = y;
		m = setm;
		n = setn;
		k = setk;
		field.initialize(m, n, k);
		
		setPreferredSize(new Dimension(sizeX, sizeY));
		addMouseListener(this);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int unitWidth = (int)sizeX/m;
		int unitHeight = (int)sizeY/n;
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, sizeX, sizeY);
		
		for (int iii = 0; iii<m; iii++) {
			for (int jjj=0; jjj<n; jjj++) {
				//Highlight change from and to
				if((iii==field.changeFromx) && (jjj==field.changeFromy)) {
					g.setColor(Color.RED);
					g.fillRect(iii*unitWidth, jjj*unitHeight, unitWidth, unitHeight);
				}
				if((iii==field.changeTox)&&(jjj==field.changeToy)) {
					g.setColor(Color.BLUE);
					g.fillRect(iii*unitWidth, jjj*unitHeight, unitWidth, unitHeight);
				}
				
				g.setColor(field.data.get(iii).get(jjj));
				g.fillRect(iii*unitWidth + 2, jjj*unitHeight + 2, unitWidth-4, unitHeight-4);
			}
		}
		g.setColor(Color.BLACK);
		g.drawString("" + field.steps, 17, sizeX+17);
		g.drawString("(" + field.changeFromx + ", " + field.changeFromy + ") => (" + field.changeTox + ", " + field.changeToy + ")", 96, sizeX+17);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(timer.isRunning()) {
			if(timer.getDelay()>5) timer.setDelay((int)(timer.getDelay()/2));
		} else {
			timer.start();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) {
		timer.start();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		timer.stop();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		field.step();
		this.repaint();
	}

}
