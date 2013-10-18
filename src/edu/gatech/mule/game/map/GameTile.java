package edu.gatech.mule.game.map;

import java.awt.Point;

import tiled.core.Tile;
import edu.gatech.mule.game.Player;

/**
 * 
 * Representation of a tile in a map
 * 
 * @version 1.0
 *
 */
public class GameTile extends Tile {

	protected TileType type;
	protected Player player; //might not need this reference
	
	/**
	 * Constructor for a tile
	 * 
	 * @param loc, location in the tile
	 * @param type, type of the tile
	 */
	public GameTile(Tile t, TileType type) {
		super(t);
		this.type = type;
	}
	
	/**
	 * ???
	 */
	public TileType getType() {
		return type;
	}
}
