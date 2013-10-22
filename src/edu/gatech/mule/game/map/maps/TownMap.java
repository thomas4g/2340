package edu.gatech.mule.game.map.maps;

import tiled.core.Tile;
import tiled.core.TileLayer;
import tiled.io.TMXMapReader;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.map.TileType;
import edu.gatech.mule.game.map.TownTile;
import edu.gatech.mule.game.map.tiles.PropertyTile;

/**
 * 
 * Generates the town map
 * 
 * @version 1.0
 *
 */
public class TownMap extends GameMap {

	/**
	 * Generates the town map
	 */
	//final String tmx = "res/tiles/town.tmx";
	@Override
	protected void generateMap() {
		// TODO Auto-generated method stub
		map=null;
		try {
			TMXMapReader mapReader = new TMXMapReader();
			//map = mapReader.readMap(tmx);
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		TileLayer layer = (TileLayer)map.getLayer(0);
		tiles=new GameTile[layer.getWidth()][layer.getHeight()];
		for(int i=0;i<layer.getWidth();i++){
			for(int j=0;j<layer.getHeight();j++){
				
				Tile tile = layer.getTileAt(i, j);
				String type = (String)tile.getProperties().get("type");
				tiles[i][j] = new TownTile(tile, TileType.valueOf(type.toUpperCase()));
				
			}
			
		}
	}
	

}
