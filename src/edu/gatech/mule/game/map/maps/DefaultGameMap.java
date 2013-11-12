package edu.gatech.mule.game.map.maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tiled.core.AnimatedTile;
import tiled.core.Tile;
import tiled.core.TileLayer;
import tiled.core.TileSet;
import tiled.io.TMXMapReader;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.map.TileType;
import edu.gatech.mule.game.map.tiles.AnimatedGameTile;
import edu.gatech.mule.game.map.tiles.PropertyTile;

/**
 * Representation of the default main game map
 * @version 1.0
 */
public class DefaultGameMap extends GameMap {
	
	/**
	 * Generates the default game map
	 */
	@Override
	protected void generateMap() {
		//read map from tmx
		map = null;
		final String tmx = "/tiles/map.tmx";
		try {
			TMXMapReader mapReader = new TMXMapReader();
			map = mapReader.readMap(tmx);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		TileLayer layer = (TileLayer)map.getLayer(0);
		tiles = new GameTile[layer.getWidth()][layer.getHeight()];
		
		//generate animated tiles from river tileset
		TileSet riverset = map.getTileSets().get(1);
		List<AnimatedGameTile> animatedTiles = new ArrayList<>();
		for(int i=0; i<5; i++) {
			Tile[] frames = new Tile[3];
			Iterator<Tile> iterator = riverset.iterator();
			while(iterator.hasNext()) {
				Tile tile = iterator.next();
				int rtile = Integer.parseInt(tile.getProperties().getProperty("tile"));
				int frame = Integer.parseInt(tile.getProperties().getProperty("frame"));
				if(rtile == i+1) {
					frames[frame-1] = tile;
				}
			}
			String type = frames[0].getProperties().getProperty("type").toString();
			AnimatedGameTile aTile = new AnimatedGameTile(new AnimatedTile(frames), TileType.valueOf(type.toUpperCase()), frames);
			animatedTiles.add(aTile);
		}
		
		
		for(int x=0; x<layer.getWidth(); x++) {
			for(int y=0; y<layer.getHeight(); y++) {
				Tile tile = layer.getTileAt(x, y);
				String type = tile.getProperties().get("type").toString();
				if(tile.getProperties().containsKey("animated")) {
					int rtile = Integer.parseInt(tile.getProperties().getProperty("tile"));
					tiles[x][y] = animatedTiles.get(rtile-1);
				} else {
					tiles[x][y] = new PropertyTile(tile, TileType.valueOf(type.toUpperCase()));
				}
			}
		}
	}
}
