package components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPopupMenu;

import gui.StaticMainPanel;
import utils.MessageUtil;
import utils.Preferences;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JFileButtonContextMenu extends JPopupMenu {

	File associatedFile;
	JMenu optionsMenu = new JMenu("Options");
	JMenuItem deleteNoteItem = new JMenuItem("delete");
	JMenuItem renameFileItem = new JMenuItem("rename");
	
	private ImageIcon optionsIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/settings2.png");
	private ImageIcon deleteIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/bin.png");
	private ImageIcon renameIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/images/rename.png");
	
	public JFileButtonContextMenu(File file){
		
		
		this.optionsMenu.setIcon(this.optionsIcon);
		this.deleteNoteItem.setIcon(this.deleteIcon);
		this.renameFileItem.setIcon(this.renameIcon);
		
		// --------------- Dark MODE ----------------------------------------
		
		this.setBackground(new Color(97, 102, 109));
		
		this.optionsMenu.setBackground(new Color(97, 102, 109));
		this.deleteNoteItem.setBackground(new Color(97, 102, 109));
		this.renameFileItem.setBackground(new Color(97, 102, 109));
		
		this.optionsMenu.setForeground(Color.WHITE);
		this.deleteNoteItem.setForeground(Color.WHITE);
		this.renameFileItem.setForeground(Color.WHITE);

		// ------------------------------------------------------------------
		
		this.optionsMenu.add(this.deleteNoteItem);
		this.optionsMenu.add(this.renameFileItem);
		
		
		this.add(this.optionsMenu);
		this.associatedFile = file;
		
		this.deleteNoteItem.addActionListener(new DeleteNoteCall());
		this.renameFileItem.addActionListener(new noteRenameCall());
		
	}
	
	
	
	
	
	
	
	
	// -------------------- Listener private class ---------------------------------------	
	
				private class DeleteNoteCall implements ActionListener{
				
					private final int YES = 0;
					private final int NO = 1;
					
					
					public DeleteNoteCall() {}
				
					
					public void actionPerformed(ActionEvent e) {
						
						//int answer = JOptionPane.showConfirmDialog(null, "Are you sure?, this action cannot be undone", 
						//							"Delete the note?", JOptionPane.YES_NO_OPTION);
						
						int answer = utils.MessageUtil.showConfirmMessage("Are you sure", "This action cannot be undone");
						
							if (answer == YES) {
							
								utils.FileIOUtil.deleteFile(associatedFile.getAbsolutePath());
								utils.MessageUtil.showMessage("SUCCEEDED", "Note deleted", MessageUtil.ROUNDED_TICK);
								StaticMainPanel.getInstance().refreshNotes();
							
							} 
						
					}
					
				}

			
			// ------------------------------------------------------------------------------------
				

			// -------------------- Listener private class ---------------------------------------	
				
				private class noteRenameCall implements ActionListener{
								
								
					public noteRenameCall() {}
							
								
					public void actionPerformed(ActionEvent e) {
									
						String nameToRename = JOptionPane.showInputDialog("Enter the desired name");
						
						if (nameToRename != null) {
							if(utils.OSUtil.isUnix()) {
								utils.FileIOUtil.renameFile(associatedFile.getAbsolutePath(),
														Preferences.NOTES_DIR_PATH + "/" + nameToRename);
							
								utils.MessageUtil.showMessage("SUCCEEDED", "Note renamed", MessageUtil.ROUNDED_TICK);
								StaticMainPanel.getInstance().refreshNotes();
							
							}else if(utils.OSUtil.isWindows()) {
								utils.FileIOUtil.renameFile(associatedFile.getAbsolutePath(),
										Preferences.NOTES_DIR_PATH + "\\" + nameToRename);
						
								utils.MessageUtil.showMessage("SUCCEEDED", "Note renamed!", MessageUtil.ROUNDED_TICK);
								StaticMainPanel.getInstance().refreshNotes();
							}
						}

					
						
					}
					
					
								
				}

						
			// ------------------------------------------------------------------------------------
			
	
}
