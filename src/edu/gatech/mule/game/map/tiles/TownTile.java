package edu.gatech.mule.game.map.tiles;

import edu.gatech.mule.game.player.Player;
import tiled.core.Tile;

/**
 * Representation of a tile in the town
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TownTile extends GameTile {

	/**
	 * Constructor for a town tile
	 * @param t, tile
	 * @param type, type of tile
	 */
	public TownTile(Tile t, TileType type){
		super(t,type);
	}

	@Override
	public void action(Player player) {}

	@Override
	public void enter(Player player) {}

	@Override
	public void exit(Player player) {}

}
