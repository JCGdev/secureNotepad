package gui.NoteLoaderMenu;

import java.io.File;

import javax.swing.JFrame;

public class NoteLoaderGUI {

	private static NoteLoaderFrame frame;
	
	public NoteLoaderGUI() {}
	
	public static void startGUI(File file) {
			
			frame = new NoteLoaderFrame(file);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		}
	
}
