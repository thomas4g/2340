package edu.gatech.mule.game.map;

import java.awt.Image;

import tiled.core.Tile;
import edu.gatech.mule.game.Player;

/**
 * Representation of a tile in the game map
 * @version 0.1
 */
public abstract class GameTile {

	public static final int DEFAULT_COST = 300;
	protected TileType type;
	protected Player owner;
	protected int cost;
	protected Tile tile;
	
	/**
	 * Constructor for a game tile
	 * @param t, the config for a tile entity
	 * @param type, type of tile
	 */
	public GameTile(Tile t, TileType type) {
		this.tile = t;
		this.type = type;
		this.cost = DEFAULT_COST;
	}
	
	public Image getImage() {
		return tile.getImage();
	}
	
	public int getWidth() {
		return tile.getWidth();
	}
	
	public int getHeight() {
		return tile.getHeight();
	}
	
	/**
	 * Set the owner of the tile
	 * @param player, the owner of the tile
	 */
	public void setOwner(Player player) {
		this.owner = player;
	}	
	
	/**
	 * Get the owner of the tile
	 * @return owner of the tile
	 */
	public Player getOwner() {
		return owner;
	}
	
	/**
	 * Get the cost of the tile
	 * @return cost of the tile
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Get the type of the tile
	 * @return type of the tile
	 */
	public TileType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type.toString();
	}
	
	public boolean hasOwner(){
		return owner!=null;
	}
	
	public abstract void action(Player player);
	public abstract void enter(Player player);
	public abstract void exit(Player player);
}
