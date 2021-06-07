package gui;

import java.awt.Image;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	
	private int windowHeigth = (utils.ToolkitUtil.getWindowHeigth())/2;
	private int windowWidth = (utils.ToolkitUtil.getWindowWidth())/2;

	private Image frameIcon = utils.ImageIOUtil.getInstance().getIconImage("/resources/images/icon.png");
	
	public MainFrame() {
		
		this.setTitle("SecureNotepad V1 - JCGdev - (AES CBC | PKCS5Padding | PBKDF2WithHmacSHA256)");
		this.setBounds(500, 200, this.windowWidth, this.windowHeigth);
		this.setIconImage(frameIcon);
		this.setJMenuBar(new MainFrameBar());
		
		
		this.add(StaticMainPanel.getInstance());
	}
	
}
