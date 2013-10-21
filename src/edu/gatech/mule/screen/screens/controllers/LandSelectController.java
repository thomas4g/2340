package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;
import java.util.ArrayList;
import tiled.core.Tile;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.views.FXMapView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings;
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
	private int round;
	
	public LandSelectController(GameEngine game, MapView view) {
		super(game, view);
		this.view = view;
		location = new Point(0,0);
	}
	
	@Override
	public void load() {
		super.load();
		map=game.getGameMap();
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
		((FXMapView) view).drawSelector(location);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public void action(){
		if(round > FREE_ROUNDS) {
			//for now, we're just moving straight to gameplay
			//TODO implement paid land buying and a timer to detect a "pass"
			game.gameplay();
		}
		else {
			game.getPlayers().get(currentPlayer).addLand(map.getTile(location.x, location.y));
			currentPlayer = ++currentPlayer % game.getPlayers().size();
			setPlayer();
			round++;
		}
	}
	
	private void setPlayer() {
		view.setCurrentPlayer(game.getPlayers().get(currentPlayer));
	}
	
	private void printPlayerStuff(){
		for(Player p: game.getPlayers()){
			for(Tile t: p.getLands()){
				System.out.println(t);
			}
		}
	}

}
