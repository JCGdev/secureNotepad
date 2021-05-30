package gui.settingsMenu;

import javax.swing.JFrame;

public class SettingsGUI {
	
	private static SettingsFrame frame;

	public static void startGUI() {
		
		frame = new SettingsFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

}
