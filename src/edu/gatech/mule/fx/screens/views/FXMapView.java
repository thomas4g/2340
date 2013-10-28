package edu.gatech.mule.fx.screens.views;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import edu.gatech.mule.fx.graphics.FXGraphics;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
import edu.gatech.mule.screen.screens.views.MapView;

/**
 * View for main map
 * @version 1.0
 */
public class FXMapView extends FXView implements MapView {
	private Canvas canvas;
	private FXGraphics graphics;
	private OrthogonalMapRenderer mapRenderer;
	private GameMap gameMap;
	private List<Entity> gameEntities;
	private Player currentPlayer;
	private Point selectorLocation;
	private boolean interrupt = false;

	/**
	 * Constructor for map view
	 */
	public FXMapView() {
		super("");
	}
	
	@Override
	public void load() {
		canvas = new Canvas(720, 700);
		node = canvas;
		graphics = new FXGraphics(canvas.getGraphicsContext2D());
		mapRenderer = new OrthogonalMapRenderer(gameMap.getMap(), graphics);
		wireKeyboard();
		
//		Task<Void> t = new RenderTask<Void>(this);
//		new Thread(t).start();

		render();
	}
	
	/**
	 * Wires the key board onto the game
	 */
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
					controller.action();
				}
				else if(k.getCode() == KeyCode.SPACE) {
					controller.done();
				}
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	/**
	 * Renders graphics
	 */
	public synchronized void render() {
		graphics.clear(0, 0, (int)canvas.getWidth(), (int)canvas.getHeight());
		
		if(null != mapRenderer) {
			mapRenderer.render(true);
		}
		
		drawSelector();
		
		for(Entity entity : gameEntities) {
			BufferedImage image = entity.getImage();
			graphics.drawImage(image, entity.getPosition().x, entity.getPosition().y, image.getWidth(), image.getHeight());
		}
		
		drawCurrentPlayer();
	}
	
	@Override
	public void setSelector(Point location) {
		selectorLocation = location;
	}
	
	/**
	 * Draws selector ???
	 */
	private void drawSelector() {
		if(selectorLocation != null && currentPlayer != null) {
			graphics.drawHollowRect(selectorLocation.x * OrthogonalMapRenderer.TILE_WIDTH, 
					selectorLocation.y * OrthogonalMapRenderer.TILE_HEIGHT, 
					OrthogonalMapRenderer.TILE_WIDTH, 
					OrthogonalMapRenderer.TILE_HEIGHT, 3.0, 
					currentPlayer.getColor().getRGB());
		}
	}
	
	
	
	/**
	 * Draws the current player's sprite
	 */
	private void drawCurrentPlayer() {
		if(currentPlayer != null) {
			BufferedImage hs = currentPlayer.getHeadshot();
			float ratio = (float)hs.getHeight()/hs.getWidth();
			int newWidth = 75;
			int newHeight = (int)(newWidth*ratio);
			graphics.drawImage(currentPlayer.getHeadshot(), 15, 450, newWidth, newHeight);
			graphics.drawText(currentPlayer.toString(), new Point(100, 500));
		}
	}
	
	@Override
	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	@Override
	public void setGameEntities(List<Entity> gameEntities) {
		this.gameEntities = gameEntities;
	}

	@Override
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;		
	}

	@Override
	public GameMap getGameMap() {
		return gameMap;
	}

}

class RenderTask<Void> extends Task<Void> {
	public MapView view;
	public boolean interrupt;
	public RenderTask(MapView view) {
		this.view = view;
	}
	@Override
	protected Void call() throws Exception {
		while(true) {
			try {
				view.render();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(interrupt)
				break;
		}
		return null;
	}
}
