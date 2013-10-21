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
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
import edu.gatech.mule.screen.screens.views.MapView;
import edu.gatech.mule.screen.screens.views.ScreenView;

public class LandSelectController extends ScreenController {
	private Point location;
	private MapView view;
	private GameMap map;
	private Settings settings;
	
	public LandSelectController(GameEngine game, MapView view) {
		super(game, view);
		this.view = view;
		location = new Point(0,0);
		map=game.getGameMap();
		settings=game.getSettings();
	}
	
	@Override
	public void load() {
		super.load();
		view.setGameEntities(new ArrayList<Entity>());
		view.setGameMap(game.getGameMap());
		settings.resetPlayers();
	}
	
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
	
	private void nextPlayer(){
		game.getSettings().nextPlayer();
	}
	
	public void updateSelection(){
		settings.getCurrentPlayer().addLand(map.getTile(location.x, location.y));
		nextPlayer();
	}
	
	private void printPlayerStuff(){
		for(Player p: settings.getPlayers()){
			for(Tile t: p.getLands()){
				System.out.println(t);
			}
		}
	}

}
