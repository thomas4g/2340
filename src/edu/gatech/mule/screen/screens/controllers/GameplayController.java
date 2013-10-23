package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import tiled.core.Map;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.views.FXMapView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.map.TileType;
import edu.gatech.mule.screen.screens.views.MapView;
import edu.gatech.mule.screen.screens.views.ScreenView;

/**
 * Controller for main map screen
 * @version 0.1
 */
public class GameplayController extends ScreenController {

	public final int MOVEMENT = 2;
	
	private MapView view;
	private List<Player> players;
	private Player currentPlayer;
	protected List<Entity> entities;
	
	/**
	 * Constructor for game controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public GameplayController(GameEngine game, MapView view){
		super(game, view);
		this.view = view;
		this.entities = new ArrayList<Entity>();
	}
	
	@Override
	public void load() {
		super.load();
		view.setGameEntities(entities);
		view.setGameMap(game.getGameMap());
	}
	
	/**
	 * Moves player around the main map
	 */
	public final void move(int x, int y) {
		if(null == players) {
			players = game.getSettings().getPlayers();
			currentPlayer = players.get(0); 
			entities.add(currentPlayer);
			view.setGameEntities(entities);
		}
		x = x == 0 ? 0 : x/Math.abs(x);
		y = y == 0 ? 0 : y/Math.abs(y);
		currentPlayer.move(MOVEMENT*x, MOVEMENT*y);
		currentPlayer.setTile(game.getGameMap());
		if(currentPlayer.getTileType().equals(TileType.ENTERTOWN)){
			game.enterTown();
			currentPlayer.setPosition(new Point(40,180));
		}
	

		((FXMapView)view).render();
	}
	
	@Override
	public void done() {
	}
	
}
