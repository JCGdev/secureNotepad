package gui.NoteCreatorMenu;

import java.awt.BorderLayout;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gui.StaticMainPanel;


public class NoteCreatorPanel extends JPanel{

	private JLabel titleLabel = new JLabel("Note Creator");
	private Box mainBox = Box.createVerticalBox();
	
	private Box nameBox = Box.createHorizontalBox();
	private JLabel noteNameLabel = new JLabel("Name");
	private JTextField noteNameTextField = new JTextField("exampleNote.txt" , 5);
	
	private Box noteDataBox = Box.createHorizontalBox();
	private JTextArea noteDataTextArea = new JTextArea(20, 50);
	private JScrollPane noteDataTextPane = new JScrollPane(noteDataTextArea);
	
	private Box passwordBox = Box.createHorizontalBox();
	private JLabel passwordLabel = new JLabel("Password");
	private JPasswordField passwordField = new JPasswordField(5);
	
	private Box repeatPasswordBox = Box.createHorizontalBox();
	private JLabel passwordRepeatLabel = new JLabel("Repeat password");
	private JPasswordField passwordRepeatField = new JPasswordField(5);
	
	
	private JCheckBox lineWrapCheckBox = new JCheckBox("Line wrap");
	private JButton saveNoteButton = new JButton("Save Note");
	
	
	public NoteCreatorPanel() {
		
		this.setLayout(new BorderLayout());
		
		this.titleLabel.setFont(new Font("Serif", Font.BOLD, 26));
		this.lineWrapCheckBox.setSelected(true);
		this.noteDataTextArea.setLineWrap(true);
		

		// nameBbox (contains the name input box)
		this.nameBox.add(this.noteNameLabel);
		this.nameBox.add(Box.createHorizontalStrut(10));
		this.nameBox.add(this.noteNameTextField);
		
		// noteDataBox (contains the field where the note is written )
		this.noteDataBox.add(this.noteDataTextPane);
		
		// passswordBox (contais the field where the password is written)
		this.passwordBox.add(this.passwordLabel);
		this.passwordBox.add(Box.createHorizontalStrut(10));
		this.passwordBox.add(this.passwordField);
		
		//Repeat password box 
		
		this.repeatPasswordBox.add(this.passwordRepeatLabel);
		this.repeatPasswordBox.add(Box.createHorizontalStrut(10));
		this.repeatPasswordBox.add(this.passwordRepeatField);
		
		// mainBox (contais all the boxes)
		this.mainBox.add(this.nameBox);
		this.mainBox.add(this.getWhiteBox());
		this.mainBox.add(this.noteDataBox);
		this.mainBox.add(this.getWhiteBox());
		this.mainBox.add(this.passwordBox);
		this.mainBox.add(this.getWhiteBox());
		this.mainBox.add(this.repeatPasswordBox);

	
		
		this.add(utils.InstancesUtil.getJPanelInstance(this.titleLabel), BorderLayout.NORTH);
		this.add(utils.InstancesUtil.getJPanelInstance(this.mainBox), BorderLayout.CENTER);
		this.add(utils.InstancesUtil.getJPanelInstance(this.saveNoteButton), BorderLayout.SOUTH);
		this.add(utils.InstancesUtil.getJPanelInstance(this.lineWrapCheckBox), BorderLayout.WEST);

		
		this.lineWrapCheckBox.addActionListener(new checkboxCall());
		this.saveNoteButton.addActionListener(new saveButtonPressedCall());
		
	}
	
	private Box getWhiteBox() {
		
		Box whiteBox = Box.createHorizontalBox();
		whiteBox.add(new JLabel(" "));
		return whiteBox;
	}
	
	private Box getMainBox() {
		return mainBox;
	}
	
	private JButton getSaveButton() {
		return this.saveNoteButton;
	}
	
	private String getNoteName() {
		return this.noteNameTextField.getText();
	}
	
	private String getNoteText() {
		return this.noteDataTextArea.getText();
	}
	
	private String getPassword() {
		return new String(this.passwordField.getPassword());
	}
	
	
	private boolean passwordIsBlank() {
		if(getPassword().isBlank() || getPassword().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean noteTextIsBlank() {
		if(getNoteText().isBlank() || getNoteText().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean passwordIsNotBlank() {
		return !passwordIsBlank();
	}
	
	private boolean noteTextIsNotBlank() {
		return !noteTextIsBlank();
	}	
	
	private boolean passwordIsWellWritten() {
		String passwordField1 = new String(this.passwordField.getPassword());
		String passwordField2 = new String(this.passwordRepeatField.getPassword());
		
		boolean status = passwordField1.equals(passwordField2);
		
		passwordField1 = null;
		passwordField2 = null;
		
		return status;
	}
	
	
	// -------------------- Listener private class ---------------------------------------	
	
	private class checkboxCall implements ActionListener {

		public checkboxCall() {}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (lineWrapCheckBox.isSelected()) {
				noteDataTextArea.setLineWrap(true);
			} else {
				noteDataTextArea.setLineWrap(false);
			}
			
		}
			
	}
	
	// ------------------------------------------------------------------------------------
	
	// -------------------- Listener private class ---------------------------------------	
	
		private class saveButtonPressedCall implements ActionListener {

			public saveButtonPressedCall() {}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(passwordIsNotBlank() && noteTextIsNotBlank()) {
					
					if(passwordIsWellWritten()) {
					
						String filePath = null;
				
						if(utils.OSUtil.isUnix()) {
							filePath = utils.Preferences.NOTES_DIR_PATH + "/" + getNoteName(); 

						} else if(utils.OSUtil.isWindows()) {
							filePath = utils.Preferences.NOTES_DIR_PATH + "\\" + getNoteName(); 
					
						}
				
				
						String encodedCipherText = utils.CryptUtil.encryptWithCBCMode(getNoteText().getBytes(),
																			  		  getPassword().toCharArray());
						
						utils.FileIOUtil.createFile(filePath);
						utils.FileIOUtil.writeTextToFile(encodedCipherText, filePath);
				
						JOptionPane.showMessageDialog(null, "Note created!");
						StaticMainPanel.getInstance().refreshNotes();
					
					} else {
						utils.ErrorUtil.showErrorMessage("Password doesn't match");
					}
				
				} else {
					utils.ErrorUtil.showErrorMessage("Provided data can't be blank");
				}
				
				
				
			}


		}
		
		// ------------------------------------------------------------------------------------
	
}
