package secureNotepad;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ConfigFileManager {

	public static final String WINDOWS_CONFIG_PATH = String.format("C:\\Users\\%s\\AppData\\Local\\secureNotepad",
														   utils.OSUtil.getOSUser());
	
	public static final String WINDOWS_CONFIG_FILE_PATH = String.format("C:\\Users\\%s\\AppData\\Local\\secureNotepad\\config.conf",
			 												 utils.OSUtil.getOSUser());

	public static final String UNIX_CONFIG_PATH = String.format("%s/.config/secureNotepad",
			  										  utils.OSUtil.getOSHome());
	
	public static final String UNIX_CONFIG_FILE_PATH = String.format("%s/.config/secureNotepad/config.conf",
														  utils.OSUtil.getOSHome());
	

	public ConfigFileManager() {}
	

	
	public static boolean configFileExists(){

	File configFile;
	boolean status = false;

	if(utils.OSUtil.isWindows()) {

		configFile= utils.FileIOUtil.readFile(WINDOWS_CONFIG_FILE_PATH );
		status = configFile.exists();

	}

	if(utils.OSUtil.isUnix()) {
	
		configFile = utils.FileIOUtil.readFile(UNIX_CONFIG_FILE_PATH);
		status = configFile.exists();
			
	}


	return status;


	}
	
	public static void checkNotesFolder() {
		
		if (utils.FileIOUtil.folderNotExists(utils.Preferences.NOTES_DIR_PATH)){
				utils.FileIOUtil.createFolder(utils.Preferences.NOTES_DIR_PATH);
			
		}
	}
	
	public static boolean configFileNotExists() {
		return !configFileExists();
	}
	
	
	public static boolean configFileIsEmpty() {
		
		boolean status = false;
		
		if(utils.OSUtil.isLinux()) {
			if(configFileExists()) {
				ArrayList<String> configFileContent = utils.FileIOUtil.readFileContent(UNIX_CONFIG_FILE_PATH);
		
				if(configFileContent.isEmpty()) {
					status = true;
				} else {
					status = false;
				}
			}
			
		} else if(utils.OSUtil.isWindows()) {
			if(configFileExists()) {
				ArrayList<String> configFileContent = utils.FileIOUtil.readFileContent(WINDOWS_CONFIG_FILE_PATH);
		
				if(configFileContent.isEmpty()) {
					status = true;
				} else {
					status = false;
				}
			
			}
		}
		
		return status;
	}
	
	public static boolean configFileIsNotEmpty() {
		return !configFileIsEmpty();
	}
	
	public static void createConfigFile() {

		
		if(utils.OSUtil.isUnix()) {			
			createConfigDir();
			utils.FileIOUtil.createFile(UNIX_CONFIG_FILE_PATH);
		}
		
		if(utils.OSUtil.isWindows()) {
			createConfigDir();
			utils.FileIOUtil.createFile(WINDOWS_CONFIG_FILE_PATH);
				
		}
		
	}
	
	@Deprecated // LastLine should be free when finished saving stuff to the file
	public static void writeTextToConfigFile(String line) {
		
		if(utils.OSUtil.isUnix()) {
			if(configFileExists() && configFileIsEmpty()) {
				utils.FileIOUtil.writeTextToFile(line, UNIX_CONFIG_FILE_PATH);
				
			} else {
				utils.FileIOUtil.deleteFile(UNIX_CONFIG_FILE_PATH);
				utils.FileIOUtil.createFile(UNIX_CONFIG_FILE_PATH);
				writeTextToConfigFile(line);

			}
		} 
		
		if(utils.OSUtil.isWindows()) {
			if(configFileExists() && configFileIsEmpty()) {
				utils.FileIOUtil.writeTextToFile(line, WINDOWS_CONFIG_FILE_PATH );
			} else {
				utils.FileIOUtil.deleteFile(WINDOWS_CONFIG_FILE_PATH);
				utils.FileIOUtil.createFile(WINDOWS_CONFIG_FILE_PATH);
				writeTextToConfigFile(line);
				
			}
			
		}
	
		
	}
	

	public static void writeTextToConfigFile(String[] lines) {
		
		if(utils.OSUtil.isUnix()) {
			if(configFileExists() && configFileIsEmpty()) {
				utils.FileIOUtil.writeTextToFile(lines, UNIX_CONFIG_FILE_PATH);
				
			} else {
				utils.FileIOUtil.deleteFile(UNIX_CONFIG_FILE_PATH);
				utils.FileIOUtil.createFile(UNIX_CONFIG_FILE_PATH);
				writeTextToConfigFile(lines);

			}
		} 
		
		if(utils.OSUtil.isWindows()) {
			if(configFileExists() && configFileIsEmpty()) {
				utils.FileIOUtil.writeTextToFile(lines, WINDOWS_CONFIG_FILE_PATH );
			} else {
				utils.FileIOUtil.deleteFile(WINDOWS_CONFIG_FILE_PATH);
				utils.FileIOUtil.createFile(WINDOWS_CONFIG_FILE_PATH);
				writeTextToConfigFile(lines);
				
			}
			
		}
	
		
	}
	
	public static File loadFile() {
		

		File configFile = null;
		
		if(utils.OSUtil.isUnix()) {
			configFile = new File(UNIX_CONFIG_FILE_PATH);
		} 
		
		if(utils.OSUtil.isWindows()) {
			configFile = new File(WINDOWS_CONFIG_FILE_PATH);
			
		}
	
		return configFile;
		
	}
		
	public static void readConfigFile(){
		
		File configFile = null;
		ArrayList<String> fileContent;
		
		
		if(utils.OSUtil.isUnix()) {
			if(configFileExists() && configFileIsNotEmpty()) {
				
				configFile = utils.FileIOUtil.readFile(UNIX_CONFIG_FILE_PATH);
				fileContent = utils.FileIOUtil.readFileContent(configFile);
				
				try {
					utils.Preferences.NOTES_DIR_PATH = fileContent.get(1).split("=")[1];  // key=value --> value
					
				}catch(IndexOutOfBoundsException e) {	// in case some configs are missings
					utils.FileIOUtil.deleteFile(UNIX_CONFIG_FILE_PATH);
					utils.ErrorUtil.showErrorMessage("Config file missing or config file corrupted. Please restart", e);
					
					System.exit(0);
				}
				
				
			}
		}
		
		if(utils.OSUtil.isWindows()) {
			if(configFileExists() && configFileIsNotEmpty()) {
				
				configFile = utils.FileIOUtil.readFile(WINDOWS_CONFIG_FILE_PATH);
				fileContent = utils.FileIOUtil.readFileContent(configFile);
				
				try {
					utils.Preferences.NOTES_DIR_PATH = fileContent.get(1).split("=")[1];  // key:value --> value
				
				}catch(IndexOutOfBoundsException e) {	// in case some configs are missings
					e.printStackTrace();
					utils.FileIOUtil.deleteFile(WINDOWS_CONFIG_FILE_PATH);
					utils.ErrorUtil.showErrorMessage("Config file missing or config file corrupted. Please restart", e);
					
					System.exit(0);
				}
				
				
			}
		}
		
		
	}
	
	
	private static void createConfigDir() {
		
		if(utils.OSUtil.isUnix()) {
			if (!Files.exists(Paths.get(UNIX_CONFIG_PATH))){
				try {
					Files.createDirectory(Paths.get(UNIX_CONFIG_PATH));
				
				}catch(Exception e) {e.printStackTrace();}
			}
		}
		
		if(utils.OSUtil.isWindows()) {
			if (!Files.exists(Paths.get(WINDOWS_CONFIG_PATH))){
				try {
					Files.createDirectory(Paths.get(WINDOWS_CONFIG_PATH));
				
				}catch(Exception e) {e.printStackTrace();}
			}
		}
		
	}
	
}
