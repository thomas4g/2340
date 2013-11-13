package edu.gatech.mule.game.map.tiles;

import java.util.ArrayList;
import java.util.List;

import tiled.core.Tile;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.player.Player;

/**
 * Representation of a property tile
 * @version 0.1
 */
public class PropertyTile extends GameTile {
	
	private List<Mule> mules;
	
	/**
	 * Constructor for a property tile
	 * @param t, tile config ???
	 * @param type, type of tile
	 */
	public PropertyTile(Tile t, TileType type) {
		super(t, type);
		mules = new ArrayList<Mule>();
	}
	
	public void addMule(Mule mule) {
		mules.add(mule);
	}
	public List<Mule> getMules() {
		return mules;
	}

	@Override
	public void action(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(Player player) {

	}

	@Override
	public void exit(Player player) {
		// TODO Auto-generated method stub
		
	}

}
