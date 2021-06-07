package gui.message;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessagePanel extends JPanel{

	String title;
	String message;
	byte mode;
	
	protected static final byte ROUNDED_TICK = 0;
	protected static final byte ROUNDED_QUESTION = 1;
	
	protected static final byte TRIANGLE_ALERT = 2;
	protected static final byte TRIANGLE_ALERT_2 = 3;
	
	protected static final byte ROUNDED_ALERT = 4;
	protected static final byte ROUNDED_DENIED = 5;
	
	protected ImageIcon icon;
	
	protected JLabel messageLabel;
	
	public MessagePanel(String paramTitle, String paramMessage, byte paramIcon) {
		
		this.title = paramTitle;
		this.message = paramMessage;
		this.mode = paramIcon;
		
		
		this.setLayout(new BorderLayout());
		
		// --------------- Dark MODE ----------------------------------------
		this.setBackground(new Color(41, 41, 41));
		this.messageLabel = new JLabel(message);
		this.messageLabel.setForeground(Color.WHITE);
		
		// -----------------------------------------------------------------
		
		this.messageLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.setChoosedIcon();
		
		this.add(utils.InstancesUtil.getJPanelInstance(this.icon), BorderLayout.NORTH);
		this.add(utils.InstancesUtil.getJPanelInstance(this.messageLabel), BorderLayout.CENTER);

		
	}
	
	
	protected void setChoosedIcon() {
		
		switch(this.mode) {
		
			case ROUNDED_TICK:
				this.icon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/round_tick.png");
				break;
				
			case ROUNDED_QUESTION:
				this.icon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/question.png");
				break;
				
			case TRIANGLE_ALERT:
				this.icon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/triangle_alert.png");
				break;
				
			case TRIANGLE_ALERT_2:
				this.icon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/triangle_alert_2.png");
				break;
				
			case ROUNDED_ALERT:
				this.icon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/rounded_alert.png");
				break;
				
			case ROUNDED_DENIED:
				this.icon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/rounded_denied.png");
				break;
				
		
		}
		
		
	}
	
	
}
