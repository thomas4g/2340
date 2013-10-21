package edu.gatech.mule.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Settings for the game
 * 
 * @version 1.0
 *
 */
public class Settings {
	
	/**
	 * Difficulty of the game
	 */
	public enum Difficulty { BEGINNER, STANDARD, ADVANCED };
	public enum MapType { DEFAULT, RANDOM };
	public enum Color { PURPLE, BLUE, TEAL, SEAFOAM, GREEN, GOLD, ORANGE, MAROON };
	
	/**
	 * Map type
	 * 
	 * Default is a predefined map
	 * Random is a randomly-generated map
	 */
	
	private Difficulty difficulty;
	private MapType mapType;
	private List<Player> players;
	private int playerCount;
	private int currentPlayer;
	private boolean playersLoaded;
	
	/**
	 * Sets up default settings
	 */
	public Settings() {
		players = new ArrayList<Player>();
		currentPlayer=0;
		playersLoaded=false;
	}
	
	/**
	 * Get the difficulty of the game
	 * 
	 * @return difficulty of the game
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Set the difficulty of the game
	 * 
	 * @param difficulty, difficulty of the game
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	/**
	 * Get the map type of the game
	 * 
	 * @return map type of the game
	 */
	public MapType getMapType(){
		return mapType;
	}
	
	/**
	 * Set the map type of the game
	 * 
	 * @param type, map type of the game
	 */
	public void setMapType(MapType type){
		this.mapType=type;
	}
	
	/**
	 * Get the list of players in the game
	 * 
	 * @param list of players in the game
	 */
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Adds a player in the game
	 * 
	 * @param type, a character type
	 */
	public void addPlayer(Player player) {
		System.out.println(currentPlayer);
		players.add(player);
	}
	
	/**
	 * ???
	 */
	public void setPlayerCount(int count){
		playerCount=count;
	}
	
	/**
	 * ???
	 */
	public int getPlayerCount(){
		return playerCount;
	}
	
	/**
	 * ???
	 */
	public void setCurrentPlayer(int playerIndex){
		currentPlayer=playerIndex;
	}
	
	/**
	 * ???
	 */
	public Player getCurrentPlayer(){
		return players.get(currentPlayer);
	}
	
	public void nextPlayer(){
		currentPlayer++;
		if(currentPlayer>=playerCount) {
			System.out.println("max players");
			playersLoaded=true;
		}
	}
	
	public void resetPlayers(){
		playersLoaded=false;
		currentPlayer=0;
	}
	
	public boolean playersLoaded(){
		return playersLoaded;
	}
	
	/**
	 * Print settings for debugging purposes
	 */
	public void printSettings() {
		System.out.println("Players: " + playerCount + ", Difficulty: " + difficulty + ", MapType: " + mapType);
		for(int i=0; i<players.size(); i++) {
			Player p = players.get(i);
			System.out.println("Player " + i + ": " + p.getType() + ", " + p.getName() + ", " + p.getColor());
		}
	}
}
