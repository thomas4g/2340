package edu.gatech.mule.game.map.tiles;

import java.util.ArrayList;
import java.util.List;

import tiled.core.Tile;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.player.Player;

/**
 * Representation of a property tile
 * @version 1.0
 */
@SuppressWarnings("serial")
public class PropertyTile extends GameTile {
	
	private List<Mule> mules;
	
	/**
	 * Constructor for a property tile
	 * @param t, tile
	 * @param type, type of tile
	 */
	public PropertyTile(Tile t, TileType type) {
		super(t, type);
		mules = new ArrayList<Mule>();
	}
	
	/**
	 * Add a mule
	 * @param mule
	 */
	public void addMule(Mule mule) {
		mules.add(mule);
	}
	
	/**
	 * Returns a list of mules
	 * @return a list of mules
	 */
	public List<Mule> getMules() {
		return mules;
	}

	@Override
	public void action(Player player) {}

	@Override
	public void enter(Player player) {}

	@Override
	public void exit(Player player) {}

}
