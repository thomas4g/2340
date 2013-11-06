package edu.gatech.mule.fx.screens.views;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import edu.gatech.mule.fx.graphics.FXGraphics;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
import edu.gatech.mule.screen.screens.controllers.TownController;
import edu.gatech.mule.screen.screens.views.TownMapView;

/**
 * View for main map
 * @version 1.0
 */
public class FXMapView extends FXView implements TownMapView {
	private StackPane stack; //add stuff to me!
	private Canvas canvas;
	private FXGraphics graphics;
	private OrthogonalMapRenderer mapRenderer;
	private GameMap gameMap;
	private List<Entity> gameEntities;
	private Player currentPlayer;
	private Point selectorLocation;
	
	private TownController townController;

	/**
	 * Constructor for map view
	 */
	public FXMapView() {
		super("");
	}
	
	@Override
	public void load() {
		stack = new StackPane();
		canvas = new Canvas(720, 700);
		stack.getChildren().add(canvas);
		node = stack;
		graphics = new FXGraphics(canvas.getGraphicsContext2D());
		mapRenderer = new OrthogonalMapRenderer(gameMap, graphics);
		wireKeyboard();
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

	/**
	 * Renders graphics
	 */
	public void render() {

		graphics.clear(0, 0, (int)canvas.getWidth(), (int)canvas.getHeight());
		
		if(mapRenderer != null) {
			mapRenderer.render(true);
		}
		drawSelector();
		
		for(Entity entity : gameEntities) {
			graphics.drawEntity(entity);
		}
		
		graphics.drawText(Integer.toString(currentPlayer.getCurrentTurn().getLength()), new Point(700, 500));
		
		drawCurrentPlayer();
	}
	
	@Override
	public void setSelector(Point location) {
		selectorLocation = location;
	}
	
	/**
	 * Draws selector
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

	@Override
	public void setController(TownController controller) {
		townController = controller;
	}

	@Override
	public void displayStoreMenu() {
		final FlowPane flow = new FlowPane();
		final ObservableList<String> buySell = FXCollections.observableArrayList("Buy", "Sell");
		final ComboBox<String> cb = new ComboBox<String>(buySell);
		
		cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String arg1, String selected) {
				if(selected.equals(buySell.get(0))){
					stack.getChildren().remove(flow);
					displayStoreAmountMenu(true);
				}
				else if(selected.equals(buySell.get(1))) {
					stack.getChildren().remove(flow);
					displayStoreAmountMenu(false);
				}
			}
			
		});
		flow.getChildren().add(cb);
		stack.getChildren().add(cb);		
	}

	@Override
	public void displayStoreAmountMenu(final boolean buying) {
		final FlowPane flow = new FlowPane();
		final TextField amount = new TextField();
		Button done = new Button("Confirm");
		done.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				stack.getChildren().remove(flow);
				
				int count = 0;
				try {
					count = Integer.parseInt(amount.getText());
				}
				catch(NumberFormatException ex) {
					
				}
				townController.storeComplete(count, buying);
			}
			
		});
		
		flow.getChildren().add(amount);
		flow.getChildren().add(done);
		stack.getChildren().add(flow);
	}
}
