package edu.gatech.mule.graphics;

import edu.gatech.mule.game.Entity;
import tiled.core.Tile;

public interface Renderer {

	public void drawTile(Tile tile, int x, int y, int width, int height);
	
	public void drawEntity(Entity entity);
	
	public void translate(int x, int y);
}
