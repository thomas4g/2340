package edu.gatech.mule.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;

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
		TILE_WIDTH = map.getMap().getTileWidth();
		TILE_HEIGHT = map.getMap().getTileHeight();
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

	                graphics.drawTile(tile, x * TILE_WIDTH, y * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
	                
	                if(outlined) {
	                	graphics.drawHollowRect(x * TILE_WIDTH, y * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT, 1.0, new Color(0, 0, 0, .25F));
	                }
	                if(tile.getOwner() != null) {
	                	BufferedImage totem = tile.getOwner().getTotem();
	                	graphics.drawImage(totem, x * TILE_WIDTH, y * TILE_HEIGHT, totem.getWidth() , totem.getHeight());
	                }
				}
			}
//		}
	}
	
}
