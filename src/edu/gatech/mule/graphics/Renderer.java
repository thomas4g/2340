package edu.gatech.mule.graphics;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import edu.gatech.mule.game.Entity;
import edu.gatech.mule.map.tiles.GameTile;

/**
 * Representation of a renderer that can render an entity on a tile.
 * @version 1.0
 */
public interface Renderer {

	float LAND_SELECT_ALPHA = 0.1f;

	/**
	 * Draws a tile.
	 * @param tile tile
	 * @param x coordinate location of tile
	 * @param y coordinate location of tile
	 * @param width of the tile
	 * @param height of the tile
	 */
	void drawTile(GameTile tile, int x, int y, int width, int height);

	/**
	 * Draws an entity onto the screen.
	 * @param entity graphic representation of a non-background
	 */
	void drawEntity(Entity entity);

	/**
	 * Draws a hollow rectangle for land selection.
	 * @param x coordinate location of the tile
	 * @param y coordinate location of the tile
	 * @param width of the tile
	 * @param height of the tile
	 * @param lineWidth of the border
	 * @param color of the border
	 */
	void drawHollowRect(int x, int y, int width, int height, double lineWidth, Color color);

	/**
	 * Draws image.
	 * @param image to be drawn
	 * @param x coordinate location of the image
	 * @param y coordinate location of the image
	 * @param width of image
	 * @param height of image
	 */
	void drawImage(BufferedImage image, int x, int y, int width, int height);

	/**
	 * Clears the screen.
	 * @param x coordinate location of the image
	 * @param y coordinate location of the image
	 * @param width of area
	 * @param height of area
	 */
	void clear(int x, int y, int width, int height);

	/**
	 * Draws text.
	 * @param text of string to be displayed
	 * @param point where text start
	 * @param color of text
	 * @param fontSize of text
	 */
	void drawText(String text, Point point, Color color, double fontSize);

}
