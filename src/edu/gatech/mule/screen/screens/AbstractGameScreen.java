package edu.gatech.mule.screen.screens;

import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;

public abstract class AbstractGameScreen implements IScreen {

	protected GameEngine game;
	protected Settings settings;
	private List<Player> players;
	protected Player currentPlayer;
	
	public AbstractGameScreen(GameEngine game){
		this.game = game;
		this.settings = game.getSettings();
	}
	
	public final void done() {
		//do stuff
	}
	
	public final void move(int x, int y) {
		if(null == players) {
			players = settings.getPlayers();
			currentPlayer = players.get(0); 
		}
		x = x == 0 ? 0 : x/x;
		y = y == 0 ? 0 : y/y;
		currentPlayer.move(25*x, 25*y);
		System.out.println("moving player");
	}
	
	public abstract void render();
	//TODO add all the map stuff here later
	
}
