package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	
	private int windowHeigth = (utils.ToolkitUtil.getWindowHeigth())/2;
	private int windowWidth = (utils.ToolkitUtil.getWindowWidth())/2;
	//Image icon = new ImageIcon(this.getClass().getResource("/resources/icon.gif")).getImage();


	public MainFrame() {
		
		this.setTitle("SecureNotepad V1 - JCGdev - (AES CBC | PKCS5Padding | PBKDF2WithHmacSHA256)");
		this.setBounds(500, 200, this.windowWidth, this.windowHeigth);
		//this.setIconImage(this.icon);
		this.setJMenuBar(new MainFrameBar());
		
		this.add(StaticMainPanel.getInstance());
	}
	
}
