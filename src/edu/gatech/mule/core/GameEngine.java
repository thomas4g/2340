package edu.gatech.mule.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.maps.DefaultGameMap;
import edu.gatech.mule.game.map.maps.RandomGameMap;
import edu.gatech.mule.game.map.maps.TownMap;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.round.Round;
import edu.gatech.mule.game.round.RoundController;
import edu.gatech.mule.music.MusicPlayer;
import edu.gatech.mule.screen.ScreenHandler;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

/**
 * Game engine sets up and runs the MULE game.
 * Has the ability to change the screen view based on game flow.
 * @version 0.1
 */
public class GameEngine implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 725082656704462973L;
	private ScreenHandler screenHandler;
	private Settings settings;
	private GameMap gameMap;
	private GameMap townMap;
	private List<Player> players;
	private RoundController roundController;
	private MusicPlayer musicPlayer;
	
	/**
	 * Constructor for the game engine
	 * Loads new settings
	 */
	public GameEngine() {
		this.settings = new Settings();
		this.musicPlayer = new MusicPlayer();
		musicPlayer.setMedia(getClass().getResource("/music/Artifact.mp3"));
	}
	
	/**
	 * Loads the screens to start screen
	 * @param handler, screen handler
	 */
	public void load(ScreenHandler handler) {
		this.screenHandler = handler;
		screenHandler.load();
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
		musicPlayer.play();
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
		musicPlayer.setMedia(getClass().getResource("/music/Night Cave.mp3"));
		musicPlayer.play();
		roundController = new RoundController(this, 1);
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
	
	public boolean allPlayersSet() {
		return settings.allPlayersSet();
	}

	public void loadNewGame(GameEngine ge) {
		
	}
	
	public void saveGameFile(String filename) {
		try {
			ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("saveFile.sav"));
			save.writeObject(this);
			save.flush();
			save.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadGameFile(String filename) {
		try {
			ObjectInputStream load = new ObjectInputStream(new FileInputStream(filename + ".mule"));
			GameEngine game = (GameEngine)load.readObject();
			load.close();
			loadNewGame(game);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
