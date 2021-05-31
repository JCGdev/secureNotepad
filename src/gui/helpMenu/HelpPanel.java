package gui.helpMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpPanel extends JPanel {

	
	
	private JLabel titleLabel = new JLabel("Help window");
	
	private JTextArea helpMessage =  new JTextArea(	"[Developed by] --> 	JCGdev \n"
											  + "[Github] -->		github.com/JCGdev \n"
											  + "                                        \n"
											  + "The encryption algorithm is AES CBC, \n"
											  + "using PBKDF2 derivation function", 10, 40);
			
	
	public HelpPanel() {
		
		this.setLayout(new BorderLayout());
		
		// --------------- Dark MODE ----------------------------------------
		
		this.setBackground(new Color(41, 41, 41));
		
		this.titleLabel.setForeground(Color.WHITE);
	
		this.helpMessage.setBackground(new Color(97, 102, 109));
		this.helpMessage.setForeground(Color.WHITE);
	
		// -----------------------------------------------------------------
		
		this.titleLabel.setFont(new Font("Serif", Font.BOLD, 26));
		this.helpMessage.setEditable(false);
		
		
		
		this.add(utils.InstancesUtil.getJPanelInstance(this.titleLabel), BorderLayout.NORTH);
		this.add(utils.InstancesUtil.getJPanelInstance(this.helpMessage), BorderLayout.CENTER);	
		
	}
	
}
