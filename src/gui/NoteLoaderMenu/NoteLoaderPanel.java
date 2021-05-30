package gui.NoteLoaderMenu;

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

public class NoteLoaderPanel extends JPanel{

		protected File associatedFile;
		
		protected JLabel titleLabel = new JLabel("Note Loader");
		protected Box mainBox = Box.createVerticalBox();
		
		protected Box nameBox = Box.createHorizontalBox();
		protected JLabel noteNameLabel = new JLabel("Name");
		protected JTextField noteNameTextField = new JTextField("example" , 5);
		
		protected Box passwordBox = Box.createHorizontalBox();
		protected JLabel passwordLabel = new JLabel("Password");
		protected JPasswordField passwordField = new JPasswordField(5);
		
		protected Box noteDataBox = Box.createHorizontalBox();
		protected JTextArea noteDataTextArea = new JTextArea(20, 50);
		protected JScrollPane noteDataTextPane = new JScrollPane(noteDataTextArea);
		
		protected JCheckBox lineWrapCheckBox = new JCheckBox("Line wrap");
		
		protected JPanel buttonsPanel = new JPanel();
		protected JButton decryptButton = new JButton("Decrypt");
		protected JButton saveChangesButton = new JButton("Save changes");
		

		
		public NoteLoaderPanel(File file) {
			
			this.setAssociatedFile(file);
			this.setLayout(new BorderLayout());
			
			this.titleLabel.setFont(new Font("Serif", Font.BOLD, 26));
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
			this.passwordBox.add(Box.createHorizontalStrut(10));
			this.passwordBox.add(this.passwordField);
			
			
			// noteDataBox (contains the field where the note is written )
			this.noteDataBox.add(this.noteDataTextPane);
			
			
			// mainBox (contais all the boxes)
			this.mainBox.add(nameBox);
			this.mainBox.add(this.getWhiteBox());
			this.mainBox.add(this.noteDataBox);
			this.mainBox.add(this.getWhiteBox());
			this.mainBox.add(this.passwordBox);

			// buttonsPanel (where the buttons are stored)
			this.buttonsPanel.add(this.decryptButton);
			this.buttonsPanel.add(this.saveChangesButton);
			
			this.add(utils.InstancesUtil.getJPanelInstance(this.titleLabel), BorderLayout.NORTH);
			this.add(utils.InstancesUtil.getJPanelInstance(this.mainBox), BorderLayout.CENTER);
			this.add(this.buttonsPanel, BorderLayout.SOUTH);
			this.add(utils.InstancesUtil.getJPanelInstance(this.lineWrapCheckBox), BorderLayout.WEST);
			
			
			this.lineWrapCheckBox.addActionListener(new CheckboxCall());
			this.decryptButton.addActionListener(new DecryptNoteCall());
			this.saveChangesButton.addActionListener(new saveButtonPressedCall());
			
			
			// Setting file properties to out GUI
			this.noteNameTextField.setText(this.associatedFile.getName());
			this.noteDataTextArea.setText(utils.FileIOUtil.readFileContentAsString(this.associatedFile.getAbsolutePath()));
			
			
		}
		

		protected Box getWhiteBox() {
			
			Box whiteBox = Box.createHorizontalBox();
			whiteBox.add(new JLabel(" "));
			return whiteBox;
		}
		
		protected Box getMainBox() {
			return this.mainBox;
		}
		
		protected JButton getSaveButton() {
			return this.decryptButton;
		}
		
		protected String getNoteName() {
			return this.noteNameTextField.getText();
		}
		
		protected String getNoteText() {
			return this.noteDataTextArea.getText();
		}
		
		protected String getPassword() {
			return new String(this.passwordField.getPassword());
		}
		
		public void setAssociatedFile(File file) {
			this.associatedFile = file;
			
		}
		
		
		
		
	// -------------------- Listener protected class ---------------------------------------	
		
	protected class CheckboxCall implements ActionListener {

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
		
	// -------------------- Listener protected class ---------------------------------------	
		
		private class saveButtonPressedCall implements ActionListener {

			public saveButtonPressedCall() {}
				
			@Override
			public void actionPerformed(ActionEvent e) {
					
				String originalText = utils.FileIOUtil.readFileContentAsString(associatedFile.getAbsolutePath());
				String editedText = getNoteText();
				
				String cipherText = utils.CryptUtil.encryptWithCBCMode(editedText.getBytes(),
																	   getPassword().toCharArray());
				

				utils.FileIOUtil.writeTextToFile(cipherText, associatedFile.getAbsolutePath());
				JOptionPane.showMessageDialog(null, "Note saved!");
					
					
					
			}
					
		}
			
		// ------------------------------------------------------------------------------------
	
		// -------------------- Listener private class ---------------------------------------	
		
		private class DecryptNoteCall implements ActionListener {

			public DecryptNoteCall() {}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String fileContent = utils.FileIOUtil.readFileContentAsString(associatedFile.getAbsolutePath()).trim();

				String encodedSalt = fileContent.substring(0, 24); // salt 16 bytes (24 encoded)
				String encodedIV = fileContent.substring(24, 48); // iv 16 bytes (24 encoded)
				String encodedCiphertext = fileContent.substring(48, fileContent.length());
				
				
				String plaintext = utils.CryptUtil.decryptWithCBCMode(encodedCiphertext, getPassword().toCharArray(),
																	  encodedSalt, encodedIV);

				noteDataTextArea.setText(plaintext);
				
			}
				
		}
		
		// ------------------------------------------------------------------------------------
		

}

	

