package edu.gatech.mule.fx.graphics;

import java.awt.Point;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import tiled.core.Tile;
import tiled.util.ImageHelper;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
import edu.gatech.mule.graphics.Renderer;

/**
 * Acts as a wrapper for Graphics objects to allow for abstraction of rendering
 * @author Tyler Pennington
 *
 */

public class FXGraphics implements Renderer {

	private GraphicsContext gc;
	private HashMap<java.awt.Image, Image> convertedImages;
	
	public FXGraphics(GraphicsContext gc) {
		this.gc = gc;
		convertedImages = new HashMap<java.awt.Image, Image>();
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
		if(!convertedImages.containsKey(tile.getImage())) {
			ByteArrayInputStream in = new ByteArrayInputStream(ImageHelper.imageToPNG(tile.getImage()));
			convertedImages.put(tile.getImage(), new Image(in));
		}
		return convertedImages.get(tile.getImage());		
	}

	@Override
	public void drawEntity(Entity entity) {
		gc.drawImage(entity.getImage(), entity.getPosition().getX(), entity.getPosition().getY());
		
	}
	
	public void drawSelector(Point location){
		gc.setLineWidth(3);
		gc.strokeRect(location.getX()*OrthogonalMapRenderer.TILE_WIDTH, location.getY()*OrthogonalMapRenderer.TILE_WIDTH, OrthogonalMapRenderer.TILE_WIDTH, OrthogonalMapRenderer.TILE_HEIGHT);
		
	}

}
