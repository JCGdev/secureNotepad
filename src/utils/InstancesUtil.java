package utils;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstancesUtil {

	
	
	public static JPanel getJPanelInstance() {
		
		return new JPanel();
	}
	
	public static JPanel getJPanelInstance(Component component) {
		
		JPanel instance = new JPanel();
		instance.add(component);
		instance.setOpaque(false);
		
		return instance;
	}
	
	public static JPanel getJPanelInstance(Component component, Component component2) {
		
		JPanel instance = new JPanel();
		instance.add(component);
		instance.add(component2);
		instance.setOpaque(false);
		
		return instance;
	}
	
	public static JPanel getJPanelInstance(ImageIcon icon, Component component2) {
		
		JPanel instance = new JPanel();
		JLabel iconLabel = new JLabel();
		iconLabel.setIcon(icon);
		
		instance.add(iconLabel);
		instance.add(component2);
		instance.setOpaque(false);
		
		return instance;
	}
	
	public static JPanel getJPanelInstance(ImageIcon icon) {
		
		JPanel instance = new JPanel();
		JLabel iconLabel = new JLabel();
		iconLabel.setIcon(icon);
		
		instance.add(iconLabel);
		instance.setOpaque(false);
		
		return instance;
	}
	
	
	public static JPanel getJPanelInstance(Component[] componentsArray) {
		
		JPanel instance = new JPanel();
		
		for (Component component : componentsArray) {
			instance.add(component);
		}
		return instance;
	}
	
	
	
}
