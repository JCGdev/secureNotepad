package gui;

import javax.swing.JFrame;

public class GUI {

	private static MainFrame frame;
	
	
	
	public static void startGUI() {
		
		frame = new MainFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
