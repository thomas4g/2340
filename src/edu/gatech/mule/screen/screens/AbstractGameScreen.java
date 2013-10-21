package edu.gatech.mule.screen.screens;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;

public abstract class AbstractGameScreen implements IScreen {

	public final int MOVEMENT = 5;
	protected GameEngine game;
	protected Settings settings;
	private List<Player> players;
	private Player currentPlayer;
	
	protected List<Entity> entities;
	
	public AbstractGameScreen(GameEngine game){
		this.game = game;
		this.settings = game.getSettings();
		this.entities = new ArrayList<Entity>();
	}
	
	public final void done() {
		//do stuff
	}
	
	public final void move(int x, int y) {
		if(null == players) {
			players = settings.getPlayers();
			currentPlayer = players.get(0); 
			entities.add(currentPlayer);
		}
		x = x == 0 ? 0 : x/Math.abs(x);
		y = y == 0 ? 0 : y/Math.abs(y);
		currentPlayer.move(MOVEMENT*x, MOVEMENT*y);
		render();
	}
	
	public abstract void render();
	//TODO add all the map stuff here later
	
}
