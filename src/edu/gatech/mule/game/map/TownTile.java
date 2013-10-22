package edu.gatech.mule.game.map;

import tiled.core.Tile;

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
