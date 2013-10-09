package edu.gatech.mule.core;

import java.util.ArrayList;

import edu.gatech.mule.game.*;
import edu.gatech.mule.screen.*;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

public class GameEngine {
	
	private ScreenHandler screenHandler;
	private Settings settings;
	
	public GameEngine(ScreenHandler screenHandler) {
		this.screenHandler = screenHandler;
		this.settings = new Settings();
		
		screenHandler.load(this);
		chooseSettings();
		screenHandler.start();
	}
	
	public void start() {
		screenHandler.setScreen(ScreenType.START);
	}
	public void chooseSettings() {
		screenHandler.setScreen(ScreenType.MENU);
	}
	public void playGame() {
		System.out.println("HEY BUDDY");
	}

	
	public Settings getSettings() {
		return settings;
	}
	
	
	

}
