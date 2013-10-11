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
		screenHandler.start();
	}
	
	public void start() {
		screenHandler.setScreen(ScreenType.START);
	}
	public void chooseSettings() {
		screenHandler.setScreen(ScreenType.SETTINGS);
	}
	public void chooseRace(){
		screenHandler.setScreen(ScreenType.RACE_SELECT);
	}
	public void choosePlayer(){
		screenHandler.setScreen(ScreenType.PLAYER_SCREEN);
	}
	
	public void playGame() {
		screenHandler.setScreen(ScreenType.GAME_SCREEN);
	}
	
	public Settings getSettings() {
		return settings;
	}
	
	

}
