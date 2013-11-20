package edu.gatech.mule.game.map.maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tiled.core.AnimatedTile;
import tiled.core.Map;
import tiled.core.Tile;
import tiled.core.TileLayer;
import tiled.core.TileSet;
import tiled.io.TMXMapReader;
import edu.gatech.mule.game.map.tiles.AnimatedGameTile;
import edu.gatech.mule.game.map.tiles.GameTile;
import edu.gatech.mule.game.map.tiles.PropertyTile;
import edu.gatech.mule.game.map.tiles.TileType;

/**
 * Representation of the default main game map
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DefaultGameMap extends GameMap {
	
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
		
		TileLayer layer = (TileLayer)map.getLayer(0);
		tiles = new GameTile[layer.getWidth()][layer.getHeight()];
		this.height = map.getHeight();
		this.width = map.getWidth();
		this.tileHeight = map.getTileHeight();
		this.tileWidth = map.getTileWidth();
		
		TileSet riverset = map.getTileSets().get(1);
		List<AnimatedGameTile> animatedTiles = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			Tile[] frames = new Tile[3];
			Iterator<Tile> iterator = riverset.iterator();
			while (iterator.hasNext()) {
				Tile tile = iterator.next();
				int rtile = Integer.parseInt(tile.getProperties().getProperty("tile"));
				int frame = Integer.parseInt(tile.getProperties().getProperty("frame"));
				if (rtile == i+1) {
					frames[frame-1] = tile;
				}
			}
			String type = frames[0].getProperties().getProperty("type").toString();
			AnimatedGameTile aTile
				= new AnimatedGameTile(new AnimatedTile(frames),
									   TileType.valueOf(type.toUpperCase()), frames);
			animatedTiles.add(aTile);
		}
		
		
		for(int x = 0; x < layer.getWidth(); x++) {
			for(int y = 0; y < layer.getHeight(); y++) {
				Tile tile = layer.getTileAt(x, y);
				String type = tile.getProperties().get("type").toString();
				if (tile.getProperties().containsKey("animated")) {
					int rtile = Integer.parseInt(tile.getProperties().getProperty("tile"));
					tiles[x][y] = animatedTiles.get(rtile-1);
				} else {
					tiles[x][y] = new PropertyTile(tile, TileType.valueOf(type.toUpperCase()));
				}
			}
		}
	}
}
