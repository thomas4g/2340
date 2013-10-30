package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.screen.screens.views.MapView;

/**
 * Controller for town map
 * @version 0.1
 */
public class TownController extends ScreenController {
	
	public final int MOVEMENT = 2;
	
	private MapView view;
	private List<Entity> entities;
	
	/**
	 * Constructor for town controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public TownController(GameEngine game, MapView view){
		super(game, view);
		this.view = view;
		this.entities = new ArrayList<>();
	}
	
	@Override
	public void load() {
		super.load();
		view.setGameMap(game.getTownMap());
		view.setGameEntities(entities);
	}
	
	/**
	 * Moves player around the town map
	 */
	public final void move(int x, int y) {
		x = x == 0 ? 0 : x/Math.abs(x);
		y = y == 0 ? 0 : y/Math.abs(y);
		Player currentPlayer = game.getCurrentPlayer();
		currentPlayer.move(MOVEMENT*x, MOVEMENT*y);

		if(currentPlayer.getPosition().getX()<0){
			//hard coded position I know :( I'll fix it later
			game.exitTown();
			currentPlayer.setPosition(new Point(290, 180));
		}
		if(currentPlayer.getPosition().getX()>view.getGameMap().getMap().getLayer(0).getWidth()*107){
			game.exitTown();
			currentPlayer.setPosition(new Point(400,180));
		}
	}
	
	@Override
	public void done() {

	}

}
