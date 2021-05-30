package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPopupMenu;

import gui.StaticMainPanel;
import utils.Preferences;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JFileButtonContextMenu extends JPopupMenu {

	File associatedFile;
	JMenu OptionsMenu = new JMenu("Options");
	JMenuItem deleteNoteItem = new JMenuItem("delete");
	JMenuItem renameFileItem = new JMenuItem("rename");
	
	private ImageIcon optionsIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/settings2.png");
	private ImageIcon deleteIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/bin.png");
	private ImageIcon renameIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/rename.png");
	
	public JFileButtonContextMenu(File file){
		
		this.OptionsMenu.setIcon(this.optionsIcon);
		this.deleteNoteItem.setIcon(this.deleteIcon);
		this.renameFileItem.setIcon(this.renameIcon);
		
		this.OptionsMenu.add(this.deleteNoteItem);
		this.OptionsMenu.add(this.renameFileItem);
		
		
		this.add(this.OptionsMenu);
		this.associatedFile = file;
		
		this.deleteNoteItem.addActionListener(new DeleteNoteCall());
		this.renameFileItem.addActionListener(new noteRenameCall());
		
	}
	
	
	
	
	
	
	
	
	// -------------------- Listener private class ---------------------------------------	
	
				private class DeleteNoteCall implements ActionListener{
				
					final int YES = 0;
					final int NO = 1;
					
					
					public DeleteNoteCall() {}
				
					
					public void actionPerformed(ActionEvent e) {
						
						int answer = JOptionPane.showConfirmDialog(null, "Are you sure?, this action cannot be undone", 
													"Delete the note?", JOptionPane.YES_NO_OPTION);
						
							if (answer == YES) {
							
								utils.FileIOUtil.deleteFile(associatedFile.getAbsolutePath());
								JOptionPane.showMessageDialog(null, "Note deleted");
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
						
						if(utils.OSUtil.isUnix()) {
							utils.FileIOUtil.renameFile(associatedFile.getAbsolutePath(),
														Preferences.NOTES_DIR_PATH + "/" + nameToRename);
							
							JOptionPane.showMessageDialog(null, "Note renamed!");
							StaticMainPanel.getInstance().refreshNotes();
							
						}else if(utils.OSUtil.isWindows()) {
							utils.FileIOUtil.renameFile(associatedFile.getAbsolutePath(),
									Preferences.NOTES_DIR_PATH + "\\" + nameToRename);
						
							JOptionPane.showMessageDialog(null, "Note renamed!");
							StaticMainPanel.getInstance().refreshNotes();
						}
							
						
					}
								
				}

						
			// ------------------------------------------------------------------------------------
			
	
}
