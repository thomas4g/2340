package edu.gatech.mule.game;

import java.util.*;

public class Settings {
	public enum DIFFICULTY {EASY, MEDIUM, HARD};
	private DIFFICULTY difficulty;
	private List<CharacterType> players;
	
	public Settings() {
		players = new ArrayList<CharacterType>();
	}
	
	public DIFFICULTY getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(DIFFICULTY difficulty) {
		this.difficulty = difficulty;
	}
	
	public List<CharacterType> getPlayers() {
		return players;
	}
	public void addPlayer(CharacterType type) {
		players.add(type);
	}
	

}
