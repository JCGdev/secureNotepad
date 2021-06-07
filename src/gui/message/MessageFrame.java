package gui.message;

import java.awt.Image;
import javax.swing.JFrame;

public class MessageFrame extends JFrame {

	private int windowWidth = (utils.ToolkitUtil.getWindowWidth()/6 );
	private int windowHeigh = (utils.ToolkitUtil.getWindowHeigth()/6);
	
	private int xPos = (utils.ToolkitUtil.getWindowWidth()/2 );
	private int yPos = (utils.ToolkitUtil.getWindowHeigth()/2);
	
	
	private MessagePanel panel;
	private Image icon = utils.ImageIOUtil.getInstance().getIconImage("/resources/images/message.png");
	
	
	public MessageFrame(String title, String message, byte selectedIcon) {
		
		this.setTitle(title);
		this.setIconImage(icon);
		this.setBounds(xPos, yPos, this.windowWidth, this.windowHeigh);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new MessagePanel(title, message, selectedIcon);

		
		this.add(panel);	

		
	}
	

	
}
