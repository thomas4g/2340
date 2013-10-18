package edu.gatech.mule.fx.screens;

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.graphics.FXGraphics;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;

public class FXGameScreen extends Parent {

	private Canvas mapCanvas;
	private FXGraphics graphics;
	private OrthogonalMapRenderer mapRenderer;
	
	public FXGameScreen(GameEngine engine) {
		mapCanvas = new Canvas(720, 400);
		graphics = new FXGraphics(mapCanvas.getGraphicsContext2D());
		mapRenderer = new OrthogonalMapRenderer(engine.getGameMap());
		this.getChildren().add(mapCanvas);
		renderMap();
	}
	
	public void renderMap() {
		mapRenderer.render(graphics);
	}
	
	
}
