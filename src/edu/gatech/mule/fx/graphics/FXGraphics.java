package edu.gatech.mule.fx.graphics;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.graphics.Renderer;

/**
 * Acts as a wrapper for Graphics objects to allow for abstraction of rendering
 * @author Tyler Pennington
 */
public class FXGraphics implements Renderer {

	private GraphicsContext gc;
	private static HashMap<java.awt.Image, Image> convertedImages = new HashMap<>();

	/**
	 * Constructor for FX graphics
	 * @param gc
	 */
	public FXGraphics(GraphicsContext gc) {
		this.gc = gc;
	}
	
	//Inherited methods
	
	@Override
	public void drawEntity(Entity entity) {
		if(entity != null) {
			BufferedImage image = entity.getImage();
			drawImage(image, entity.getPosition().x - image.getWidth() / 2, entity.getPosition().y - image.getHeight() / 2, image.getWidth(), image.getHeight());
		}
	}
	
	@Override
	public void drawHollowRect(int x, int y, int width, int height, double lineWidth, Color color) {
		gc.setLineWidth(lineWidth);
		gc.setStroke(fxColor(color));
		gc.strokeRect(x, y, width, height);
	}
	
	@Override
	public void clear(int x, int y, int width, int height) {
		gc.clearRect(x, y, width, height);
	}
	
	@Override
	public void drawTile(GameTile tile, int x, int y, int width, int height) {
		gc.drawImage(createImage((BufferedImage)tile.getImage()), x, y, width, height);
	}
	
	@Override
	public void drawImage(BufferedImage image, int x, int y, int width, int height) {
		gc.drawImage(createImage(image), x, y, width, height);	
	}
	
	//JavaFX helper methods
	
	private javafx.scene.paint.Color fxColor(Color color) {
		return new javafx.scene.paint.Color(color.getRed() / 255.0, color.getGreen() / 255.0, color.getBlue() / 255.0, 1);
	}	
	
	public Image createImage(BufferedImage image) {
		if(!convertedImages.containsKey(image)) {
			Image fxImage = SwingFXUtils.toFXImage(image, null);
			convertedImages.put(image, fxImage);
		}
		return convertedImages.get(image);		
	}

	/**
	 * Draws text
	 * @param text, text to be drawn
	 * @param point, location where text starts
	 */
	public void drawText(String text, Point point) {
		drawText(text, point, Color.BLACK, 12);
	}
	
	public void drawGreyedText(String text, Point point) {
		drawText(text, point, Color.GRAY, 12);
	}

	public void drawText(String text, Point point, Color color, double fontSize) {
		gc.setLineWidth(.75);
		gc.setFont(new Font(fontSize));
		gc.setStroke(fxColor(color));
		gc.strokeText(text, point.x, point.y);
	}
	
}
