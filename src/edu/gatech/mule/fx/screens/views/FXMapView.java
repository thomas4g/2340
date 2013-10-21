package edu.gatech.mule.fx.screens.views;

import java.awt.Point;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import tiled.core.Map;
import tiled.core.Tile;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.fx.graphics.FXGraphics;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
import edu.gatech.mule.screen.screens.controllers.*;
import edu.gatech.mule.screen.screens.views.MapView;

/**
 * 
 * FX game screen ???
 * 
 * @version 1.0
 *
 */
public class FXMapView extends FXView implements MapView {
	private Canvas canvas;
	private FXGraphics graphics;
	private OrthogonalMapRenderer mapRenderer;
	private GameMap gameMap;
	private List<Entity> gameEntities;
	/**
	 * ???
	 * 
	 * @param game
	 * @param settings
	 */
	public FXMapView() {
		super("");
	}
	
	@Override
	public void load() {
		canvas = new Canvas(720, 400);
		node = canvas;
		graphics = new FXGraphics(canvas.getGraphicsContext2D());
		wireKeyboard();
		render();
		graphics.drawSelector(new Point(0,0));
	}
	
	
	private void wireKeyboard(){
		canvas.setFocusTraversable(true);
		canvas.requestFocus();
		canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent k) {
				if(k.getCode().isArrowKey()) {
					controller.move(
							k.getCode() == KeyCode.LEFT ? -1 : k.getCode() == KeyCode.RIGHT ? 1 : 0,
							k.getCode() == KeyCode.DOWN ? 1 : k.getCode() == KeyCode.UP ? -1 : 0);
				}
				else if(k.getCode().equals(KeyCode.ENTER)){
					controller.updateSelection();
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

	public void render() {
		if(null == mapRenderer) {
			mapRenderer = new OrthogonalMapRenderer(gameMap.getMap());
		}
		mapRenderer.render(graphics);
//		}
		
		for(Entity entity : gameEntities) {
			graphics.drawEntity(entity);
			System.out.println("drawing");
		}
	}

	public void drawSelector(Point location) {
		graphics.drawSelector(location);
	}
	
	@Override
	public void setGameMap(GameMap gameMap) {
		this.gameMap =gameMap;
	}

	@Override
	public void setGameEntities(List<Entity> gameEntities) {
		this.gameEntities = gameEntities;
	}

}
