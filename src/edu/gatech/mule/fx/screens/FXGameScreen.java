package edu.gatech.mule.fx.screens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.FXScreen;
import edu.gatech.mule.fx.graphics.FXGraphics;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
import edu.gatech.mule.screen.screens.AbstractGameScreen;

/**
 * 
 * FX game screen ???
 * 
 * @version 1.0
 *
 */
public class FXGameScreen extends AbstractGameScreen implements Initializable, FXScreen {
	private Canvas mapCanvas;
	private FXGraphics graphics;
	private OrthogonalMapRenderer mapRenderer;
	/**
	 * ???
	 * 
	 * @param game
	 * @param settings
	 */
	public FXGameScreen(GameEngine game) {
		super(game);
	}
	
	public void load() {
		mapCanvas = new Canvas(720, 400);
		graphics = new FXGraphics(mapCanvas.getGraphicsContext2D());
		renderMap();
	}


	/**
	 * 
	 * ???
	 * 
	 * @param location
	 * @param resource
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Node getNode() {
		// TODO Auto-generated method stub
		return mapCanvas;
	}



	@Override
	public void renderMap() {
		if(null == mapRenderer)
			mapRenderer = new OrthogonalMapRenderer(game.getGameMap());
		mapRenderer.render(graphics);		
	}

}
