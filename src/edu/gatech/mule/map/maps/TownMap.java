package edu.gatech.mule.map.maps;

import java.util.Properties;

import tiled.core.Map;
import tiled.core.Tile;
import tiled.core.TileLayer;
import tiled.io.TMXMapReader;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.map.tiles.TileType;
import edu.gatech.mule.map.tiles.TownTile;

/**
 * Generates the town map.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TownMap extends GameMap {

	private final String tmx = "/tiles/town.tmx";

	/**
	 * Generates the town map.
	 */
	@Override
	protected void generateMap() {
		// TODO Auto-generated method stub
		Map map = null;
		try {
			TMXMapReader mapReader = new TMXMapReader();
			map = mapReader.readMap(tmx);
		} catch(Exception e) {
			e.printStackTrace();
		}

		TileLayer layer = (TileLayer) map.getLayer(0);
		tiles = new GameTile[layer.getWidth()][layer.getHeight()];
		this.height = map.getHeight();
		this.width = map.getWidth();
		this.tileHeight = map.getTileHeight();
		this.tileWidth = map.getTileWidth();

		for(int i = 0; i < layer.getWidth(); i++) {
			for(int j = 0; j < layer.getHeight(); j++) {
				Tile tile = layer.getTileAt(i, j);
				Properties prop = tile.getProperties();
				String type = ((String) prop.getProperty("type", "town")).toUpperCase();
				tiles[i][j] = new TownTile(tile, TileType.valueOf(type));
			}
		}
	}
}
