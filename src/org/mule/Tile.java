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
	//Tile is basically just a Drawable since it can have 
	//a Texture or Sprite
	private enum TileType { /*can someone put the tile types plzzz*/};
	private TileType type;
	
	
	public Tile(TileType type){
		this.type=type;
	}
	
	public TileType getTileType(){
		return type;
	}
}
