package edu.gatech.mule.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

import tiled.core.Tile;
import edu.gatech.mule.game.Entity;

/**
 * Representation of a renderer that can render an entity on a tile
 * @version 0.1
 */
public interface Renderer {

	/**
	 * Draw a tile
	 * @param tile
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawTile(Tile tile, int x, int y, int width, int height);
	public void drawEntity(Entity entity);
	
	/**
	 * Draw a hollow rectangle
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param lineWidth
	 * @param color
	 */
	public void drawHollowRect(int x, int y, int width, int height, double lineWidth, Color color);

	/**
	 * Draws image
	 * @param image, image to be drawn
	 * @param position, position of image
	 * @param width, width of image
	 * @param height, height of image
	 */
	public void drawImage(BufferedImage image, int x, int y, int width, int height);
	
	/**
	 * Clear the screen
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void clear(int x, int y, int width, int height);
}
