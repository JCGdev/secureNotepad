package utils;

import java.io.File;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIOUtil {
	
	private static FileWriter fileWriter;
	private static String lastLine = "";
	
	
	public static void createFile(String path) {
		
		try {
			File fileToRead = new File(path);
			fileToRead.createNewFile();
			
		} catch(Exception e) {utils.ErrorUtil.showErrorMessage("failed creating file", e);}
		
	}
		
	
	
	public static File readFile(String path) {
		
		File fileToRead = null;
		
		try {
			fileToRead = new File(path);
			
		} catch(Exception e) {utils.ErrorUtil.showErrorMessage("failed creating folder", e);}
		
		return fileToRead;
	}

	
	public static void createFolder(String path) {
		
		try {
			File fileToRead = new File(path);
			fileToRead.mkdirs();
			
		} catch(Exception e) {utils.ErrorUtil.showErrorMessage("failed creating file", e);}
		
		
	}
	
	public static File readFolder(String path) {
		return readFile(path);
	}
	
	
	public static boolean fileExists(String path) {
		return new File(path).exists();
	}
	
	public static boolean folderExists(String path) {
		return new File(path).isDirectory();
	}
	
	public static boolean fileNotExists(String path) {
		return !fileExists(path);
	}
	
	public static boolean folderNotExists(String path) {
		return !fileExists(path);
	}
	
	public static ArrayList<String> readFileContent(String path) {
		
		ArrayList<String> fileLines = new ArrayList<String>();
		File fileToRead = null;
		Scanner fileReader = null;
		
		try {
			fileToRead = readFile(path);
			fileReader = new Scanner(fileToRead);
			
		} catch (Exception e) {e.printStackTrace();}
		
		
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			fileLines.add(line);
		}
		
		fileReader.close();
		return fileLines;
	}
	
	public static String readFileContentAsString(String path) {
		
		String content = "";
		ArrayList<String> linesArray = readFileContent(path);
		
		for(String line : linesArray) {
			content = content + line + "\n";
		}
		
		return content;
	}
	
	public static ArrayList<String> readFileContent(File file) {
		
		ArrayList<String> fileLines = new ArrayList<String>();
		Scanner fileReader = null;
	
		try {
			fileReader = new Scanner(file);

		} catch (Exception e) {e.printStackTrace();}
		
		
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			fileLines.add(line);
		}
		
		fileReader.close();
		return fileLines;
		
		
	}
	
	public static byte[] readFileContentAsBytes(String path) {
		
		Scanner fileReader = null;
		File fileToRead = null;
		byte[] fileBytes = null;
	
		try {
			fileToRead = readFile(path);
			fileBytes = Files.readAllBytes(fileToRead.toPath());

		} catch (Exception e) {utils.ErrorUtil.showErrorMessage("Error reading file btyes", e);}
	
		return fileBytes;
	}
	
	
	
	public static byte[] readFileContentAsBytes(File file) {
		
		Scanner fileReader = null;
		byte[] fileBytes = null;
	
		try {
			fileBytes = Files.readAllBytes(file.toPath());

		} catch (Exception e) {utils.ErrorUtil.showErrorMessage("Error reading file btyes", e);}
	
		return fileBytes;
	}
	
	
	public static void deleteFile(String path) {

		File fileToDelete;
		
		try {
			fileToDelete = new File(path);
			fileToDelete.delete();
		} catch(Exception e) {e.printStackTrace();}
		
	}
	
	
	public static void renameFile(String filePath, String desiredFilePath) {
		
		File fileToRename;
		
		try {
			fileToRename = new File(filePath);
			fileToRename.renameTo(new File(desiredFilePath));
			
		} catch(Exception e) {e.printStackTrace();}
		
	}
	
	public static void writeTextToFile(String line, String path) {
		
		try {
			fileWriter = new FileWriter(path);
			
			fileWriter.write(line);
			fileWriter.close();

			
			
		} catch(Exception e) {e.printStackTrace();}
		
		
	}
	
	public static void writeTextToFile(String[] lines, String path) {
		
		try {
			fileWriter = new FileWriter(path);
			
			for(String line : lines) {
			
				fileWriter.write(line + "\n");
				
				lastLine = lastLine + line;
			}
			
			fileWriter.close();
			lastLine = "";
			
		} catch(Exception e) {e.printStackTrace();}
		
	}
	
}
