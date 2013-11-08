package edu.gatech.mule.screen.screens.controllers.gameplay;

import java.awt.Point;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.map.TileType;
import edu.gatech.mule.screen.screens.views.MapView;

/**
 * Controller for main map screen
 * @version 0.1
 */
public class GameplayController extends MapController {

	public final int MOVEMENT = 5;
	
	/**
	 * Constructor for game controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public GameplayController(GameEngine game, MapView view) {
		super(game, view);
	}
	
	@Override
	public void load() {
		super.load();
		view.setGameMap(game.getGameMap());
		currentPlayer.useBigSprites(false);
		view.setCurrentPlayer(currentPlayer);
	}
		
	
	/**
	 * Moves player around the main map
	 */
	public final void move(int x, int y) {
		x = x == 0 ? 0 : x/Math.abs(x);
		y = y == 0 ? 0 : y/Math.abs(y);
		
		currentPlayer.move(MOVEMENT*x, MOVEMENT*y);
		currentPlayer.setTile(game.getGameMap());

		if(currentPlayer.getTileType().equals(TileType.ENTERTOWN)){
			//Nasty hardcode still but it works until the tiles are being 
			game.enterTown();
			if(currentPlayer.getPosition().getX()>395 && currentPlayer.getPosition().getX()<400){
				currentPlayer.setPosition(new Point(530,180));
			} else {
				currentPlayer.setPosition(new Point(40,180));
			}


		}
	}

	@Override
	public void done() {

	}
	
}
