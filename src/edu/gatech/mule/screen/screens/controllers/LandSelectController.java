package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;
import java.util.ArrayList;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.views.FXMapView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.screen.screens.views.MapView;


/**
 * Controls the land selection phase
 * @author Thomas Shields
 * @version 1.0
 */
public class LandSelectController extends ScreenController {
	private final static int FREE_ROUNDS = 2;
	
	private Point location;
	private MapView view;
	private GameMap map;
	
	private int currentPlayer;
	private int round = 1;
	
	public LandSelectController(GameEngine game, MapView view) {
		super(game, view);
		this.view = view;
		location = new Point(0,0);
	}
	
	@Override
	public void load() {
		super.load();
		map = game.getGameMap();
		view.setGameEntities(new ArrayList<Entity>());
		view.setGameMap(map);
		setPlayer();
	}
	
	@Override
	public final void move(int x, int y) {

		x = x == 0 ? 0 : x / Math.abs(x);
		y = y == 0 ? 0 : y / Math.abs(y);
		location.translate(x, y);
		((FXMapView) view).render();
		((FXMapView) view).drawSelector(location,game.getPlayers().get(currentPlayer).getColor());
	}

	@Override
	public void action(){		
		game.getPlayers().get(currentPlayer).addLand(map.getTile(location.x, location.y));
		currentPlayer++;
		if(currentPlayer >= game.getPlayers().size()) {
			round++;
			currentPlayer = 0;
		}
		setPlayer();
		
		if(round > FREE_ROUNDS) {
			//for now, we're just moving straight to gameplay
			//TODO implement paid land buying and a timer to detect a "pass"
			game.gameplay();
		}
	}

	private void setPlayer() {
		view.setCurrentPlayer(game.getPlayers().get(currentPlayer));
	}


	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}
}
