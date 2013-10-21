package edu.gatech.mule.game.map;

import edu.gatech.mule.game.Player;
import tiled.core.Tile;

/**
 * 
 * Representation of a tile in a map
 * 
 * @version 1.0
 *
 */
public abstract class GameTile extends Tile {

	protected TileType type;
	protected Player owner;
	
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
	
	public void setOwner(Player player) {
		this.owner = player;
	}
	public Player getOwner() {
		return owner;
	}
	
	/**
	 * ???
	 */
	public TileType getType() {
		return type;
	}
	
	public String toString() {
		return type.toString();
	}
	
	public abstract void action();
	public abstract void onEnter();
}
