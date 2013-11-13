package edu.gatech.mule.game.map;

import tiled.core.Map;

/**
 * General set up for a map
 * @version 0.1
 */
public abstract class GameMap {
	protected GameTile[][] tiles;
	protected Map map;
//	private int tileWidth; //Set tileWidth in here somewhere
//	private int tileHeight; //Set this one as well
	
	/**
	 * Constructor for the map
	 */
	public GameMap() {
		generateMap();
//		tileWidth=OrthogonalMapRenderer.TILE_WIDTH;
//		tileHeight=OrthogonalMapRenderer.TILE_WIDTH;
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
	 * Get the map
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}
	
	/**
	 * Get the tile width of the map
	 * @return tile width of the map
	 */
	public int getTileWidth(){
		return map.getTileWidth(); 
	}
	
	/**
	 * Get the tile height of the map
	 * @return tile height of the map
	 */
	public int getTileHeight(){
		return map.getTileHeight(); 
	}
	
	
	/**
	 * Generates map based on specifications
	 */
	protected abstract void generateMap();
	
}
