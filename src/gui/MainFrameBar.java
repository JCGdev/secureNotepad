package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import gui.NoteCreatorMenu.NoteCreatorGUI;
import gui.helpMenu.HelpGUI;
import gui.settingsMenu.SettingsGUI;


public class MainFrameBar extends JMenuBar {
	
	private JMenu optionsMenu;
	private JMenuItem createNoteMenuItem;
	private JMenuItem settingsMenuItem;
	private JMenuItem helpMenuItem;
	
	private ImageIcon noteIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/note.png");
	private ImageIcon settingsIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/cmd.png");
	private ImageIcon helpIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/help.png");
	
	public MainFrameBar() {
		
		this.setBackground(new Color(112, 120, 130));
		
		this.optionsMenu = new JMenu("Options");
		this.createNoteMenuItem = new JMenuItem("New note", noteIcon);
		this.settingsMenuItem = new JMenuItem("Settings", settingsIcon);
		this.helpMenuItem = new JMenuItem("Help", helpIcon);
		
		this.optionsMenu.setForeground(Color.WHITE);
		
		this.createNoteMenuItem.setBackground(new Color(97, 102, 109));
		this.settingsMenuItem.setBackground(new Color(97, 102, 109));
		this.helpMenuItem.setBackground(new Color(97, 102, 109));
		
		this.createNoteMenuItem.setForeground(Color.WHITE);
		this.settingsMenuItem.setForeground(Color.WHITE);
		this.helpMenuItem.setForeground(Color.WHITE);
		
		this.createNoteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		this.settingsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		this.helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
		
		this.createNoteMenuItem.addActionListener(new NewNoteCall());
		this.settingsMenuItem.addActionListener(new SettingsMenuCall());
		this.helpMenuItem.addActionListener(new HelpMenuCall());
		
		
		this.optionsMenu.add(this.createNoteMenuItem);
		this.optionsMenu.add(this.settingsMenuItem);
		this.optionsMenu.add(this.helpMenuItem);
		
		this.add(this.optionsMenu);
		

		
	}
	
	
	
	// -------------------- Listener private class ---------------------------------------
	
		public class NewNoteCall implements ActionListener {
				
				
			public NewNoteCall() {}

			@Override
			public void actionPerformed(ActionEvent e) {
					
				NoteCreatorGUI.startGUI();
					
			}
				

		}
			
	// ------------------------------------------------------------------------------------
	
	
	
	// -------------------- Listener private class ---------------------------------------
	
	public class SettingsMenuCall implements ActionListener {
		
		
		public SettingsMenuCall() {}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			SettingsGUI.startGUI();
			
		}
		

	}
	
	// ------------------------------------------------------------------------------------
	
	
	// -------------------- Listener private class ---------------------------------------
	
		public class HelpMenuCall implements ActionListener {
			
			
			public HelpMenuCall() {}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				HelpGUI.startGUI();
				
			}
			

		}
		
		// ------------------------------------------------------------------------------------


}
