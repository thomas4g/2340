package edu.gatech.mule.screen.views;

import java.awt.Point;
import java.util.List;

import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Message;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.map.maps.GameMap;

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
	public void setMessage(Message message);
	public void render();
}
