package edu.gatech.mule.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Settings for the game
 * @version 0.1
 */
public class Settings {
	
	public enum Difficulty { BEGINNER, STANDARD, ADVANCED };
	
	public enum MapType { DEFAULT, RANDOM };
	
	public enum Color { 
		PURPLE(145,85,134),
		BLUE(83,99,141), 
		TEAL(66,110,125), 
		SEAFOAM(86,136,126), 
		GREEN(97,149,75), 
		GOLD(143,142,74), 
		ORANGE(157,108,56), 
		MAROON(123,63,59); 
		
		public final int red;
		public final int green;
		public final int blue;
	
		Color(int red,int green,int blue){
			this.red=red;
			this.green=green;
			this.blue=blue;
		}
		
	};
	
	private Difficulty difficulty;
	private MapType mapType;
	private List<Player> players;
	private int playerCount;
	private Player currentPlayer;
	
	/**
	 * Sets up default settings
	 */
	public Settings() {
		players = new ArrayList<Player>();
	}
	
	/**
	 * Get difficulty of game
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
	public MapType getMapType(){
		return mapType;
	}
	
	/**
	 * Set up map type of game
	 * @param type, map type of game
	 */
	public void setMapType(MapType type){
		this.mapType=type;
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
	public void setPlayerCount(int count){
		playerCount=count;
	}
	
	/**
	 * Get number of players in game
	 * @return number of players in game
	 */
	public int getPlayerCount(){
		return playerCount;
	}
	
	/**
	 * Set the current player of the game
	 * @param player, current player of the game
	 */
	public void setCurrentPlayer(Player player){
		currentPlayer = player;
	}
	
	/**
	 * Get the current player of the game
	 * @return current player of the game
	 */
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	/**
	 * Move on to the next player
	 */
	public void nextPlayer(){
		
	}
	
	/**
	 * Gets the iterator of players
	 * @return iterator of players
	 */
	public Iterator<Player> playerIterator() {
		return players.iterator();
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
