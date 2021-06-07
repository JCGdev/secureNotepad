package utils;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import gui.message.MessageFrame;
import gui.message.MessageGUI;

public class MessageUtil {
	
	public static final byte ROUNDED_TICK = 0;
	public static final byte ROUNDED_QUESTION = 1;
	
	public static final byte TRIANGLE_ALERT = 2;
	public static final byte TRIANGLE_ALERT_2 = 3;
	
	public static final byte ROUNDED_ALERT = 4;
	public static final byte ROUNDED_DENIED = 5;
	
	
	public static final int ANSWER_YES = 0;
	public static final int ANSWER_NO = 1;
	
	
	public static void showMessage(String title, String message, byte icon) {
		MessageGUI.startGUI(title, message, icon);
		
	}
	
	public static int showConfirmMessage(String title, String message) {
		
		// JOptionPane(Object message, int messageType, int optionType, Icon icon, Object[] options)
		 UIManager UI=new UIManager();
		 JPanel messagePanel = new JPanel();
		 JButton acceptButton = new JButton("Delete");
		 ImageIcon icon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/question.png");
		 
		 messagePanel.setOpaque(true);
		 messagePanel.setBackground(new Color(97, 102, 109));
		 messagePanel.setForeground(Color.WHITE);
		 messagePanel.add(new JLabel(message));
		 
		 acceptButton.setBackground(new Color(97, 102, 109));
		 acceptButton.setForeground(Color.WHITE);
		 
		 UI.put("OptionPane.background", new Color(45, 45, 45));
		 
		 JOptionPane dialog = new JOptionPane(messagePanel,
				 							  JOptionPane.PLAIN_MESSAGE,
				 							  JOptionPane.OK_OPTION, 
				 							  icon, 
				 							  new Object[] {acceptButton});
		
		 
		 dialog.createDialog("Are you sure?").setVisible(true);;
		 
		 return 1;
		 
		 //return JOptionPane.showConfirmDialog(null, messagePanel, title, JOptionPane.YES_NO_OPTION);
		
		
	}
	
	
	public static void showErrorMessage(String title, String message, byte icon, Exception e) {
		MessageGUI.startGUI(title, 
							message + String.format("\n \n Exception message = [ %s ]", e.getMessage()), 
							icon);
	
	}
	
	

}
