package edu.gatech.mule.screen.screens.controllers.gameplay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.round.Turn;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.MapView;

public abstract class MapController extends ScreenController {

	protected GameMap map;
	protected MapView view;
	protected List<Entity> entities;
	protected Turn turn;
	protected Player currentPlayer;
	protected Iterator<Player> players;
	protected int moveRate;
		
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
//		currentPlayer.setMule(new Mule(currentPlayer, CharacterType.MULE));
		entities.add(currentPlayer);
		
		if(currentPlayer.getMule() != null)
			entities.add(currentPlayer.getMule());
		
		view.setGameMap(map);
		view.setGameEntities(entities);
		view.setCurrentPlayer(currentPlayer);
		view.setPlayers(game.getSettings().getPlayers());
	}

	
	public void move(int x, int y) {
		x = x == 0 ? 0 : x/Math.abs(x);
		y = y == 0 ? 0 : y/Math.abs(y);
		
		currentPlayer.move(moveRate*x, moveRate*y);
		
		if(currentPlayer.getMule() != null) {
			currentPlayer.getMule().move();
		}	
		
		int xTilePos=(int)(currentPlayer.getPosition().x/map.getTileWidth());
		int yTilePos=(int)(currentPlayer.getPosition().y/map.getTileHeight());
		
		GameTile newTile = map.getTile(xTilePos, yTilePos);
		
		if(!newTile.equals(currentPlayer.getTile())) {
			if(currentPlayer.getTile() != null)
				currentPlayer.getTile().exit(currentPlayer);
			newTile.enter(currentPlayer);
		}
		currentPlayer.setTile(newTile);
	}
	
	
	@Override
	public void done() {
		// TODO Auto-generated method stub

	}

}
