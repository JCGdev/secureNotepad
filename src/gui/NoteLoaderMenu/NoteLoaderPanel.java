package gui.NoteLoaderMenu;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.message.MessageGUI;

public class NoteLoaderPanel extends JPanel{

		private File associatedFile;
		
		private JLabel titleLabel = new JLabel("Note Loader");
		private Box mainBox = Box.createVerticalBox();
		
		private Box nameBox = Box.createHorizontalBox();
		private JLabel noteNameLabel = new JLabel("Name");
		private JTextField noteNameTextField = new JTextField("example" , 5);
		
		private Box passwordBox = Box.createHorizontalBox();
		private JLabel passwordLabel = new JLabel("Password");
		private JPasswordField passwordField = new JPasswordField(5);
		
		private Box passwordRepeatBox = Box.createHorizontalBox();
		private JLabel passwordRepeatLabel = new JLabel("Repeat password");
		private JPasswordField passwordRepeatField = new JPasswordField(5);
		
		private Box noteDataBox = Box.createHorizontalBox();
		private JTextArea noteDataTextArea = new JTextArea(20, 50);
		private JScrollPane noteDataTextPane = new JScrollPane(noteDataTextArea);
		
		private JCheckBox lineWrapCheckBox = new JCheckBox("Line wrap");
		
		private JButton decryptButton = new JButton("Decrypt");
		private JButton saveChangesButton = new JButton("Save changes");
		

		
		public NoteLoaderPanel(File file) {
			
			this.setAssociatedFile(file);
			this.setLayout(new BorderLayout());
			
			// --------------- Dark MODE ----------------------------------------
			
			this.setBackground(new Color(41, 41, 41));
			
			this.titleLabel.setForeground(Color.WHITE);
			this.noteNameLabel.setForeground(Color.WHITE);
			this.passwordLabel.setForeground(Color.WHITE);
			this.passwordRepeatLabel.setForeground(Color.WHITE);
			
			this.noteNameTextField.setBackground(new Color(97, 102, 109));
			this.passwordField.setBackground(new Color(97, 102, 109));
			this.passwordRepeatField.setBackground(new Color(97, 102, 109));
			this.noteDataTextArea.setBackground(new Color(97, 102, 109));
			
			this.noteNameTextField.setForeground(Color.WHITE);
			this.passwordField.setForeground(Color.WHITE);
			this.passwordRepeatField.setForeground(Color.WHITE);
			this.noteDataTextArea.setForeground(Color.WHITE);
			
			this.decryptButton.setBackground(new Color(97, 102, 109));
			this.decryptButton.setForeground(Color.WHITE);
			
			this.saveChangesButton.setBackground(new Color(97, 102, 109));
			this.saveChangesButton.setForeground(Color.WHITE);
			
			this.lineWrapCheckBox.setOpaque(false);
			this.lineWrapCheckBox.setForeground(Color.WHITE);
			
			// --------------------------------------------------
			
			this.titleLabel.setFont(new Font("Serif", Font.BOLD, 26));
			this.saveChangesButton.setEnabled(false);
			this.noteNameTextField.setText(this.associatedFile.getName());
			
			this.lineWrapCheckBox.setSelected(true);
			this.noteDataTextArea.setLineWrap(true);
			this.noteNameTextField.setEditable(false);;
			
			// nameBbox (contains the name input box)
			this.nameBox.add(this.noteNameLabel);
			this.nameBox.add(Box.createHorizontalStrut(10));
			this.nameBox.add(this.noteNameTextField);
			
			// passswordBox (contais the field where the password is written)
			this.passwordBox.add(this.passwordLabel);
			this.passwordBox.add(this.getWhiteBox());
			this.passwordBox.add(this.passwordField);
			

			//Repeat password box 
			
			this.passwordRepeatBox.add(this.passwordRepeatLabel);
			this.passwordRepeatBox.add(this.getWhiteBox());
			this.passwordRepeatBox.add(this.passwordRepeatField);
			
			// noteDataBox (contains the field where the note is written )
			this.noteDataBox.add(this.noteDataTextPane);
			
			
			// mainBox (contais all the boxes)
			this.mainBox.add(nameBox);
			this.mainBox.add(this.getWhiteBox());
			this.mainBox.add(this.noteDataBox);
			this.mainBox.add(this.getWhiteBox());
			this.mainBox.add(this.passwordBox);
			this.mainBox.add(this.getWhiteBox());
			this.mainBox.add(this.passwordRepeatBox);
			
			
			this.add(utils.InstancesUtil.getJPanelInstance(this.titleLabel), BorderLayout.NORTH);
			this.add(utils.InstancesUtil.getJPanelInstance(this.mainBox), BorderLayout.CENTER);
			this.add(utils.InstancesUtil.getJPanelInstance(this.decryptButton, this.saveChangesButton), BorderLayout.SOUTH);
			this.add(utils.InstancesUtil.getJPanelInstance(this.lineWrapCheckBox), BorderLayout.WEST);
			
			
			this.lineWrapCheckBox.addActionListener(new CheckboxCall());
			this.decryptButton.addActionListener(new DecryptNoteCall());
			this.saveChangesButton.addActionListener(new saveButtonPressedCall());
			
			
			// Setting file properties to out GUI
			this.noteNameTextField.setText(this.associatedFile.getName());
			this.noteDataTextArea.setText(utils.FileIOUtil.readFileContentAsString(this.associatedFile.getAbsolutePath()));
			
			
		}
		

