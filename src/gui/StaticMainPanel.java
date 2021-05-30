package gui;

public class StaticMainPanel {

	private static MainPanel mainPanelInstance = null;
	
	public StaticMainPanel() {};
	
	public static MainPanel getInstance() {
		
		if(mainPanelInstance == null) {
			mainPanelInstance = new MainPanel();
		}
		
		return mainPanelInstance;
	}
	
}
