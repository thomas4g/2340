package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;
import java.util.ArrayList;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.views.FXMapView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.screen.screens.views.MapView;
import edu.gatech.mule.screen.screens.views.ScreenView;

public class LandSelectController extends ScreenController {
	private Point currentLocation;
	private MapView view;
	
	public LandSelectController(GameEngine game, MapView view) {
		super(game, view);
		this.view = view;
		currentLocation = new Point(0,0);
	}
	
	@Override
	public void load() {
		super.load();
		view.setGameEntities(new ArrayList<Entity>());
		view.setGameMap(game.getGameMap());
	}
	
	public final void move(int x, int y) {
		x = x == 0 ? 0 : x/Math.abs(x);
		y = y == 0 ? 0 : y/Math.abs(y);
		
		currentLocation.translate(x, y);
		
		
		((FXMapView)view).render();
		((FXMapView)view).drawSelector(currentLocation);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
