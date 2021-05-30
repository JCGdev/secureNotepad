package secureNotepad;

import java.io.File;
import java.util.ArrayList;

import utils.Preferences;

public class NotesManager {
	
	public NotesManager() {
		
		
	}

	
	
	public static File[] getNotesInPath() {
		
		return utils.FileIOUtil.readFolder(Preferences.NOTES_DIR_PATH).listFiles();
			
	}
	
	public static File getNoteInPath(String name) {
		
		File[] files = utils.FileIOUtil.readFolder(Preferences.NOTES_DIR_PATH).listFiles();
		File fileToReturn = null;
		
		for(File file : files) {
			if(file.getName().toLowerCase() == name.toLowerCase()) {
				fileToReturn = file;
			}
		}
		
		return fileToReturn;
	}

	public static ArrayList<String> getNotesFilenamesInPath() {
		
		ArrayList<String> filenames = new ArrayList<String>();
			
		for(File file : getNotesInPath()) {
			filenames.add(file.getName());
		}
			
		return filenames;
	}
	
	
	
}
