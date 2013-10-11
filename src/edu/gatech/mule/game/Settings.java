package edu.gatech.mule.game;

import java.util.*;

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
	public enum Difficulty {BEGINNER, STANDARD, ADVANCED};
	
	/**
	 * Map type
	 * 
	 * Default is a predefined map
	 * Random is a randomly-generated map
	 */
	public enum MapType {DEFAULT, RANDOM};
	
	private Difficulty difficulty;
	private MapType mapType;
	private List<CharacterType> players;
	private int playerCount;
	private CharacterType currentPlayer;
	
	/**
	 * Sets up default settings
	 */
	public Settings() {
		players = new ArrayList<CharacterType>();
		playerCount = 2;  // default value is 2
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
	public List<CharacterType> getPlayers() {
		return players;
	}
	
	/**
	 * Adds a player in the game
	 * 
	 * @param type, a character type
	 */
	public void addPlayer(CharacterType type) {
		players.add(type);
	}
	
	/**
	 * ???
	 */
	public void updatePlayerCount(int count){
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
	public void setCurrentPlayer(CharacterType type){
		currentPlayer=type;
	}
	
	/**
	 * ???
	 */
	public CharacterType getCurrentPlayer(){
		return currentPlayer;
	}
	
	/**
	 * Print settings for debugging purposes
	 */
	public void printSettings() {
		System.out.println("Players: " + playerCount + ", Difficulty: " + difficulty + ", MapType: " + mapType);
		for(int i=0; i<players.size(); i++) {
			System.out.println("Player " + i + ": " + players.get(i));
		}
	}
}
