package edu.gatech.mule.core;

import java.util.ArrayList;

import edu.gatech.mule.core.GameEngine.DIFFICULTY;
import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.screen.*;
import edu.gatech.mule.screen.ScreenHandler.Screen;
public class GameEngine {
	
	public enum DIFFICULTY {EASY, MEDIUM, HARD};
	private ScreenHandler screens;
	
	private DIFFICULTY level;
	private ArrayList<CharacterType> players;
	private int numPlayers;
	
	public GameEngine(ScreenHandler screens) {
		this.screens = screens;
		ScreenPresenter.setGame(this);
	}
	
	public void start() {
		screens.setCurrentScreen(Screen.MENU);
	}

	public void setDifficulty(DIFFICULTY level) {
		this.level = level;
	}
	
	public void addPlayer(CharacterType type) {
		players.add(type);
		configurePlayers(numPlayers);
	}
	
	public void configurePlayers(int numPlayers) {
		this.numPlayers = numPlayers;
		if(null == players) players = new ArrayList<CharacterType>();
		if(numPlayers > players.size()) {
			screens.setCurrentScreen(Screen.PLAYER);
		}
		else {
			System.out.println("Your game is: " + level);
			System.out.println("The game has " + numPlayers + " players: ");
			for(CharacterType t : players) {
				System.out.println(t.name());
			}
			//begin gameplay!!
		}
	}
	
}
