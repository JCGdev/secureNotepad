package gui.helpMenu;

import javax.swing.JFrame;

public class HelpGUI {
	
	private static HelpFrame frame;
	
	public static void startGUI() {
		
		frame = new HelpFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
