package utils;

import javax.swing.JOptionPane;

public class ErrorUtil {
	
	
	public static void showErrorMessage(String message, Exception e) {
		
		JOptionPane.showMessageDialog(null, message 
									  + String.format("\n \n Exception message = [ %s ]", e.getMessage()));
		
		e.printStackTrace();
		
	}
	
	public static void showErrorMessage(String message) {
		
		JOptionPane.showMessageDialog(null, message);
		
		
	}


}
