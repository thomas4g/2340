package edu.gatech.mule.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import edu.gatech.mule.game.Message;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.game.map.maps.DefaultGameMap;
import edu.gatech.mule.game.map.maps.GameMap;
import edu.gatech.mule.game.map.maps.RandomGameMap;
import edu.gatech.mule.game.map.maps.TownMap;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.round.Round;
import edu.gatech.mule.game.round.RoundController;
import edu.gatech.mule.music.MusicPlayer;
import edu.gatech.mule.screen.ScreenHandler;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

/** Game engine/controller for the MULE game.
 * @version 1.0
 */
public class GameEngine implements Serializable {

	private static final long serialVersionUID = 725082656704462973L;
	private final int rounds = 12;
	private transient ScreenHandler screenHandler;
	private Settings settings;
	private GameMap gameMap;
	private GameMap townMap;
	private List<Player> players;
	private RoundController roundController;
	private transient MusicPlayer musicPlayer;
	private ScreenType currentScreen;
	private transient Message message;

	/** Constructor for game engine.
	 * Sets up settings and music player
	 */
	public GameEngine() {
		this.settings = new Settings();
		this.musicPlayer = new MusicPlayer();
		this.message = new Message();
		musicPlayer.setMedia(
				getClass().getResource("/music/Artifact.mp3"));
	}

	/** Loads the screens.
	 * @param handler screen handler
	 */
	public void load(ScreenHandler handler) {
		this.screenHandler = handler;
		screenHandler.load();
	}

	/** Sets a screen up.
	 * @param type type of screen to be set up
	 */
	public void setScreen(ScreenType type) {
		screenHandler.setScreen(type);
	}

	/** Get game map.
	 * @return game map
	 */
	public GameMap getGameMap() {
		return gameMap;
	}

	/** Gets town map.
	 * @return town map
	 */
	public GameMap getTownMap() {
		return townMap;
	}

	/** Starts music and displays start screen.
	 */
	public void start() {
		musicPlayer.play();
		setScreen(ScreenType.START);
	}

	/** Displays screen for making/loading game.
	 */
	public void persistence() {
		setScreen(ScreenType.PERSISTENCE);
	}

	/** Displays help screen.
	 */
	public void help() {
		setScreen(ScreenType.HELP);
	}

	/** Displays screen for setting difficulty.
	 */
	public void chooseDifficulty() {
		setScreen(ScreenType.DIFFICULTY);
	}

	/** Displays screen for setting map type.
	 */
	public void chooseMapType() {
		setScreen(ScreenType.MAP_TYPE);
	}

	/** Displays screen for setting the number of players.
	 */
	public void chooseNumPlayers() {
		setScreen(ScreenType.NUM_PLAYERS);
	}

	/** Displays screen for choosing player race.
	 */
	public void chooseRace() {
		setScreen(ScreenType.RACE_SELECT);
	}

	/** Displays screen for choosing player color.
	 */
	public void chooseColor() {
		setScreen(ScreenType.COLOR);
	}

	/** Displays screen for player name.
	 */
	public void chooseName() {
		setScreen(ScreenType.NAME);
	}

	/** Sets up map based on configurations and begins land selection.
	 */
	public void playGame() {
		musicPlayer.setMedia(
			getClass().getResource("/music/Night Cave.mp3"));
		musicPlayer.play();
		roundController = new RoundController(this, rounds);
		setupMaps();
		players = settings.getPlayers();
		roundController.round();
	}

	private void setupMaps() {
		townMap = new TownMap();
		if (settings.getMapType().equals(MapType.DEFAULT)) {
			gameMap = new DefaultGameMap();
		} else if (settings.getMapType().equals(MapType.RANDOM)) {
			gameMap = new RandomGameMap();
		}
	}

	/** Shows screen of town map when entering town.
	 */
	public void enterTown() {
		screenHandler.setScreen(ScreenType.TOWN_SCREEN);
	}

	/** Shows screen of game map when exiting town.
	 */
	public void exitTown() {
		screenHandler.setScreen(ScreenType.GAME_SCREEN);
	}

	/** Runs when the game ends.
	 */
	public void end() {
		System.out.println(
			"That's all, folks! (thanks for bearing with us)"
		);
		System.exit(0);
	}

	/** Gets settings.
	 * @return settings
	 */
	public Settings getSettings() {
		return settings;
	}

	/** Gets list of players.
	 * @return list of players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/** Returns round of the game.
	 * @return round of the game
	 */
	public Round getRound() {
		return roundController.getRound();
	}

	/** Returns whether all players config are set.
	 * @return true if all players config are set, false otherwise
	 */
	public boolean allPlayersSet() {
		return settings.allPlayersSet();
	}

	/** Loads a new game.
	 * @param ge game engine connected to the game
	 */
	public void loadNewGame(GameEngine ge) {
		settings 		= ge.settings;
		gameMap 		= ge.gameMap;
		townMap 		= ge.townMap;
		players  		= ge.players;
		roundController = ge.roundController;
		currentScreen  	= ge.currentScreen;

		roundController.setGame(this);
		roundController.round();
	}

	/** Saves the game.
	 * @param filename filename of the game that the game will be saved in
	 */
	public void saveGameFile(String filename) {
		try {
			ObjectOutputStream save =
				new ObjectOutputStream(
					new FileOutputStream(filename));
			save.writeObject(this);
			save.flush();
			save.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Loads saved game.
	 * @param file file that the game will load from
	 */
	public void loadGameFile(File file) {
		try {
			ObjectInputStream load =
				new ObjectInputStream(
					new FileInputStream(file));
			GameEngine game = (GameEngine) load.readObject();
			load.close();
			loadNewGame(game);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Gets the current message being displayed to the user.
	 * @return the current message
	 */
	public Message getMessage() {
		return message;
	}

	/** sets the current message.
	 * @param mess the message to display to user
	 */
	public void setMessage(String mess) {
		this.message.setMessage(mess);
	}
}
