package edu.gatech.mule.graphics;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.gatech.mule.fx.views.FXView;
import edu.gatech.mule.map.maps.GameMap;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.map.tiles.PropertyTile;

/**
 * Representation of a renderer for an orthogonal map.
 * @version 1.0
 */
public class OrthogonalMapRenderer {

	private final GameMap map;
	private final Renderer graphics;
	private static int tileWidth;
	private static int tileHeight;

	/**
	 * Constructor for the map renderer.
	 * @param map to be rendered
	 * @param graphics the renderer
	 */
	public OrthogonalMapRenderer(GameMap map, Renderer graphics) {
		tileWidth = map.getTileWidth();
		tileHeight = map.getTileHeight();
		this.map = map;
		this.graphics = graphics;
	}

	/**
	 * Returns tile width.
	 * @return tile width
	 */
	public static int getTileWidth() {
		return tileWidth;
	}

	/**
	 * Returns tile height.
	 * @return tile height.
	 */
	public static int getTileHeight() {
		return tileHeight;
	}

	/**
	 * Renders map.
	 * @param outlined if need rectangle for land select
	 */
	public void render(boolean outlined) {
		for(int x = 0; x < map.getWidth(); x++) {
			for(int y = 0; y < map.getHeight(); y++) {

				GameTile tile = map.getTile(x, y);
				if (tile == null) {
					continue;
				}

				graphics.drawTile(tile, x * tileWidth, y * tileHeight, tileWidth, tileHeight);

				if(outlined) {
					graphics.drawHollowRect(x * tileWidth,
						y * tileHeight,
						tileWidth,
						tileHeight,
						1.0,
						new Color(0, 0, 0, Renderer.LAND_SELECT_ALPHA));
				}
				if(tile.getOwner() != null) {
					BufferedImage totem = tile.getOwner().getTotem();
					graphics.drawImage(totem,
							x * tileWidth,
							y * tileHeight,
							totem.getWidth(),
							totem.getHeight());
				}

				if(tile instanceof PropertyTile && tile.hasOwner()) {
					PropertyTile t = (PropertyTile) tile;

					for(int i = 0; i < t.getMules().size(); i++) {
						BufferedImage totem = null;
						try {
							totem = ImageIO.read(new File("res/tiles/resource tiles/"
										+ t.getMules().get(i).getType().name().toLowerCase()
										+ "tile.png"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						graphics.drawImage(totem,
								x * tileWidth + i * totem.getWidth(),
								y * tileHeight + tileHeight - totem.getHeight(),
								totem.getWidth(),
								totem.getHeight());

						graphics.drawText(Integer.toString(t.getCrystiteAmount()),
								new Point(x * tileWidth + tileWidth - totem.getWidth(),
										y * tileWidth + tileHeight - totem.getHeight()),
								Color.CYAN,
								FXView.FONT_SIZE);
					}
				}
			}
		}
	}
}
