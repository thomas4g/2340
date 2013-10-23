package edu.gatech.mule.graphics;

import edu.gatech.mule.game.Entity;
import tiled.core.Tile;

/**
 * Representation of a renderer that can render an entity on a tile
 * @version 0.1
 */
public interface Renderer {

	public void drawTile(Tile tile, int x, int y, int width, int height);
	public void drawEntity(Entity entity);
	public void translate(int x, int y);
}
