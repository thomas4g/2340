package edu.gatech.mule.fx.graphics;

import java.io.ByteArrayInputStream;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import tiled.core.Tile;
import tiled.util.ImageHelper;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.graphics.Renderer;

/**
 * Acts as a wrapper for Graphics objects to allow for abstraction of rendering
 * @author Tyler Pennington
 *
 */

public class FXGraphics implements Renderer {

	private GraphicsContext gc;
	
	public FXGraphics(GraphicsContext gc) {
		this.gc = gc;
	}

	@Override
	public void translate(int x, int y) {
		gc.translate(x, y);
	}

	@Override
	public void drawTile(Tile tile, int x, int y, int width, int height) {		
		gc.drawImage(createImage(tile), x, y, width, height);
	}
	
	
	public Image createImage(Tile tile) {
		ByteArrayInputStream in = new ByteArrayInputStream(ImageHelper.imageToPNG(tile.getImage()));
		return new Image(in);
	}

	@Override
	public void drawEntity(Entity entity) {
		gc.drawImage(entity.getImage(), entity.getPosition().getX(), entity.getPosition().getY());
		
	}

}
