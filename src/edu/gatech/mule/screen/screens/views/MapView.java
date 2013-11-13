package edu.gatech.mule.screen.screens.views;

import java.awt.Point;
import java.util.Iterator;
import java.util.List;

import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.map.maps.GameMap;
import edu.gatech.mule.game.player.Player;

/**
 * Map view
 * @version 0.1
 */
public interface MapView extends ScreenView {
	public void setGameMap(GameMap gameMap);
	public GameMap getGameMap();
	public void setGameEntities(List<Entity> gameEntities);
	public void setCurrentPlayer(Player player);
	public void setPlayers(List<Player> players);
	public void setSelector(Point location);
	public void render();
}
