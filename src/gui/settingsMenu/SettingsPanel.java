package gui.settingsMenu;

import java.awt.BorderLayout;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import secureNotepad.ConfigFileManager;

public class SettingsPanel extends JPanel {
	
	private JLabel titleLabel = new JLabel("Settings Menu");
	
	private Box mainBox = Box.createVerticalBox();
	private Box pathChangeBox = Box.createHorizontalBox();
	
	private JFileChooser folderChooser = new JFileChooser();
	private JLabel notesPathLabel = new JLabel("Notes Path");
	private JButton notesPathChooserButton = new JButton("Choose folder");
	private String notesPath;
	
	
	private JButton saveButton = new JButton("Save settings");
	private HashMap<String, String> settingsMap;
	
	public SettingsPanel() {
		
		setLayout(new BorderLayout());
		
		this.titleLabel.setFont(new Font("Serif", Font.BOLD, 26));
		this.notesPathLabel.setFont(new Font("Serif", Font.BOLD, 15));


		this.folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		this.saveButton.addActionListener(new SettingsSaveButtonCall());
		this.notesPathChooserButton.addActionListener(new folderChooserButtonPressedCall());

			
		// Path change box
		this.pathChangeBox.add(this.notesPathLabel);
		this.pathChangeBox.add(Box.createHorizontalStrut(10));
		this.pathChangeBox.add(this.notesPathChooserButton);
		
		
		// Main Box (stores all the boxes)
		this.mainBox.add(this.pathChangeBox);
		this.mainBox.add(this.getWhiteBox());
		
		
		// Main Frame
		this.add(utils.InstancesUtil.getJPanelInstance(this.titleLabel), BorderLayout.NORTH);
		this.add(utils.InstancesUtil.getJPanelInstance(this.mainBox), BorderLayout.CENTER);
		this.add(utils.InstancesUtil.getJPanelInstance(this.saveButton), BorderLayout.SOUTH);
		
		
		
	}
	
	
	
	private HashMap<String, String> getSettingsAsHashmap() {
		
		this.settingsMap = new HashMap<String, String>();
		
		this.settingsMap.put("NOTES_PATH", this.notesPath);
		
		return settingsMap;
	}
	
	private Box getWhiteBox() {
		
		Box whiteBox = Box.createHorizontalBox();
		whiteBox.add(new JLabel(" "));
		return whiteBox;
	}
	
	
	
	// ---------------------------- Listener private class -------------------------------------
	
	private class SettingsSaveButtonCall implements ActionListener {

		private HashMap<String, String> settingsMap;
		
		
		public SettingsSaveButtonCall() {}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			this.settingsMap = getSettingsAsHashmap();
			
			utils.Preferences.NOTES_DIR_PATH = settingsMap.get("NOTES_PATH").toString();

			
			String[] linesToWriteInConfigFile = {
					"# PLEASE, DO NOT EDIT THIS FILE",
					"NOTES_PATH=" + utils.HashMapUtil.getValue(this.settingsMap,"NOTES_PATH"), 
			};
			
			
			ConfigFileManager.createConfigFile();	
			ConfigFileManager.writeTextToConfigFile(linesToWriteInConfigFile);
			
			JOptionPane.showMessageDialog(null, "Settings saved!, restart to apply changes");
			
			
		}
			
		
	}
	
	// --------------------------------------------------------------------------------------------
	
	
	// ---------------------------- Listener private class -------------------------------------
	
	private class folderChooserButtonPressedCall implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			int answer = folderChooser.showOpenDialog(null);
			
			if(answer == JFileChooser.APPROVE_OPTION) {
				notesPath = folderChooser.getSelectedFile().getAbsolutePath();

			}
		}
		
	}
	
		
	// --------------------------------------------------------------------------------------------
	
}
