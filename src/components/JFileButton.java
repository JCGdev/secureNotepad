package components;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import gui.NoteLoaderMenu.NoteLoaderGUI;
import utils.Preferences;

public class JFileButton extends JButton{
	
	private File associatedFile;
	private ImageIcon buttonIcon = utils.ImageIOUtil.getInstance().getIcon("/resources/encrypted_note.png");
	
	public JFileButton(String name, File file) {
		super(name);
		this.associatedFile = file;
		
		this.setIcon(this.buttonIcon);
		this.setToolTipText("Right click to manipulate the file");
		
		this.addActionListener(new NoteLoaderMenuCall());
		this.setComponentPopupMenu(new JFileButtonContextMenu(associatedFile));

	}
	
	public void setAssociatedFile(File file) {
		this.associatedFile = file;

	}
	
	public File getAssociatedFile(File file) {
		return this.associatedFile;
	}
	
	
	
	
	
	
	
	
	// -------------------- Listener private class ---------------------------------------	
	
			private class NoteLoaderMenuCall implements ActionListener{
			
				
				public NoteLoaderMenuCall() {}
			
				
				public void actionPerformed(ActionEvent e) {
					
					// TODO -- File's value gets null in this method
					

					NoteLoaderGUI.startGUI(associatedFile);
					
				}
				
			}

		
		// ------------------------------------------------------------------------------------
		
}
