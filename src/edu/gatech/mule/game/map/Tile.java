package edu.gatech.mule.game.map;

import java.awt.Point;

import edu.gatech.mule.game.Player;

public abstract class Tile {

	protected Point loc;
	protected TileType type;
	protected Player player; //might not need this reference
	
	public Tile(Point loc, TileType type) {
		this.loc = loc;
		this.type = type;
	}
	
	public Point getLoc() {
		return loc;
	}
	
	public TileType getType() {
		return type;
	}
	
	abstract boolean onEnter();
	abstract boolean action();
	
	abstract Tile up();
	abstract Tile down();
	abstract Tile right();
	abstract Tile left();
}
