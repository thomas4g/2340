package edu.gatech.mule.game;

import java.util.*;

public class Settings {
	public enum Difficulty {BEGINNER, INTERMEDIATE,ADVANCED};
	public enum MapType {STANDARD, RANDOM};
	private Difficulty difficulty;
	private MapType type;
	private List<CharacterType> players;
	//default to 2 because of simple case
	int playerCount=2;
	CharacterType currentPlayer;
	
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
		return type;
	}
	
	public void setMapType(MapType type){
		this.type=type;
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

}
