package secureNotepad;

import javax.swing.JOptionPane;

import gui.GUI;
import gui.settingsMenu.SettingsGUI;

public class Main {

	
													   
	
	public static void main(String[] args) {
		
		if(ConfigFileManager.configFileExists()) {
			ConfigFileManager.readConfigFile();
			ConfigFileManager.checkNotesFolder();
			
			Main.startProgram();
			
		} else {
			Main.startConfigMenu();
			utils.MessageUtil.showMessage("Error","Config File couldn't be read, let's create one" , utils.MessageUtil.ROUNDED_ALERT);
		}
		

	}

	public static void startProgram() {
			
			GUI.startGUI();
	}
	
	public static void startConfigMenu() {
			SettingsGUI.startGUI();
	}
	

		
	}
	
	
