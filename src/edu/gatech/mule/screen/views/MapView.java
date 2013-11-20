package edu.gatech.mule.screen.views;

import java.awt.Point;
import java.util.List;

import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Message;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.map.maps.GameMap;

/**
 * Set up for map view.
 * @version 1.0
 */
public interface MapView extends ScreenView {

	/**
	 * Sets up the game map.
	 * @param gameMap model representative of map
	 */
	void setGameMap(GameMap gameMap);

	/**
	 * Returns the game map.
	 * @return the game map
	 */
	GameMap getGameMap();

	/**
	 * Sets the game entities.
	 * @param gameEntities entities in the game
	 */
	void setGameEntities(List<Entity> gameEntities);

	/**
	 * Sets the current player.
	 * @param player the current player
	 */
	void setCurrentPlayer(Player player);

	/**
	 * Sets the players in the game.
	 * @param players players in the game
	 */
	void setPlayers(List<Player> players);

	/**
	 * Sets the selector for land select.
	 * @param location the location of the selector
	 */
	void setSelector(Point location);

	/**
	 * Sets a message for random events or other notices.
	 * @param message to be displayed
	 */
	void setMessage(Message message);

	/**
	 * Renders images onto map.
	 */
	void render();

}
