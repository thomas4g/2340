package edu.gatech.mule.game.map;

import java.awt.Point;

import edu.gatech.mule.game.Player;

/**
 * Representation of a tile in a map
 * 
 * @version 1.0
 */
public abstract class Tile {

	protected Point loc;
	protected TileType type;
	protected Player player; //might not need this reference
	
	/**
	 * Constructor for a tile
	 * 
	 * @param loc, location of player in the tile ???
	 * @param type, type of the tile
	 */
	public Tile(Point loc, TileType type) {
		this.loc = loc;
		this.type = type;
	}
	
	/**
	 * Get the location of the player in the tile
	 * 
	 * @return location of the player in the tile
	 */
	public Point getLoc() {
		return loc;
	}
	
	/**
	 * Get the type of tile
	 * 
	 * @return type of tile
	 */
	public TileType getType() {
		return type;
	}
	
	/**
	 * ???
	 */
	abstract boolean onEnter();
	
	/**
	 * ???
	 */
	abstract boolean action();
	
	/**
	 * ???
	 */
	abstract Tile up();
	
	/**
	 * ???
	 */
	abstract Tile down();
	
	/**
	 * ???
	 */
	abstract Tile right();
	
	/**
	 * ???
	 */
	abstract Tile left();
}
