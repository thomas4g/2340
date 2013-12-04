package edu.gatech.mule.map.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import tiled.core.AnimatedTile;
import tiled.core.Map;
import tiled.core.Tile;
import tiled.core.TileLayer;
import tiled.core.TileSet;
import tiled.io.TMXMapReader;
import edu.gatech.mule.map.tiles.AnimatedGameTile;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.map.tiles.PropertyTile;
import edu.gatech.mule.map.tiles.TileType;


/**
 * Generates a randomly generated game map.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class RandomGameMap extends GameMap {

	@Override
	protected void generateMap() {
		Map map = null;
		final String tmx = "/tiles/map.tmx";
		try {
			TMXMapReader mapReader = new TMXMapReader();
			map = mapReader.readMap(tmx);
		} catch (Exception e) {
			e.printStackTrace();
		}

		TileLayer layer = (TileLayer) map.getLayer(0);
		tiles = new GameTile[layer.getWidth()][layer.getHeight()];
		this.height = map.getHeight();
		this.width = map.getWidth();
		this.tileHeight = map.getTileHeight();
		this.tileWidth = map.getTileWidth();

		//generate animated tiles from river tileset
		TileSet riverset = map.getTileSets().get(1);
		List<AnimatedGameTile> animatedTiles = new ArrayList<>();
		int tilesetWidth = riverset.getTilesPerRow();
		int tilesetHeight = (riverset.getMaxTileId() + 1) / tilesetWidth;
		for (int i = 0; i < tilesetHeight; i++) {
			Tile[] frames = new Tile[tilesetWidth];
			Iterator<Tile> iterator = riverset.iterator();
			while (iterator.hasNext()) {
				Tile tile = iterator.next();
				Properties properties = tile.getProperties();
				int rtile = Integer.parseInt(properties.getProperty("tile"));
				int frame = Integer.parseInt(properties.getProperty("frame"));
				if(rtile == i + 1) {
					frames[frame - 1] = tile;
				}
			}
			String type = frames[0].getProperties().getProperty("type").toString();
			AnimatedGameTile aTile = new AnimatedGameTile(new AnimatedTile(frames),
					TileType.valueOf(type.toUpperCase()), frames);
			animatedTiles.add(aTile);
		}

		List<PropertyTile> tileList = new ArrayList<>();
		for(int x = 0; x < layer.getWidth(); x++) {
			for(int y = 0; y < layer.getHeight(); y++) {
				if(x == layer.getWidth() / 2) {
					continue;
				}
				Tile tile = layer.getTileAt(x, y);
				String type = tile.getProperties().get("type").toString();
				tileList.add(new PropertyTile(tile, TileType.valueOf(type.toUpperCase())));
			}
		}
		Collections.shuffle(tileList);
		for(int x = 0; x < layer.getWidth(); x++) {
			for(int y = 0; y < layer.getHeight(); y++) {
				if(x == layer.getWidth() / 2) {
					tiles[x][y] = animatedTiles.get(y);
				} else {
					int r = (int) (Math.random() * tileList.size());
					tiles[x][y] = tileList.get(r);
					tileList.remove(r);
				}
			}
		}
	}

}
