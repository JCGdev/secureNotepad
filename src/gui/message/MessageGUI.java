package gui.message;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class MessageGUI {

	// icons 
	
	public static final byte ROUNDED_TICK = 0;
	public static final byte ROUNDED_QUESTION = 1;
	
	public static final byte TRIANGLE_ALERT = 2;
	public static final byte TRIANGLE_ALERT_2 = 3;
	
	public static final byte ROUNDED_ALERT = 4;
	public static final byte ROUNDED_DENIED = 5;
	
	
	public MessageGUI() {}
	
	
	public static void startGUI(String title, String message, byte selectedIcon) {
		
			MessageFrame frame = new MessageFrame(title, message, selectedIcon);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			
	}
	

	
}
