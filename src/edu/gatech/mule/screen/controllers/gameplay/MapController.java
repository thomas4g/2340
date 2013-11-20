package edu.gatech.mule.screen.controllers.gameplay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.round.Turn;
import edu.gatech.mule.map.maps.GameMap;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.MapView;

/**
 * Super-class for any controller using the map and doing movement.
 * @author tshields
 *
 */
public abstract class MapController extends ScreenController {

	protected GameMap map;
	protected MapView view;
	protected List<Entity> entities;
	protected Turn turn;
	protected Player currentPlayer;
	protected Iterator<Player> players;
	protected int moveRate;
	protected Mule mule;

	/**
	 * Creates a MapController.
	 * @param game the game this controller uses
	 * @param view the view this controller is linked to
	 * @param moveRate moving rate for this map controller. This is the rate
	 * the things move on the map.
	 */
	public MapController(GameEngine game, MapView view, int moveRate) {
		super(game, view);
		this.view = view;
		this.entities = new ArrayList<Entity>();
		this.moveRate = moveRate;
	}

	@Override
	public void load() {
		super.load();
		turn = game.getRound().getTurn();
		currentPlayer = turn.getPlayer();
		entities.clear();
		entities.add(currentPlayer);

		if(currentPlayer.hasMule()) {
			mule = currentPlayer.getMule();
			entities.add(mule);
		}

		view.setGameMap(map);
		view.setGameEntities(entities);
		view.setCurrentPlayer(currentPlayer);
		view.setPlayers(game.getSettings().getPlayers());
		view.setMessage(game.getMessage());
	}

	@Override
	public void move(int x, int y) {
		x = x == 0 ? 0 : x / Math.abs(x);
		y = y == 0 ? 0 : y / Math.abs(y);

		currentPlayer.move(moveRate * x, moveRate * y);

		if(currentPlayer.hasMule()) {
			mule.move();
		}

		int xTilePos = (int) (currentPlayer.getPosition().x / map.getTileWidth());
		int yTilePos = (int) (currentPlayer.getPosition().y / map.getTileHeight());

		GameTile newTile = map.getTile(xTilePos, yTilePos);

		if(!newTile.equals(currentPlayer.getTile())) {
			if(currentPlayer.getTile() != null) {
				currentPlayer.getTile().exit(currentPlayer);
			}
			newTile.enter(currentPlayer);
		}
		currentPlayer.setTile(newTile);
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub

	}

}
