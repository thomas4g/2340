package edu.gatech.mule.core;

import edu.gatech.mule.screen.*;
import edu.gatech.mule.screen.ScreenHandler.Screen;
public class GameEngine {
	
	public enum DIFFICULTY {EASY, MEDIUM, HARD};
	
	private ScreenHandler screens;
	
	public GameEngine(ScreenHandler screens) {
		this.screens = screens;
	}
	
	public void start() {
		screens.setCurrentScreen(Screen.MENU);
	}
	
}
