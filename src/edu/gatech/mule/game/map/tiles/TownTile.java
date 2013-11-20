package edu.gatech.mule.game.map.tiles;

import edu.gatech.mule.game.player.Player;
import tiled.core.Tile;

/**
 * Representation of a tile in the town.
 * @version 0.1
 */
public class TownTile extends GameTile {

	/**
	 * TownTile.
	 * @param t tile
	 * @param type tiletype
	 */
	public TownTile(Tile t, TileType type) {
		super(t, type);
	}

	@Override
	public void action(Player player) {
		// TODO Auto-generated method stub
	}

	@Override
	public void enter(Player player) {
		// TODO Auto-generated method stub
	}

	@Override
	public void exit(Player player) {
		// TODO Auto-generated method stub
	}

}
