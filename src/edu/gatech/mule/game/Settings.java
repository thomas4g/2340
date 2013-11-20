package edu.gatech.mule.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.gatech.mule.game.player.Color;
import edu.gatech.mule.game.player.Difficulty;
import edu.gatech.mule.game.player.Player;

/**
 * Settings for the game.
 * @version 1.0
 */
public class Settings implements Serializable {

	/**
	 * Yay serial.
	 */
	private static final long serialVersionUID = -5562661244863136965L;

	/**
	 * Enum for map type.
	 */
	public enum MapType { DEFAULT, RANDOM };

	private Difficulty difficulty;
	private MapType mapType;
	private List<Player> players;
	private int playerCount;
	private Player currentPlayer;
	private int playerIndex;
	private ArrayList<Color> colorsUsed;

	/**
	 * Sets up default settings.
	 */
	public Settings() {
		players = new ArrayList<Player>();
		playerIndex = 1;
		colorsUsed = new ArrayList<>();
	}

	/**
	 * get difficulty of game.
	 * @return difficulty of game
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}

	/**
	 * Set up difficulty of game.
	 * @param difficulty of game
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Get map type of game.
	 * @return map type of game
	 */
	public MapType getMapType() {
		return mapType;
	}

	/**
	 * Set up map type of game.
	 * @param type map type of game
	 */
	public void setMapType(MapType type) {
		this.mapType = type;
	}

	/**
	 * Get list of players in game.
	 * @return list of players in game
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Adds a player into the game.
	 * @param player player in the game
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}

	/**
	 * Set the count of number of players.
	 * @param count number of players
	 */
	public void setPlayerCount(int count) {
        playerCount = count;
	}

	/**
	 * Get number of players in game.
	 * @return number of players in game
	 */
	public int getPlayerCount() {
		return playerCount;
	}

	/**
	 * Set the current player of the game.
	 * @param player current player of the game
	 */
	public void setCurrentPlayer(Player player) {
		currentPlayer = player;
	}

	/**
	 * Get the current player of the game.
	 * @return current player of the game
	 */
	private Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Get current player's name.
	 * @return current player's name
	 */
	public String getCurrentPlayerName() {
		return getCurrentPlayer().getName();
	}

	/**
	 * Get current player's default name.
	 * @return current player's default name
	 */
	public String getCurrentPlayerDefaultName() {
		return getCurrentPlayer().getType().getName();
	}

	/**
	 * Sets current player's name.
	 * @param name current player's name
	 */
	public void setCurrentPlayerName(String name) {
		getCurrentPlayer().setName(name);
	}

	/**
	 * Get current player's color.
	 * @return current player's color
	 */
	public int getCurrentPlayerColor() {
		return getCurrentPlayer().getColor().ordinal() + 1;
	}

	/**
	 * Set current player's color.
	 * @param color current player's color
	 */
	public void setCurrentPlayerColor(Color color) {
		getCurrentPlayer().setColor(color);
	}

	/**
	 * Get current player's headshot with a color.
	 * @param color of headshot to be seen
	 * @return headshot with requested color
	 */
	public String getCurrentPlayerHeadshot(int color) {
		return getCurrentPlayer().getType().getHeadshot(color);
	}

	/**
	 * Get current player's headshot with corresponding color.
	 * @return current player's headshot with corresponding color
	 */
	public String getCurrentPlayerHeadshot() {
		return this.getCurrentPlayerHeadshot(getCurrentPlayerColor());
	}

	/**
	 * Returns whether all player config is done.
	 * @return true if all player config done, false otherwise
	 */
	public boolean allPlayersSet() {
		return getPlayerCount() == getPlayers().size();
	}

	/**
	 * Moves to next player.
	 */
	public void nextPlayer() {
		playerIndex++;
	}

	/**
	 * Get player index.
	 * @return player index.
	 */
	public int getPlayerIndex() {
		return playerIndex;
	}

	/**
	 * Gets the iterator of players.
	 * @return iterator of players
	 */
	public Iterator<Player> playerIterator() {
		return players.iterator();
	}

	/**
	 * Add a color to list of colors used.
	 * @param color color selected
	 */
	public void addColor(Color color) {
		colorsUsed.add(color);
	}

	/**
	 * Find whether a color has already been selected.
	 * @param color that may or may not have been used
	 * @return true if color already selected, false otherwise
	 */
	public boolean colorUsed(int color) {
		for(Color c : colorsUsed) {
			if((c.ordinal() + 1) == color) {
				return true;
			}
		}
		return false;
	}
}
