package edu.gatech.mule.game.map;

/**
 * 
 * General set up for a map
 * 
 * @version 1.0
 *
 */
public abstract class Map {

	protected Tile[][] tiles;
	
	/**
	 * Constructor for the map
	 */
	public Map() {
		generateMap();
	}
	
	/**
	 * Gets map
	 * 
	 * @return the map
	 */
	public Tile[][] getTiles() {
		return tiles;
	}
	
	/**
	 * Generates map based on specifications
	 */
	protected abstract void generateMap();
	
}
