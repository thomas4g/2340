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

	public static final int DEFAULT_COST = 300;
	protected TileType type;
	protected Player owner;
	protected int cost;
	private Tile tile;
	
	/**
	 * Constructor for a tile
	 * 
	 * @param loc, location in the tile
	 * @param type, type of the tile
	 */
	public GameTile(Tile t, TileType type) {
		super(t);
		this.tile=t;
		this.type = type;
		this.cost = DEFAULT_COST;
	}
	
	public Tile getTile(){
		return tile;
	}
	
	public void setOwner(Player player) {
		this.owner = player;
	}
	public Player getOwner() {
		return owner;
	}
	public int getCost() {
		return cost;
	}
	
	
	public TileType getType() {
		return type;
	}
	
	public String toString() {
		return type.toString();
	}
	
	public abstract void action();
	public abstract void onEnter();
}
