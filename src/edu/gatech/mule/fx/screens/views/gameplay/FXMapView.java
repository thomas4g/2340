package edu.gatech.mule.fx.screens.views.gameplay;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import edu.gatech.mule.fx.graphics.FXGraphics;
import edu.gatech.mule.fx.screens.views.FXView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
import edu.gatech.mule.screen.screens.controllers.gameplay.TownController;
import edu.gatech.mule.screen.screens.views.TownMapView;

/**
 * View for main map
 * @version 1.0
 */
public class FXMapView extends FXView implements TownMapView {
	private Canvas canvas;
	private FXGraphics graphics;
	private OrthogonalMapRenderer mapRenderer;
	private GameMap gameMap;
	private List<Entity> gameEntities;
	private Player currentPlayer;
	private List<Player> players;
	private Point selectorLocation;
	private int[] storeResources;
	private TownController townController;
	
	final private ObservableList<String> buySell;
	final private ObservableList<ResourceType> muleTypes;
	
	@FXML
	private StackPane canvasContainer;
	@FXML
	private GridPane storeSelectorOverlay;
	@FXML
	private GridPane textOverlay;
	@FXML
	private ChoiceBox<String> storeSelector;
	@FXML
	private GridPane muleSelectorOverlay;
	@FXML
	private ChoiceBox<ResourceType> muleSelector;
	@FXML
	private TextField textField;
	@FXML 
	private HBox playerPanel;
	
	/**
	 * Constructor for map view
	 */
	public FXMapView() {
		super("map");
		buySell = FXCollections.observableArrayList("Buy", "Sell");
		muleTypes = FXCollections.observableArrayList();
	}

	@Override
	public void load() {
		super.load();

		canvas = new Canvas(720, 520);
		canvasContainer.getChildren().add(0, canvas);
		muleSelectorOverlay.setVisible(false);
		storeSelectorOverlay.setVisible(false);
		textOverlay.setVisible(false);
		
		storeSelector.setItems(buySell);
		muleSelector.setItems(muleTypes);
		
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
				else if(k.getCode() == KeyCode.S) {
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
		
		drawPlayers();
		
		if(storeResources != null) {
			drawStoreResources();
		}
	}
	
	// THIS IS BAD UGLY TERRIBLE FIX FIX FIX
	// TODO FIX FIX FIX
	private void drawStoreResources() {
		for(int i=0;i<gameMap.getTiles().length;i++) {
			for(int j=0;j<gameMap.getTiles()[0].length;j++) {
				GameTile t = gameMap.getTiles()[i][j];
				String tt = t.getProperties().getProperty("resource_type");

				for(int k=0;k<storeResources.length;k++) {
					String rt = ResourceType.values()[k].name();
					
					if(rt.equalsIgnoreCase(tt)) {
						graphics.drawText(Integer.toString(storeResources[k]), 
								new Point(t.getWidth()*i + t.getWidth()/2, 45),
								Color.BLUE,
								16);
					}					
				}
			}
		}
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
	
	private void drawPlayers() {	
		BufferedImage hs = null;
		float ratio = 0;
		int newHeight, newWidth = 0;
		
		int i = 0;
		for(Player player : players) {
			hs = player.getHeadshot();
			ratio = (float)hs.getWidth()/hs.getHeight();
			newHeight = 100;
			newWidth = (int)(newHeight*ratio);
			if(player.equals(currentPlayer)) {
				graphics.drawImage(player.getHeadshot(), 160+120*i, 420, newWidth, newHeight);
				graphics.drawText(player.display(), new Point(160+120*i, 420));
			} else {
				graphics.drawImage(player.getHeadshot(), 160+120*i, 420, newWidth/2, newHeight/2);
				graphics.drawGreyedText(player.display(), new Point(160+120*i, 420));
			}
			i++;
		}
	}
	
	@Override
	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
		storeResources = null;
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
	public void setPlayers(List<Player> players) {
		this.players = players;
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
		storeSelectorOverlay.setVisible(true);
		storeSelector.requestFocus();
		storeSelector.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String arg1, String selected) {
				if(selected.equals(buySell.get(0))){
					storeSelectorOverlay.setVisible(false);
					displayStoreAmountMenu(true);
				}
				else if(selected.equals(buySell.get(1))) {
					storeSelectorOverlay.setVisible(false);
					displayStoreAmountMenu(false);
				}
			}
			
		});
	}

	@Override
	public void displayStoreAmountMenu(final boolean buying) {
		textOverlay.setVisible(true);
		textField.requestFocus();
		textField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					int count = 0;
					try {
						count = Integer.parseInt(textField.getText());
					}
					catch(NumberFormatException ex) {
						
					}
					textOverlay.setVisible(false);
					townController.storeComplete(count, buying);
				}
				else if(event.getCode() == KeyCode.ESCAPE) {
					textOverlay.setVisible(false);
				}
			}
			
		});
	}
	

	@Override
	public void setStoreResourceAmounts(int[] resources) {
		storeResources = resources;
	}

	@Override
	public void displayMuleOptions() {
		if(muleSelectorOverlay.isVisible()) return;
		muleSelectorOverlay.setVisible(true);
		muleSelector.requestFocus();
		muleSelector.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ResourceType>() {
			@Override
			public void changed(ObservableValue<? extends ResourceType> arg0,
					ResourceType arg1, ResourceType arg2) {
				if(arg2 != null) {
					muleSelectorOverlay.setVisible(false);
					townController.setMuleType(arg2);
				}
			}
		});

	}
	
	@Override
	public void setMuleOptions(ResourceType[] mules) {
		muleTypes.clear();
		muleTypes.addAll(mules);
//		muleSelector.setItems(FXCollections.observableArrayList(mules));
	}
}
