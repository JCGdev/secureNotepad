package gui.settingsMenu;

import javax.swing.JFrame;


public class SettingsFrame extends JFrame{
	
	private int windowWidth = (utils.ToolkitUtil.getWindowWidth()/4 );
	private int windowHeigh = (utils.ToolkitUtil.getWindowHeigth()/4);
	
	private SettingsPanel panel = new SettingsPanel();
	
	public SettingsFrame() {
		
		this.setTitle("Settings");
		this.setBounds(982, 200, this.windowWidth, this.windowHeigh);
		
		this.add(panel);

	}

}
