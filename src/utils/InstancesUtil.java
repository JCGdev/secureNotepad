package utils;

import java.awt.Component;

import javax.swing.JPanel;

public class InstancesUtil {

	
	
	public static JPanel getJPanelInstance() {
		
		return new JPanel();
	}
	
	public static JPanel getJPanelInstance(Component component) {
		
		JPanel instance = new JPanel();
		instance.add(component);
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
