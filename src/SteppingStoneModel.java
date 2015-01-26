import java.awt.Dimension;
import javax.swing.JFrame;


public class SteppingStoneModel {
	
	
	public static void main(String[] args) {
		SSDrawPanel drawField = new SSDrawPanel(600, 600, 10, 10, 2, 1000);
		
		JFrame Window = new JFrame("Stepping Stone Model");
		Window.setContentPane(drawField);
		Window.setSize(new Dimension(600, 652));
		Window.setLocation(100, 100);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setVisible(true);
		
	}

}
