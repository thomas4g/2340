package edu.gatech.mule.game.map;


/**
 * General set up for a map
 * @version 0.1
 */
public abstract class GameMap {
	protected GameTile[][] tiles;
	protected int width, height, tileWidth, tileHeight;
	
	/**
	 * Constructor for the map
	 */
	public GameMap() {
		generateMap();
	}
	
	public int getWidth() {
		return this.width;
	}

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
