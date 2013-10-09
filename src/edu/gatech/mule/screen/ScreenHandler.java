package edu.gatech.mule.screen;

import java.util.HashMap;

public abstract class ScreenHandler {
	public enum ScreenType {START, MENU};
	private HashMap<ScreenType, IScreen> screens;
	
	public ScreenHandler() {
		screens = new HashMap<ScreenType, IScreen>();
	}
	
	public void setScreen(ScreenType type) {
		screens.get(type).display();
	}
}
