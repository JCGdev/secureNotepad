package gui.helpMenu;

import javax.swing.JFrame;

public class HelpFrame extends JFrame{

	private int windowWidth = (utils.ToolkitUtil.getWindowWidth()/4 );
	private int windowHeigh = (utils.ToolkitUtil.getWindowHeigth()/4);
	
	private HelpPanel panel = new HelpPanel();
			
	public HelpFrame() {
		
		this.setTitle("Help");
		this.setBounds(200, 200, this.windowWidth, this.windowHeigh);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.add(panel);
		
		this.pack();
		
	}
	
}
