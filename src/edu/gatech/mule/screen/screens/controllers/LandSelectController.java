package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	private Point location;
	private MapView view;
	private GameMap map;
	private Settings settings;
	private Player current;
	private Iterator<Player> iterator;
	
	public LandSelectController(GameEngine game, MapView view) {
		super(game, view);
		this.view = view;
		location = new Point(0,0);
		settings=game.getSettings();
	}
	
	@Override
	public void load() {
		super.load();
		map = game.getGameMap();
		view.setGameEntities(new ArrayList<Entity>());
		view.setGameMap(map);
		iterator = settings.playerIterator();
		current = iterator.next();
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
	public void done() {
		game.gameplay();
	}
	
	@Override
	public void action() {
		System.out.println(map.getTiles()[location.x][location.y]);
		current.addLand(map.getTile(location.x, location.y));
		if(iterator.hasNext()) {
			current = iterator.next();
		} else {
			done();
		}
	}

}
