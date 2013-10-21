package edu.gatech.mule.fx.screens;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	private Canvas canvas;
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
		canvas = new Canvas(720, 400);
		graphics = new FXGraphics(canvas.getGraphicsContext2D());
		wireKeyboard();
		render();
	}
	
	private void wireKeyboard(){
		canvas.setFocusTraversable(true);
		canvas.requestFocus();
		canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent k) {
				if(k.getCode().isArrowKey()) {
					move(
							k.getCode() == KeyCode.LEFT ? -1 : k.getCode() == KeyCode.RIGHT ? 1 : 0,
							k.getCode() == KeyCode.DOWN ? -1 : k.getCode() == KeyCode.UP ? 1 : 0);
				}
			}
		});
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
		return canvas;
	}



	@Override
	public void render() {
		if(null == mapRenderer)
			mapRenderer = new OrthogonalMapRenderer(game.getGameMap());
		mapRenderer.render(graphics);
		//graphics.drawEntity(currentPlayer);
	}

}
