package edu.gatech.mule.graphics;

import java.awt.Rectangle;

import tiled.core.Map;
import tiled.core.MapLayer;
import tiled.core.Tile;
import tiled.core.TileLayer;

public class OrthogonalMapRenderer {

	private final Map map;
	public static int TILE_WIDTH;
	public static int TILE_HEIGHT;
	
	public OrthogonalMapRenderer(Map map) {
		TILE_WIDTH=map.getTileWidth();
		TILE_HEIGHT=map.getTileHeight();
		this.map = map;
	}
	
	
	public void render(Renderer graphics) {
		Rectangle mapBounds = map.getBounds();
		graphics.translate(mapBounds.x, mapBounds.y);
		
		for(MapLayer ml : map.getLayers()) {
			TileLayer tl = (TileLayer)ml;
			for(int x=0; x<tl.getWidth(); x++) {
				for(int y=0; y<tl.getHeight(); y++) {
					final Tile tile = tl.getTileAt(x, y);
	                if (tile == null) continue;	                

	        		int tileWidth = map.getTileWidth();
	        		int tileHeight = map.getTileHeight();
	                
	                graphics.drawTile(tile, x*tileWidth, y*tileHeight, tileWidth, tileHeight);
				}
			}
			
		}
	}
	
	
}
