package edu.gatech.mule.game.map;

import edu.gatech.mule.game.Player;
import tiled.core.Tile;

/**
 * Representation of a tile in the game map
 * @version 0.1
 */
public abstract class GameTile extends Tile {

	public static final int DEFAULT_COST = 300;
	protected TileType type;
	protected Player owner;
	protected int cost;
	private Tile tile;
	
	/**
	 * Constructor for a game tile
	 * @param t, the config for a tile entity
	 * @param type, type of tile
	 */
	public GameTile(Tile t, TileType type) {
		super(t);
		this.tile=t;
		this.type = type;
		this.cost = DEFAULT_COST;
		this.setImage(tile.getImage());
	}
	
	/**
	 * Get the tile ???
	 * @return tile
	 */
	public Tile getTile(){
		return tile;
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
	
	public int getHeight() {
		return tile.getHeight();
	}
	public int getWidth() {
		return tile.getWidth();
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
