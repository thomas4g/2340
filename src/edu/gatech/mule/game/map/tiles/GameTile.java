package edu.gatech.mule.game.map.tiles;

import java.awt.Image;
import java.io.Serializable;
import java.util.Properties;

import tiled.core.Tile;
import edu.gatech.mule.game.player.Player;

/**
 * Representation of a tile in the game map.
 * @version 0.1
 */
public abstract class GameTile implements Serializable {

	public static final int DEFAULT_COST = 300;
	protected TileType type;
	protected Player owner;
	protected int cost;
	protected transient Image image;
	protected int width;
	protected int height;
	protected Properties properties;

	/**
	 * Constructor for a game tile.
	 * @param t the config for a tile entity
	 * @param type type of tile
	 */
	public GameTile(Tile t, TileType type) {
		this.image = t.getImage();
		this.properties = t.getProperties();
		this.width = t.getWidth();
		this.height = t.getHeight();
		this.type = type;
		this.cost = DEFAULT_COST;
	}

	/**
	 * Gets properties of the tile.
	 * @return properties
	 */
	public Properties getProperties() {
		return this.properties;
	}

	/**
	 * Gets the image of the tile.
	 * @return image
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * Pixel width of the tile.
	 * @return width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Pixel height of the tile.
	 * @return height
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Set the owner of the tile.
	 * @param player the owner of the tile
	 */
	public void setOwner(Player player) {
		this.owner = player;
	}

	/**
	 * Get the owner of the tile.
	 * @return owner of the tile
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * Get the cost of the tile.
	 * @return cost of the tile
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Get the type of the tile.
	 * @return type of the tile
	 */
	public TileType getType() {
		return type;
	}

	@Override
	public String toString() {
		return type.toString();
	}

	/**
	 * True if tile is owned.
	 * @return true or false
	 */
	public boolean hasOwner() {
		return owner != null;
	}

	/**
	 * Called when action key is pressed.
	 * @param player current player
	 */
	public abstract void action(Player player);

	/**
	 * Called when tile is entered.
	 * @param player current player
	 */
	public abstract void enter(Player player);

	/**
	 * Called when tile is exited.
	 * @param player current player.
	 */
	public abstract void exit(Player player);
}
