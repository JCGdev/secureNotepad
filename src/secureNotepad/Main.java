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
			utils.ErrorUtil.showErrorMessage("Config File couldn't be read, let's create one");
		}
		

	}

	public static void startProgram() {
			
			GUI.startGUI();
	}
	
	public static void startConfigMenu() {
			SettingsGUI.startGUI();
	}
	

		
	}
	
	
