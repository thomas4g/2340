package edu.gatech.mule.map.tiles;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

import javax.imageio.ImageIO;

import tiled.core.Tile;
import edu.gatech.mule.game.player.Player;

/**
 * Representation of a tile in the game map.
 */
public abstract class GameTile implements Serializable {

	private static final long serialVersionUID = -7985811022411100046L;
	public static final int DEFAULT_COST = 300;
	protected TileType type;
	protected Player owner;
	protected int cost;
	protected transient BufferedImage image;
	protected int width;
	protected int height;
	protected Properties properties;

	/**
	 * Constructor for a game tile.
	 * @param t the config for a tile entity
	 * @param type type of tile
	 */
	public GameTile(Tile t, TileType type) {
		this.image = (BufferedImage) t.getImage();
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
	 * Returns whether the mule has an owner.
	 * @return true if has owner, false otherwise
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

	/**
	 * Writes a tile to output stream.
	 * @param out output stream
	 * @throws IOException ioexception
	 */
	protected void sWrite(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		if(image != null) {
			out.writeInt(1);
			ImageIO.write(image, "png", out);
		} else {
			out.writeInt(0);
		}
	}

	/**
	 * Read a tile from input stream.
	 * @param in input stream
	 * @throws IOException ioexception
	 * @throws ClassNotFoundException classnotfoundException
	 */
	protected void sRead(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		final int hasImg = in.readInt();
		if(hasImg > 0) {
			image = ImageIO.read(in);
		}
	}

	/**
	 * writeObject implementation for Serializable.
	 * @param out outputstream
	 * @throws IOException ioexception
	 */
	private void writeObject(ObjectOutputStream out) throws IOException {
		sWrite(out);
	}

	/**
	 * readObject implementatino for Serializable.
	 * @param in inputstream
	 * @throws IOException ioexception
	 * @throws ClassNotFoundException classnotfoundexception
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		sRead(in);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || !(o instanceof GameTile)) {
			return false;
		}
		GameTile other = (GameTile) o;
		return cost == other.cost && height == other.height
			&& width == other.width && type.equals(other.type);
	}

	@Override
	public int hashCode() {
		return cost + (int) height + (int) width + type.hashCode();
	}
}
