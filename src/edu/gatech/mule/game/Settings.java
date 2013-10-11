package edu.gatech.mule.game;

import java.util.*;

public class Settings {
	public enum Difficulty {BEGINNER, STANDARD, ADVANCED};
	public enum MapType {DEFAULT, RANDOM};
	private Difficulty difficulty;
	private MapType mapType;
	private List<CharacterType> players;
	//default to 2 because of simple case
	private int playerCount=2;
	private CharacterType currentPlayer;
	
	public Settings() {
		players = new ArrayList<CharacterType>();
	}
	
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	public MapType getMapType(){
		return mapType;
	}
	
	public void setMapType(MapType type){
		this.mapType=type;
	}
	
	public List<CharacterType> getPlayers() {
		return players;
	}
	public void addPlayer(CharacterType type) {
		players.add(type);
	}
	
	public void updatePlayerCount(int count){
		playerCount=count;
	}
	
	public int getPlayerCount(){
		return playerCount;
	}
	
	public void setCurrentPlayer(CharacterType type){
		currentPlayer=type;
	}
	
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
