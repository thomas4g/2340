package edu.gatech.mule.fx.screens.views;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import tiled.core.Tile;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import edu.gatech.mule.fx.graphics.FXGraphics;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Settings.Color;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.map.tiles.PropertyTile;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
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
	private Player currentPlayer;
	private Point selectorLocation;
	private boolean interrupt = false;
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
		canvas = new Canvas(720, 700);
		node = canvas;
		graphics = new FXGraphics(canvas.getGraphicsContext2D());
		wireKeyboard();
		
//		Task<Void> t = new RenderTask<Void>(this);
//		new Thread(t).start();

		render();
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
					controller.action();
				}
				else if(k.getCode() == KeyCode.S) {
					controller.done();
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
	}

	public synchronized void render() {
		graphics.getGraphicsContext().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		if(null == mapRenderer) {
			mapRenderer = new OrthogonalMapRenderer(gameMap.getMap());
		}
		mapRenderer.render(graphics);
		
		for(int x=0;x<gameMap.getTiles().length;x++) {
			for(int y=0;y<gameMap.getTiles()[x].length;y++) {
				if(gameMap.getTiles()[x][y].getOwner() != null) {
					graphics.drawImage(
							gameMap.getTile(x, y).getOwner().getTotem(),
							new Point(x*OrthogonalMapRenderer.TILE_WIDTH+5,
							y*OrthogonalMapRenderer.TILE_HEIGHT+5)); 
				}
				
				graphics.getGraphicsContext().setLineWidth(1);
				graphics.getGraphicsContext().setStroke(new javafx.scene.paint.Color(0,0,0,.5));
				graphics.getGraphicsContext().strokeRect(
						x*OrthogonalMapRenderer.TILE_WIDTH, 
						y*OrthogonalMapRenderer.TILE_HEIGHT,
						OrthogonalMapRenderer.TILE_WIDTH, 
						OrthogonalMapRenderer.TILE_HEIGHT);
			}
		}
		
		drawSelector();
		
		for(Entity entity : gameEntities) {
			graphics.drawImage(entity.getImage(), entity.getPosition());
		}
		
		drawCurrentPlayer();
	}
	
	@Override
	public void setSelector(Point location) {
		selectorLocation = location;
	}
	
	private void drawSelector() {
		if(selectorLocation != null && currentPlayer != null)
			graphics.drawSelector(selectorLocation, fxColor(currentPlayer.getColor()));
	}
	
	private javafx.scene.paint.Color fxColor(Color color) {
		return new javafx.scene.paint.Color(color.red/255.0, color.green/255.0, color.blue/255.0, 1);
	}
	
	private void drawCurrentPlayer() {
		if(currentPlayer != null) {
			BufferedImage hs = currentPlayer.getHeadshot();
			float ratio = (float)hs.getHeight()/hs.getWidth();
			int newWidth = 75;
			int newHeight = (int)(newWidth*ratio);
			int y = (int)(canvas.getHeight()-2*newHeight);
			System.out.println(y);
			graphics.drawImage(currentPlayer.getHeadshot(), new Point(15, 450), newWidth, newHeight);
			graphics.drawText(currentPlayer.toString(), new Point(100, 500));
		}
	}
	
	
	@Override
	public void setGameMap(GameMap gameMap) {
		this.gameMap =gameMap;
	}

	@Override
	public void setGameEntities(List<Entity> gameEntities) {
		this.gameEntities = gameEntities;
	}

	@Override
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;		
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
