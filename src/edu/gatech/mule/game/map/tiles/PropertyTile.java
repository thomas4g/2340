package edu.gatech.mule.game.map.tiles;

import tiled.core.Tile;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.map.TileType;

public class PropertyTile extends GameTile {
	
	protected Player owner;
	
	public PropertyTile(Tile t, TileType type) {
		super(t, type);
	}
	public void setOwner(Player player) {
		this.owner = player;
	}
	public Player getOwner() {
		return owner;
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
