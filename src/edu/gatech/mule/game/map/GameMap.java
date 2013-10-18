package edu.gatech.mule.game.map;

import tiled.core.Map;

/**
 * 
 * General set up for a map
 * 
 * @version 1.0
 *
 */
public abstract class GameMap {

	protected GameTile[][] tiles;
	protected Map map;
	
	/**
	 * Constructor for the map
	 */
	public GameMap() {
		generateMap();
	}
	
	/**
	 * Gets the tiles in the map
	 * 
	 * @return the array of tiles
	 */
	public GameTile[][] getTiles() {
		return tiles;
	}
	
	public Map getMap() {
		return map;
	}
	
	/**
	 * Generates map based on specifications
	 */
	protected abstract void generateMap();
	
}
