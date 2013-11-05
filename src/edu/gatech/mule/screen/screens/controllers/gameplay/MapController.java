package edu.gatech.mule.screen.screens.controllers.gameplay;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Turn;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.MapView;
import edu.gatech.mule.screen.screens.views.ScreenView;

public abstract class MapController extends ScreenController {

	protected MapView view;
	protected List<Entity> entities;
	protected Turn turn;
	protected Player currentPlayer;
		
	public MapController(GameEngine game, MapView view) {
		super(game, view);
		this.view = view;
		this.entities = new ArrayList<Entity>();
	}
	
	@Override
	public void load() {
		super.load();
		
		turn = game.getRound().getTurn();
		currentPlayer = turn.getPlayer();
		
		entities.clear();
		entities.add(currentPlayer);
		
		view.setGameEntities(entities);
		view.setCurrentPlayer(currentPlayer);
	}
	@Override
	public void done() {
		// TODO Auto-generated method stub

	}

}
