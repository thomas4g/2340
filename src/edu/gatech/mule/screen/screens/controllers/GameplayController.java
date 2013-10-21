package edu.gatech.mule.screen.screens.controllers;

import java.util.ArrayList;
import java.util.List;

import tiled.core.Map;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.views.FXMapView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.ScreenView;

public class GameplayController extends ScreenController {

	public final int MOVEMENT = 2;
	private List<Player> players;
	private Player currentPlayer;
	
	protected List<Entity> entities;
	
	public GameplayController(GameEngine game, ScreenView view){
		super(game, view);
		this.entities = new ArrayList<Entity>();
	}
	
	public final void move(int x, int y) {
		if(null == players) {
			players = game.getSettings().getPlayers();
			currentPlayer = players.get(0); 
			entities.add(currentPlayer);
		}
		x = x == 0 ? 0 : x/Math.abs(x);
		y = y == 0 ? 0 : y/Math.abs(y);
		currentPlayer.move(MOVEMENT*x, MOVEMENT*y);
		((FXMapView)view).render();
	}
	
	public Map getGameMap() {
		return game.getGameMap();
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
