package edu.gatech.mule.screen.screens.views;

import java.util.List;

import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.map.GameMap;
import tiled.core.Map;

public interface MapView extends ScreenView {
	public void setGameMap(GameMap gameMap);
	public void setGameEntities(List<Entity> gameEntities);
}
