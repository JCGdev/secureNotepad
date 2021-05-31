package utils;

import javax.swing.JOptionPane;

import gui.message.MessageGUI;

public class MessageUtil {
	
	public static final byte ROUNDED_TICK = 0;
	public static final byte ROUNDED_QUESTION = 1;
	
	public static final byte TRIANGLE_ALERT = 2;
	public static final byte TRIANGLE_ALERT_2 = 3;
	
	public static final byte ROUNDED_ALERT = 4;
	public static final byte ROUNDED_DENIED = 5;
	

	
	public static void showMessage(String title, String message, byte icon) {
		MessageGUI.startGUI(title, message, icon);
		
	}
	
	
	public static void showErrorMessage(String title, String message, byte icon, Exception e) {
		MessageGUI.startGUI(title, 
							message + String.format("\n \n Exception message = [ %s ]", e.getMessage()), 
							icon);
	
	}
	
	

}
