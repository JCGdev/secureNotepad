package utils;

import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.Toolkit;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageIOUtil {
	
	private static ImageIOUtil imageIOUtilInstance = null;
	private static ImageIcon imagenIcon;
	private static BufferedImage bufferedImage;
	
	public ImageIOUtil() {}
	
	public static ImageIOUtil getInstance() {
		if(imageIOUtilInstance == null) {
			imageIOUtilInstance = new ImageIOUtil();
		}
		
		return imageIOUtilInstance;
	}
	
	
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
	
	public ImageIcon getIcon(String path) {
		return new ImageIcon(this.getClass().getResource(path));
	}
	
	public Image getIconImage(String path) {
		return this.getIcon(path).getImage();
	}
	
	
	public Image getResource(String path) {
		return new ImageIcon(this.getClass().getResource(path)).getImage();
	}

	public Image readImageToolkit(String path) {
	
		return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(path));
	
	}
	
	

}



