package edu.gatech.mule.game.map;

import edu.gatech.mule.graphics.OrthogonalMapRenderer;
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
	private int tileWidth; //Set tileWidth in here somewhere
	private int tileHeight; //Set this one as well
	/**
	 * Constructor for the map
	 */
	public GameMap() {
		generateMap();
		tileWidth=OrthogonalMapRenderer.TILE_WIDTH;
		tileHeight=OrthogonalMapRenderer.TILE_WIDTH;
	}

	/**
	 * Gets the tiles in the map
	 * 
	 * @return the array of tiles
	 */
	public GameTile[][] getTiles() {
		return tiles;
	}
	
	public GameTile getTile(int xPos,int yPos){
		return tiles[xPos][yPos];
	}
	
	public Map getMap() {
		return map;
	}
	
	public int getTileWidth(){
		return tileWidth;
	}
	
	public int getTileHeight(){
		return tileHeight;
	}
	
	/**
	 * Generates map based on specifications
	 */
	protected abstract void generateMap();
	
}
