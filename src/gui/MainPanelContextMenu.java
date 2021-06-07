package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.NoteCreatorMenu.NoteCreatorGUI;
import gui.settingsMenu.SettingsGUI;
import utils.Preferences;


public class MainPanelContextMenu extends JPopupMenu {

	JMenuItem createNoteItem = new JMenuItem("New note");
	JMenuItem refreshMenuItem = new JMenuItem("Refresh");
	JMenuItem settingsMenuItem = new JMenuItem("Settings");
	
	private ImageIcon noteIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/note.png");
	private ImageIcon refreshIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/refresh.png");
	private ImageIcon settingsIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/cmd.png");


	public MainPanelContextMenu() {
		
		// --------------- Dark MODE ----------------------------------------
		
		this.createNoteItem.setBackground(new Color(97, 102, 109));
		this.refreshMenuItem.setBackground(new Color(97, 102, 109));
		this.settingsMenuItem.setBackground(new Color(97, 102, 109));
		
		this.createNoteItem.setForeground(Color.WHITE);
		this.refreshMenuItem.setForeground(Color.WHITE);
		this.settingsMenuItem.setForeground(Color.WHITE);
		
		// ------------------------------------------------------------------
		
		this.createNoteItem.addActionListener(new NoteCreatorMenuCall());
		this.refreshMenuItem.addActionListener(new RefreshCall());
		this.settingsMenuItem.addActionListener(new SettingsMenuCall());
		
		this.createNoteItem.setIcon(this.noteIcon);
		this.refreshMenuItem.setIcon(this.refreshIcon);
		this.settingsMenuItem.setIcon(this.settingsIcon);
		
		
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
