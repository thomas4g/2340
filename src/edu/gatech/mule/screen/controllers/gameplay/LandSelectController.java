package edu.gatech.mule.screen.controllers.gameplay;

import java.awt.Point;
import java.util.ArrayList;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.map.maps.GameMap;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.MapView;

/**
 * Controller for land selection.
 * @version 0.1
 */
public class LandSelectController extends ScreenController {
	private static final int FREE_ROUNDS = 2;
	private Point location;
	private MapView view;
	private GameMap map;
	private int currentPlayer;
	private int round = 1;
	private boolean skipped;

	/**
	 * Constructor for land selection controller.
	 * @param game game engine
	 * @param view map view
	 */
	public LandSelectController(GameEngine game, MapView view) {
		super(game, view);
		this.view = view;
		this.location = new Point(0, 0);
		this.round = 1;
	}

	@Override
	public void load() {
		super.load();
		map = game.getGameMap();
		// empty because land select needs to clear the view's entities
		// but it doesn't actually use entities itself
		view.setGameEntities(new ArrayList<Entity>());
		view.setGameMap(map);
		setPlayer();
		view.setPlayers(game.getSettings().getPlayers());
	}

	@Override
	public final void move(int x, int y) {
		x = (x == 0) ? 0 : x / Math.abs(x);
		y = (y == 0) ? 0 : y / Math.abs(y);
		x = (location.x + x >= map.getWidth()) ? 0 : x;
		y = (location.y + y >= map.getHeight()) ? 0 : y;
		x = (location.x + x < 0) ? 0 : x;
		y = (location.y + y < 0) ? 0 : y;
		location.translate(x, y);
		view.setSelector(location);
	}

	@Override
	public void action() {
		GameTile tile = map.getTile(location.x, location.y);
		if(tile.getOwner() == null) {
			if(game.getPlayers().get(currentPlayer).addLand(tile, round <= FREE_ROUNDS)) {
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
					game.getRound().turn();
				} else {
					skipped = false;
				}
			}
		}
		setPlayer();
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
