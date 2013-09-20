package org.mule;

/**
 * Representation of the map
 * 
 * @author Thomas Shields
 * @version 1.0
 */
public abstract class Tile extends Drawable{

	/**
	 * Gets called when the user presses the action key
	 * while on this tile
	 * @param p the current player
	 */
	public abstract void action(Player p);
}
