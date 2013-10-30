package edu.gatech.mule.core;

import java.util.List;

import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.RoundController;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.maps.DefaultGameMap;
import edu.gatech.mule.game.map.maps.RandomGameMap;
import edu.gatech.mule.game.map.maps.TownMap;
import edu.gatech.mule.screen.ScreenHandler;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

/**
 * Game engine sets up and runs the MULE game.
 * Has the ability to change the screen view based on game flow.
 * @version 0.1
 */
public class GameEngine {
	
	private ScreenHandler screenHandler;
	private Settings settings;
	private GameMap gameMap;
	private GameMap townMap;
	private List<Player> players;
	private RoundController roundController;
	
	/**
	 * Constructor for the game engine
	 * Loads new settings
	 */
	public GameEngine() {
		this.settings = new Settings();
	}
	
	/**
	 * Loads the screens to start screen
	 * @param handler, screen handler
	 */
	public void load(ScreenHandler handler) {
		this.screenHandler = handler;
		screenHandler.load();
		screenHandler.start();
	}
	
	/**
	 * Get game map
	 * @return game map
	 */
	public GameMap getGameMap() {
		return gameMap;
	}
	
	/**
	 * Gets town map
	 * @return town map
	 */
	public GameMap getTownMap() {
		return townMap;
	}
	
	/**
	 * Shows the start screen
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
	 * Shows the screen for player config
	 */
	public void choosePlayer() {
		screenHandler.setScreen(ScreenType.PLAYER_SCREEN);
	}
	
	/**
	 * Sets up map based on configurations and begins land selection
	 */
	public void playGame() {
		settings.printSettings();
		townMap = new TownMap();
		if(settings.getMapType().equals(MapType.DEFAULT)) {
			gameMap = new DefaultGameMap();
		} else if(settings.getMapType().equals(MapType.RANDOM)) {
			gameMap = new RandomGameMap();
		}

		players = settings.getPlayers();
		screenHandler.setScreen(ScreenType.LAND_SELECT);
	}
	
	/**
	 * Shows screen of game map in general gameplay
	 */
	public void gameplay() {
		screenHandler.setScreen(ScreenType.GAME_SCREEN);
	}
	
	/**
	 * Shows screen of town map when entering town
	 */
	public void enterTown() {
		screenHandler.setScreen(ScreenType.TOWN_SCREEN);
	}
	
	/**
	 * Shows screen of game map when exiting town
	 */
	public void exitTown() {
		screenHandler.setScreen(ScreenType.GAME_SCREEN);
	}
	
	/**
	 * Gets settings
	 * @return settings
	 */
	public Settings getSettings() {
		return settings;
	}
	
	/**
	 * Gets list of plays
	 * @return list of players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	public Player getCurrentPlayer() {
		return roundController.getCurrentPlayer();
	}
	
}
