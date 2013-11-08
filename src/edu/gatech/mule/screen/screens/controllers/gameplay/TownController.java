package edu.gatech.mule.screen.screens.controllers.gameplay;

import java.awt.Point;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.map.TileType;
import edu.gatech.mule.screen.screens.views.MapView;

/**
 * Controller for town map
 * @version 0.1
 */
public class TownController extends MapController {
	
	public final int MOVEMENT = 20;
	
	/**
	 * Constructor for town controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public TownController(GameEngine game, MapView view){
		super(game, view);
	}
	
	@Override
	public void load() {
		super.load();
		view.setGameMap(game.getTownMap());
		currentPlayer.useBigSprites(true);
	}
	
	/**
	 * Moves player around the town map
	 */
	public final void move(int x, int y) {
		x = x == 0 ? 0 : x/Math.abs(x);
		y = y == 0 ? 0 : y/Math.abs(y);
		Player currentPlayer = turn.getPlayer();
		currentPlayer.move(MOVEMENT*x, MOVEMENT*y);
		currentPlayer.setTile(game.getTownMap());

		System.out.println(currentPlayer.getTileType());
		if(currentPlayer.getTileType() == TileType.PUB) {
			done();
		}
		
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
		turn.done();
	}

}
