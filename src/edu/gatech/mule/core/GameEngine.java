package edu.gatech.mule.core;

import tiled.core.Map;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.maps.DefaultGameMap;
import edu.gatech.mule.game.map.maps.RandomGameMap;
import edu.gatech.mule.screen.ScreenHandler;
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
	private GameMap gameMap;
	private GameMap townMap;
	
	/**
	 * Sets up the screen handler and instantiates the settings.
	 * Also loads the main screen by default.
	 * 
	 * @param screenHandler, the screen handler of the program.
	 * 
	 */
	public GameEngine() {
		this.settings = new Settings();		
	}
	
	public void load(ScreenHandler handler) {
		this.screenHandler = handler;
		screenHandler.load();
		screenHandler.start();
	}
	
	public Map getGameMap() {
		return gameMap.getMap();
	}
	
	public Map getTownMap() {
		return townMap.getMap();
	}
	
//	public void disposeScreen(ScreenType type) {
//		screenHandler.disposeScreen(type);
//	}
	
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
	public void chooseRace() {
		screenHandler.setScreen(ScreenType.RACE_SELECT);
	}
	
	/**
	 * Shows the screen for
	 */
	public void choosePlayer() {
		screenHandler.setScreen(ScreenType.PLAYER_SCREEN);
	}
	
	/**
	 * Shows the screen of the main map
	 */
	public void playGame() {
		settings.printSettings();
//		townMap = new TownMap();
		if(settings.getMapType().equals(MapType.DEFAULT)) {
			gameMap = new DefaultGameMap();
		} else if(settings.getMapType().equals(MapType.RANDOM)) {
			gameMap = new RandomGameMap();
		}
		screenHandler.setScreen(ScreenType.GAME_SCREEN);
	}
	
	/**
	 * Gets the settings
	 */
	public Settings getSettings() {
		return settings;
	}
	
	

}
