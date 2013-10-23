package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.views.FXMapView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.screen.screens.views.MapView;

public class TownController extends ScreenController {
	
	public final int MOVEMENT = 2;
	
	private MapView view;
	private List<Player> players;
	private Player currentPlayer;
	protected List<Entity> entities;
	
	public TownController(GameEngine game, MapView view){
		super(game, view);
		this.view = view;
		this.entities = new ArrayList<Entity>();
	}
	
	@Override
	public void load() {
		super.load();
		view.setGameEntities(entities);
		view.setGameMap(game.getTownMap());
	}
	
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
		System.out.println("X: "+currentPlayer.getPosition().getX()+" Y: "+currentPlayer.getPosition().getX());
		if(currentPlayer.getPosition().getX()<0){
			//hard coded position I know :( I'll fix it later
			game.exitTown();
			currentPlayer.setPosition(new Point(290, 180));
		}
		if(currentPlayer.getPosition().getX()>view.getGameMap().getMap().getLayer(0).getWidth()*107){
			game.exitTown();
			currentPlayer.setPosition(new Point(400,180));
		}
		view.render();
	}
	

	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}

}
