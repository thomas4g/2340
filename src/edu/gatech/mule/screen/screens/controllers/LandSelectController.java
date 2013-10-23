package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.views.FXMapView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.screen.screens.views.MapView;

/**
 * Controller for land selection
 * @version 0.1
 */
public class LandSelectController extends ScreenController {
	private final static int FREE_ROUNDS = 2;
	
	private Point location;
	private MapView view;
	private GameMap map;
	
	private int currentPlayer;
	private int round = 1;
	private boolean skipped = false;
	
	/**
	 * Constructor for land selection controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public LandSelectController(GameEngine game, MapView view) {
		super(game,view);
		this.view = view;
		location = new Point(0,0);
		round = 1;
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
		x = location.x + x >= game.getGameMap().getTiles().length ? 0 : x;
		y = location.y + y >= game.getGameMap().getTiles()[0].length ? 0 : y;
		x = location.x + x < 0 ? 0 : x;
		y = location.y + y < 0 ? 0 : y;
		location.translate(x, y);
		view.setSelector(location);
		view.render();
	}

	@Override
	public void action(){	
		GameTile tile = map.getTile(location.x, location.y);
		if(tile.getOwner() == null) {
			if(game.getPlayers().get(currentPlayer).addLand(tile, round <= FREE_ROUNDS)) {
				view.render();
				skipped = false;
				nextPlayer();
			}
		}
	}
	
	private void nextPlayer() {
		currentPlayer++;
		if(currentPlayer >= game.getPlayers().size()) {
			round++;
			currentPlayer = 0;
			if(round > FREE_ROUNDS) {
				if(skipped) {
					view.setSelector(null);
					game.gameplay();
				}
				else {
					skipped = false;
				}
			}
		}
		setPlayer();
		view.render();
	}
	
	private void setPlayer() {
		view.setCurrentPlayer(game.getPlayers().get(currentPlayer));
	}

	@Override
	public void done() {
		skipped = true;
		nextPlayer();
	}
}
