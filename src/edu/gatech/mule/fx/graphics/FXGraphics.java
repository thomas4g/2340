package edu.gatech.mule.fx.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import tiled.core.Tile;
import tiled.util.ImageHelper;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
import edu.gatech.mule.graphics.Renderer;

/**
 * Acts as a wrapper for Graphics objects to allow for abstraction of rendering
 * @author Tyler Pennington
 */
public class FXGraphics implements Renderer {

	private GraphicsContext gc;
	private HashMap<java.awt.Image, Image> convertedImages;

	/**
	 * Constructor for FX graphics
	 * @param gc
	 */
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
		gc.drawImage(createImage((BufferedImage)tile.getImage()), x, y, width, height);
	}
	
//	public Image createImage(java.awt.Image image) {
//		return createImage(ImageIO.)
//	}
	
	public Image createImage(BufferedImage image) {
		if(!convertedImages.containsKey(image)) {
			Image fxImage = SwingFXUtils.toFXImage(image, null);
//			ByteArrayInputStream in = new ByteArrayInputStream(ImageHelper.imageToPNG(image));
//			convertedImages.put(image, new Image(in));
			convertedImages.put(image, fxImage);
		}
		return convertedImages.get(image);		
	}

	/**
	 * Draws image
	 * @param image, image to be drawn
	 * @param position, position of image
	 * @param width, width of image
	 * @param height, height of image
	 */
	public void drawImage(BufferedImage image, Point position, int width, int height) {
		gc.drawImage(createImage(image), position.x, position.y, width, height);	
	}
	
	/**
	 * Draws image
	 * @param image, image to be drawn
	 * @param position, position of image
	 */
	public void drawImage(BufferedImage image, Point position) {
		drawImage(image, position, image.getWidth(), image.getHeight());
	}
	
	/**
	 * Draws the tile selector
	 * @param location, location of the selector
	 * @param color, color of the selector
	 */
	public void drawSelector(Point location,Color color){
		gc.setLineWidth(3);
		gc.setStroke(color);
		gc.strokeRect(location.getX()*OrthogonalMapRenderer.TILE_WIDTH, location.getY()*OrthogonalMapRenderer.TILE_WIDTH, OrthogonalMapRenderer.TILE_WIDTH, OrthogonalMapRenderer.TILE_HEIGHT);
	}
	
	/**
	 * get the graphics context ???
	 * @return graphics context
	 */
	public GraphicsContext getGraphicsContext() {
		return gc;
	}

	@Override
	public void drawEntity(Entity entity) {
		// TODO Auto-generated method stub
		//NOT USING THIS |__BEAR__| WITH ME
		// omg what is this i don't even
	}

	/**
	 * Draws text
	 * @param text, text to be drawn
	 * @param point, location where text starts
	 */
	public void drawText(String text, Point point) {
		gc.setLineWidth(.75);
		gc.setStroke(new Color(0,0,0,1));
		gc.strokeText(text, point.x, point.y);
	}

}
