package edu.gatech.mule.graphics;

import java.awt.Color;

import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import tiled.core.Map;
import tiled.core.MapLayer;
import tiled.core.Tile;
import tiled.core.TileLayer;

/**
 * Representation of a renderer for an orthogonal map
 * @version 0.1
 */
public class OrthogonalMapRenderer {

	private final GameMap map;
	private final Renderer graphics;
	public static int TILE_WIDTH;
	public static int TILE_HEIGHT;
	
	
	/**
	 * Constructor for the map rendSerer
	 * @param map, map
	 */
	public OrthogonalMapRenderer(GameMap map, Renderer graphics) {
		TILE_WIDTH = map.getTileWidth();
		TILE_HEIGHT = map.getTileHeight();
		this.map = map;
		this.graphics = graphics;
	}
	
	/**
	 * Renders map
	 * @param graphics, the graphics ???
	 */
	public void render(boolean outlined) {
//		for(MapLayer ml : map.setLayers()) {
//			TileLayer tl = (TileLayer)ml;
			for(int x=0; x<map.getMap().getWidth(); x++) {
				for(int y=0; y<map.getMap().getHeight(); y++) {
					GameTile tile = map.getTile(x, y);
	                if (tile == null) continue;	                

	        		int tileWidth = map.getTileWidth();
	        		int tileHeight = map.getTileHeight();
	                graphics.drawTile(tile, x*tileWidth, y*tileHeight, tileWidth, tileHeight);
	                if(outlined) {
	                	graphics.drawHollowRect(x * TILE_WIDTH, y * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT, 1.0, new Color(0, 0, 0, .25F));
	                }
	                if(tile.getOwner() != null) {
	                	graphics.drawImage(tile.getOwner().getTotem(), x * TILE_WIDTH, y * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
	                }
				}
			}
//		}
	}
	
}
