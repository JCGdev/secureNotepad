package utils;

import java.awt.Toolkit;

public class ToolkitUtil {
	
	private static Toolkit toolKit = Toolkit.getDefaultToolkit();
	
	
	public static Toolkit getInstance() {
		
		return toolKit;
	}
	
	
	public static int getWindowWidth() {
		
		return toolKit.getScreenSize().width;
	}
	
	public static int getWindowHeigth() {
		
		return toolKit.getScreenSize().height;
	}

	
	
}
