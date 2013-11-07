package edu.gatech.mule.core;

import java.util.List;

import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Round;
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
	
	public void setScreen(ScreenType type) {
		screenHandler.setScreen(type);
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
	
	public void start() {
		screenHandler.setScreen(ScreenType.START);
	}
	
	public void persistence() {
		screenHandler.setScreen(ScreenType.PERSISTENCE);
	}
	
	public void help() {
		screenHandler.setScreen(ScreenType.HELP);
	}
	
	public void chooseDifficulty() {
		screenHandler.setScreen(ScreenType.DIFFICULTY);
	}
	
	public void chooseMapType() {
		screenHandler.setScreen(ScreenType.MAP_TYPE);
	}
	
	public void chooseNumPlayers() {
		screenHandler.setScreen(ScreenType.NUM_PLAYERS);
	}
	
	public void chooseRace() {
		screenHandler.setScreen(ScreenType.RACE_SELECT);
	}
	
	public void chooseColor() {
		screenHandler.setScreen(ScreenType.COLOR);
	}
	
	public void chooseName() {
		screenHandler.setScreen(ScreenType.NAME);
	}
	
	/**
	 * Sets up map based on configurations and begins land selection
	 */
	public void playGame() {
		roundController = new RoundController(this, 2);
		townMap = new TownMap();
		if(settings.getMapType().equals(MapType.DEFAULT)) {
			gameMap = new DefaultGameMap();
		} else if(settings.getMapType().equals(MapType.RANDOM)) {
			gameMap = new RandomGameMap();
		}

		players = settings.getPlayers();
		
		roundController.round();
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
	
	public void end() {
		System.out.println("That's all, folks! (thanks for bearing with us)");
		System.exit(0);
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

	public Round getRound() {
		return roundController.getRound();
	}
	
}
