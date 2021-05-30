package gui.NoteCreatorMenu;

import javax.swing.JFrame;

public class NoteCreatorFrame extends JFrame{
	
	private int windowWidth = (utils.ToolkitUtil.getWindowWidth()/3 );
	private int windowHeigh = (utils.ToolkitUtil.getWindowHeigth()/2);
	
	private NoteCreatorPanel panel = new NoteCreatorPanel();
	
	
	public NoteCreatorFrame() {
		
	
		this.setFrameTitle("Note creator");
		this.setBounds(700, 200, this.windowWidth, this.windowHeigh);
		this.add(panel);
		
		this.pack();
		
	}

	
	private void setFrameTitle(String title) {

		this.setTitle(title + " - AES CBC");
			
	}

	private void instancePanel() {
	
		panel = new NoteCreatorPanel();
		
	}	
	
	
	
}
