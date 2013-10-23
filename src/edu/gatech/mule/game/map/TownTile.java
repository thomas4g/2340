package edu.gatech.mule.game.map;

import tiled.core.Tile;

/**
 * Representation of a tile in the town
 * @version 0.1
 */
public class TownTile extends GameTile {

	public TownTile(Tile t, TileType type){
		super(t,type);
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub

	}
	@Override
	public void onEnter() {
		//adjust roof image
	}

}
