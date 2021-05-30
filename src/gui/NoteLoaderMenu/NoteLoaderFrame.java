package gui.NoteLoaderMenu;

import java.io.File;
import javax.swing.JFrame;

public class NoteLoaderFrame extends JFrame {
	
	
	private int windowWidth = (utils.ToolkitUtil.getWindowWidth()/3 );
	private int windowHeigh = (utils.ToolkitUtil.getWindowHeigth()/2);
	
	private NoteLoaderPanel panel;
	
	public NoteLoaderFrame(File file) {
			
		this.setFrameTitle("Note loader");
		this.setBounds(700, 200, this.windowWidth, this.windowHeigh);
		this.instancePanel(file);
		this.add(this.panel);

		this.pack();
		
		
	}
	
	
	private void setFrameTitle(String title) {

		this.setTitle(title + " - AES CBC");
	
		
	}

	private void instancePanel(File file) {
		
		panel = new NoteLoaderPanel(file);
			
	}

	
	
}

