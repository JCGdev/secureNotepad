package utils;

import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.Toolkit;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageIOUtil {
	
	private static ImageIcon imagenIcon;
	private static BufferedImage bufferedImage;
	
	public ImageIOUtil() {}
	
	
	public static ImageIcon readImageIcon(String path) {
		
		try {
			imagenIcon = new ImageIcon(path);
		}catch(Exception e){e.printStackTrace();}
		
		return imagenIcon; 
		
	}
	
	
	public static Image readImage(String path) {
		
		return readImageIcon(path).getImage();
	}
	
	
	public static Image readBufferedImage(String path) {
		

		try {
			bufferedImage = ImageIO.read(new File(path));
		}catch(Exception e) {e.printStackTrace();}

		return bufferedImage;
		 
	}
	


	public static Image readImageToolkit(Object classObj, String path) {
	
		return Toolkit.getDefaultToolkit().getImage(classObj.getClass().getResource(path));
	
	}

}



