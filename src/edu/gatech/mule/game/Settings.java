package edu.gatech.mule.game;

import java.util.*;

public class Settings {
	public enum Difficulty {BEGINNER, STANDARD};
	private Difficulty difficulty;
	private List<CharacterType> players;
	
	public Settings() {
		players = new ArrayList<CharacterType>();
	}
	
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	public List<CharacterType> getPlayers() {
		return players;
	}
	public void addPlayer(CharacterType type) {
		players.add(type);
	}
	

}
