package edu.gatech.mule.core;

import java.util.ArrayList;

import edu.gatech.mule.game.*;
import edu.gatech.mule.screen.*;

public class GameEngine {
	
	private ScreenHandler screenHandler;
	private Settings settings;
	
	public GameEngine(ScreenHandler screenHandler) {
		this.screenHandler = screenHandler;
		this.settings = new Settings();
	}
	
	public void start() {
		screenHandler.setScreen(Screen.MENU);
	}
	

}
