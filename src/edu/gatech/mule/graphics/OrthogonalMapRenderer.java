package edu.gatech.mule.graphics;

import java.awt.Color;

import tiled.core.Map;
import tiled.core.MapLayer;
import tiled.core.Tile;
import tiled.core.TileLayer;

/**
 * Representation of a renderer for an orthogonal map
 * @version 0.1
 */
public class OrthogonalMapRenderer {

	private final Map map;
	private final Renderer graphics;
	public static int TILE_WIDTH;
	public static int TILE_HEIGHT;
	
	
	/**
	 * Constructor for the map renderer
	 * @param map, map
	 */
	public OrthogonalMapRenderer(Map map, Renderer graphics) {
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
		for(MapLayer ml : map.getLayers()) {
			TileLayer tl = (TileLayer)ml;
			for(int x=0; x<tl.getWidth(); x++) {
				for(int y=0; y<tl.getHeight(); y++) {
					final Tile tile = tl.getTileAt(x, y);
	                if (tile == null) continue;	                

	        		int tileWidth = map.getTileWidth();
	        		int tileHeight = map.getTileHeight();
	                graphics.drawTile(tile, x*tileWidth, y*tileHeight, tileWidth, tileHeight);
	                if(outlined) {
	                	graphics.drawHollowRect(x * TILE_WIDTH, y * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT, 1.0, new Color(0, 0, 0, .25F));
	                }
				}
			}
		}
	}
	
}
