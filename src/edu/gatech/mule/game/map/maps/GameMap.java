package edu.gatech.mule.game.map.maps;

import java.io.Serializable;

import edu.gatech.mule.game.map.tiles.GameTile;


/**
 * General set up for a map
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class GameMap implements Serializable {
	protected GameTile[][] tiles;
	protected int width, height, tileWidth, tileHeight;
	
	/**
	 * Constructor for the map
	 */
	public GameMap() {
		generateMap();
	}
	
	/**
	 * Returns width of map
	 * @return width of map
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Returns height of map
	 * @return height of map
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Get tiles in the map
	 * @return tiles in the map
	 */
	public GameTile[][] getTiles() {
		return tiles;
	}
	
	/**
	 * Get a tile in the map
	 * @param xPos, x-coordinate in map
	 * @param yPos, y-coordinate in map
	 * @return the corresponding tile in map
	 */
	public GameTile getTile(int xPos,int yPos){
		return tiles[xPos][yPos];
	}
	
	/**
	 * Get the tile width of the map
	 * @return tile width of the map
	 */
	public int getTileWidth(){
		return this.tileWidth;
	}
	
	/**
	 * Get the tile height of the map
	 * @return tile height of the map
	 */
	public int getTileHeight(){
		return this.tileHeight;
	}
	
	/**
	 * Generates map based on specifications
	 */
	protected abstract void generateMap();
	
}
