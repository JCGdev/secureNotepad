package gui.NoteCreatorMenu;

import javax.swing.JFrame;

public class NoteCreatorGUI {
	
	private static NoteCreatorFrame frame;
	
	public NoteCreatorGUI() {}
	
	public static void startGUI() {
			
			frame = new NoteCreatorFrame();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		}
}