		private Box getWhiteBox() {
			
			Box whiteBox = Box.createHorizontalBox();
			whiteBox.add(new JLabel(" "));
			return whiteBox;
		}
		
		private Box getMainBox() {
			return this.mainBox;
		}
		
		private JButton getSaveButton() {
			return this.decryptButton;
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
		
		public void setAssociatedFile(File file) {
			this.associatedFile = file;
			
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
		
	private class CheckboxCall implements ActionListener {

		public CheckboxCall() {}
			
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
				
							String originalText = utils.FileIOUtil.readFileContentAsString(associatedFile.getAbsolutePath());
							String editedText = getNoteText();
				
				
							String cipherText = utils.CryptUtil.encryptWithCBCMode(editedText.getBytes(),
																	   getPassword().toCharArray());	

							utils.FileIOUtil.writeTextToFile(cipherText, associatedFile.getAbsolutePath());
							utils.MessageUtil.showMessage("SUCCEEDED", "Note saved!", utils.MessageUtil.ROUNDED_TICK);
							
							

					} else {
						utils.MessageUtil.showMessage("ERROR","Password doesn't match", utils.MessageUtil.ROUNDED_DENIED);
					}
				} else {
					utils.MessageUtil.showMessage("ERROR", "Provided data can't be blank", utils.MessageUtil.ROUNDED_DENIED);
				}
					
			}
					
		}
			
		// ------------------------------------------------------------------------------------
	
		// -------------------- Listener private class ---------------------------------------	
		
		private class DecryptNoteCall implements ActionListener {

			public DecryptNoteCall() {}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(passwordIsNotBlank() && noteTextIsNotBlank()) {
					
					if(passwordIsWellWritten()) {
				
						String fileContent = utils.FileIOUtil.readFileContentAsString(associatedFile.getAbsolutePath()).trim();

						String encodedSalt = fileContent.substring(0, 24); // salt 16 bytes (24 encoded)
						String encodedIV = fileContent.substring(24, 48); // iv 16 bytes (24 encoded)
						String encodedCiphertext = fileContent.substring(48, fileContent.length());
				
				
						String plaintext = utils.CryptUtil.decryptWithCBCMode(encodedCiphertext, getPassword().toCharArray(),
																	  encodedSalt, encodedIV);

						noteDataTextArea.setText(plaintext);
						noteDataTextArea.getDocument().addDocumentListener(new TextFieldListener());
						
				
					} else {
						utils.MessageUtil.showMessage("ERROR","Password doesn't match", utils.MessageUtil.ROUNDED_DENIED);
					}
				} else {
					utils.MessageUtil.showMessage("ERROR", "Provided data can't be blank", utils.MessageUtil.ROUNDED_DENIED);
				}
						
			}
				
		}
		
		// ------------------------------------------------------------------------------------
		
		
		// -------------------- Listener private class ---------------------------------------	
		
				private class TextFieldListener implements DocumentListener {

					public TextFieldListener() {}

					@Override
					public void insertUpdate(DocumentEvent e) {
						saveChangesButton.setEnabled(true);
						
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						saveChangesButton.setEnabled(true);
						
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						
						
					}
						
					
							
				}
		

}

	

