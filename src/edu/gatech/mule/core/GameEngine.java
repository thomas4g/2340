package edu.gatech.mule.core;

import java.util.ArrayList;

import edu.gatech.mule.game.*;
import edu.gatech.mule.screen.*;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

/**
 * Game engine sets up and runs the MULE game.
 * 
 * Sets up the screen handler and game settings.
 * Has the ability to change the screen view.
 * 
 * @version 1.0
 *
 */
public class GameEngine {
	
	private ScreenHandler screenHandler;
	private Settings settings;
	
	/**
	 * Sets up the screen handler and instantiates the settings.
	 * Also loads the main screen by default.
	 * 
	 * @param screenHandler, the screen handler of the program.
	 * 
	 */
	public GameEngine(ScreenHandler screenHandler) {
		this.screenHandler = screenHandler;
		this.settings = new Settings();
		
		screenHandler.load(this);
		screenHandler.start();
	}
	
	/**
	 * Shows the main screen
	 */
	public void start() {
		screenHandler.setScreen(ScreenType.START);
	}
	
	/**
	 * Shows the config settings
	 */
	public void chooseSettings() {
		screenHandler.setScreen(ScreenType.SETTINGS);
	}
	
	/**
	 * Shows the screen for choosing race
	 */
	public void chooseRace(){
		screenHandler.setScreen(ScreenType.RACE_SELECT);
	}
	
	/**
	 * Shows the screen for player config
	 */
	public void choosePlayer(){
		screenHandler.setScreen(ScreenType.PLAYER_SCREEN);
	}
	
	/**
	 * Shows the screen of the main map
	 */
	public void playGame() {
		screenHandler.setScreen(ScreenType.GAME_SCREEN);
	}
	
	/**
	 * Gets the game settings
	 */
	public Settings getSettings() {
		return settings;
	}
	
}
