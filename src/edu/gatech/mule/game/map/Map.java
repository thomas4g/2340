package edu.gatech.mule.game.map;

public abstract class Map {

	protected Tile[][] tiles;
	
	public Map() {
		generateMap();
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	
	protected abstract void generateMap();
	
}
