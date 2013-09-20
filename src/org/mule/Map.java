package org.mule;

public class Map {
	
	private int mapWidth;
	private int mapHeight;
	private Tile[] tiles;
	private String json;

	public Map(int mapWidth, int mapHeight) {
		this.mapWidth=mapWidth;
		this.mapHeight=mapHeight;
	}
	
	public void parseJson(){
		//do magical json parsing to convert json to actual map
	}
	
	public Tile[] getMap(){
		return tiles;
	}

}
