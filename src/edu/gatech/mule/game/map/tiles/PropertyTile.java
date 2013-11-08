package edu.gatech.mule.game.map.tiles;

import tiled.core.Tile;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.map.TileType;

/**
 * Representation of a property tile
 * @version 0.1
 */
public class PropertyTile extends GameTile {
	
	/**
	 * Constructor for a property tile
	 * @param t, tile config ???
	 * @param type, type of tile
	 */
	public PropertyTile(Tile t, TileType type) {
		super(t, type);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

}
