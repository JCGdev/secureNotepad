package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.JFileButton;
import secureNotepad.NotesManager;

public class MainPanel extends JPanel{

	private JLabel titleLabel = new JLabel("SecureNotepad");
	private JLabel titleIconLabel = new JLabel();
	
	private static JPanel buttonsPanel = new JPanel();
	
	private static File[] fileNotes = NotesManager.getNotesInPath();
	private static JFileButton[] buttons = null;
	
	private JButton refreshButton = new JButton("Refresh");
	
	private ImageIcon titleIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/title.png");
	private ImageIcon refreshIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/refresh.png");
	
	public MainPanel() {
		
		
		this.setLayout(new BorderLayout());
		this.titleLabel.setFont(new Font("Serif", Font.BOLD, 26));
		this.titleIconLabel.setIcon(titleIcon);
		this.refreshButton.setIcon(this.refreshIcon);
		
		this.setComponentPopupMenu(new MainPanelContextMenu());
		
		this.refreshButton.setToolTipText("Repaint the files on the panel");
		this.refreshButton.addActionListener(new RefreshFilesButtonCall());
		
		associateFilesToButtons();
		addButtonsToPanel();
		
		
		this.add(utils.InstancesUtil.getJPanelInstance(this.titleLabel, this.titleIconLabel), BorderLayout.NORTH);
		this.add(buttonsPanel, BorderLayout.CENTER);
		this.add(utils.InstancesUtil.getJPanelInstance(this.refreshButton), BorderLayout.SOUTH);
		

	}
	
	
	
	private void associateFilesToButtons() {
		
		if(thereAreAnyNotes()) {
			
			buttons = new JFileButton[fileNotes.length];
			byte i = 0;
			
			for(File file : fileNotes) {
				buttons[i] = new JFileButton(file.getName(), file);
				i++;
			}
			
			
		}
	}
	
	private void refresNotesInPath() {
		fileNotes = NotesManager.getNotesInPath();
	}
	
	private void addButtonsToPanel() {
		
		if(thereAreAnyNotes()) {
			for(JFileButton button : buttons) {
				buttonsPanel.add(button);
			}
		}else {
			JLabel noNotesLabel = new JLabel("[ 0 notes detected ], right click or press Crtl + N to create one");
			noNotesLabel.setFont(new Font("Serif", Font.BOLD, 15));
			noNotesLabel.setForeground(Color.BLUE);
			buttonsPanel.add(noNotesLabel);
		}
	}
		
	
	private void repaintButtonsPanel() {
		buttonsPanel.revalidate();
		buttonsPanel.repaint();
		
	}
	
	
	private void removeComponentsFromButtonsPanel() {
		
		for(Component component : buttonsPanel.getComponents()) {	
			buttonsPanel.remove(component);
		}
		
	}
	
	private boolean thereAreAnyNotes() {
		return NotesManager.getNotesInPath().length != 0;
	}
	
	
	public void refreshNotes() {		
		refresNotesInPath();
		associateFilesToButtons();
		removeComponentsFromButtonsPanel();
		addButtonsToPanel();
		
		repaintButtonsPanel();

	}		
		
	
	// -------------------------- Listener private class ---------------------------------------
	
	private class RefreshFilesButtonCall implements ActionListener {
		
		public RefreshFilesButtonCall() {
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			refresNotesInPath();
			associateFilesToButtons();
			removeComponentsFromButtonsPanel();
			addButtonsToPanel();
			
			repaintButtonsPanel();

			
		}

	}
	
	
	// -------------------------------------------------------------------------------------------
	
	
}
