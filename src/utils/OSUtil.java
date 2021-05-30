package utils;

public class OSUtil {
	
	private static String OSName = System.getProperty("os.name").toLowerCase();
	
	
	
	public static String getOSUser() {
		return System.getProperty("user.name");
	}
	
	public static String getOSHome() {
		return System.getProperty("user.home");
	}
	
	public static boolean isWindows() {
		return OSName.contains("win");
	}

	public static boolean isMac() {
		return OSName.contains("mac");
	}

	public static boolean isLinux() {
		return OSName.contains("linux");
	}
	
	public static boolean isUnix() {
		return OSName.contains("linux") || OSName.contains("mac");
	}
	
	public static String getOSName() {
		return System.getProperty("os.name").toLowerCase();
		
	}

	
}
