package edu.gatech.mule.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.gatech.mule.game.player.Color;
import edu.gatech.mule.game.player.Difficulty;
import edu.gatech.mule.game.player.Player;

/**
 * Settings for the game
 * @version 0.1
 */
public class Settings implements Serializable {

	public enum MapType { DEFAULT, RANDOM };
	
	private Difficulty difficulty;
	private MapType mapType;
	private List<Player> players;
	private int playerCount;
	private Player currentPlayer;
	private int playerIndex;
	
	private ArrayList<Color> colorsUsed;
	
	/**
	 * Sets up default settings
	 */
	public Settings() {
		players = new ArrayList<Player>();
		playerIndex = 1;
		colorsUsed = new ArrayList<>();
	}
	
	/**
	 * get difficulty of game
	 * @return difficulty of game
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Set up difficulty of game
	 * @param difficulty, difficulty of game
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	/**
	 * Get map type of game
	 * @return map type of game
	 */
	public MapType getMapType() {
		return mapType;
	}
	
	/**
	 * Set up map type of game
	 * @param type, map type of game
	 */
	public void setMapType(MapType type) {
		this.mapType = type;
	}
	
	/**
	 * Get list of players in game
	 * @return list of players in game
	 */
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Adds a player into the game
	 * @param player, player in the game
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	/**
	 * Set the count of number of players
	 * @param count, number of players
	 */
	public void setPlayerCount(int count) {
        playerCount = count;
	}
	
	/**
	 * Get number of players in game
	 * @return number of players in game
	 */
	public int getPlayerCount() {
		return playerCount;
	}
	
	/**
	 * Set the current player of the game
	 * @param player, current player of the game
	 */
	public void setCurrentPlayer(Player player) {
		currentPlayer = player;
	}
	
	/**
	 * Get the current player of the game
	 * @return current player of the game
	 */
	private Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public String getCurrentPlayerName() {
		return getCurrentPlayer().getName();
	}
	
	public String getCurrentPlayerDefaultName() {
		return getCurrentPlayer().getType().getName();
	}
	
	public void setCurrentPlayerName(String name) {
		getCurrentPlayer().setName(name);
	}
	
	public int getCurrentPlayerColor() {
		return getCurrentPlayer().getColor().ordinal()+1;
	}
	
	public void setCurrentPlayerColor(Color color) {
		getCurrentPlayer().setColor(color);
	}
	
	public String getCurrentPlayerHeadshot(int color) {
		return getCurrentPlayer().getType().getHeadshot(color);
	}
	
	public String getCurrentPlayerHeadshot() {
		return this.getCurrentPlayerHeadshot(getCurrentPlayerColor());
	}
	
	public boolean allPlayersSet() {
		return getPlayerCount() == getPlayers().size();
	}
	
	public void nextPlayer(){
		playerIndex++;
	}
	
	public int getPlayerIndex(){
		return playerIndex;
	}
	
	/**
	 * Gets the iterator of players
	 * @return iterator of players
	 */
	public Iterator<Player> playerIterator() {
		return players.iterator();
	}
	
	public void addColor(Color color) {
		colorsUsed.add(color);
	}
	
	public boolean colorUsed(int color) {
		for(Color c : colorsUsed) {
			if((c.ordinal()+1) == color) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Print settings (for debugging purposes)
	 */
	public void printSettings() {
		System.out.println("Players: " + playerCount + ", Difficulty: " + difficulty + ", MapType: " + mapType);
		for(int i=0; i<players.size(); i++) {
			Player p = players.get(i);
			System.out.println("Player " + i + ": " + p.getType() + ", " + p.getName() + ", " + p.getColor());
		}
	}
}
