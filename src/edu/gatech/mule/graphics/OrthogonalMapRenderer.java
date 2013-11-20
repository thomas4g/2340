package edu.gatech.mule.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.gatech.mule.map.maps.GameMap;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.map.tiles.PropertyTile;

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
			for(int x=0; x<map.getWidth(); x++) {
				for(int y=0; y<map.getHeight(); y++) {
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
	                
	                if(tile instanceof PropertyTile && tile.hasOwner()) {
	                	PropertyTile t = (PropertyTile)tile;
	                	
	                	for(int i=0;i<t.getMules().size();i++) {
		                	BufferedImage totem = null;
							try {
								totem = ImageIO.read(new File("res/tiles/resource tiles/" + t.getMules().get(i).getType().name().toLowerCase() + "tile.png"));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} //tile.getOwner().getTotem();
	                		graphics.drawImage(totem, x * TILE_WIDTH + i*totem.getWidth(), y * TILE_HEIGHT + TILE_HEIGHT - totem.getHeight(), totem.getWidth(), totem.getHeight());
	                	}
	                }
				}
			}
//		}
	}
	
}
