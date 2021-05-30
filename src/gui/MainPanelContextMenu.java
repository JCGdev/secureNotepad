package gui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.NoteCreatorMenu.NoteCreatorGUI;
import gui.settingsMenu.SettingsGUI;
import utils.Preferences;


public class MainPanelContextMenu extends JPopupMenu {

	JMenuItem createNoteItem = new JMenuItem("New note");
	JMenuItem refreshMenuItem = new JMenuItem("Refresh");
	JMenuItem settingsMenuItem = new JMenuItem("Settings");


	public MainPanelContextMenu() {
		
		this.createNoteItem.addActionListener(new NoteCreatorMenuCall());
		this.refreshMenuItem.addActionListener(new RefreshCall());
		this.settingsMenuItem.addActionListener(new SettingsMenuCall());
		
		
		this.add(this.createNoteItem);
		this.add(this.refreshMenuItem);
		this.add(this.settingsMenuItem);
		
		
	}
	
	
	
	
	
	// -------------------- Listener private class ---------------------------------------
	
		private class SettingsMenuCall implements ActionListener {
			
			
			public SettingsMenuCall() {}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				SettingsGUI.startGUI();
				
			}
			

		}
		
	// ------------------------------------------------------------------------------------
	
		
		private class NoteCreatorMenuCall implements ActionListener{
			
			public NoteCreatorMenuCall() {}
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				NoteCreatorGUI.startGUI();
		
			}
		}
	
	
	// -------------------- Listener private class ---------------------------------------
		
		private class RefreshCall implements ActionListener {
				
				
			public RefreshCall() {}

			@Override
			public void actionPerformed(ActionEvent e) {
					
				StaticMainPanel.getInstance().refreshNotes();
					
			}
				

		}
		
}
