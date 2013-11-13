package edu.gatech.mule.fx.screens.views.gameplay;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	private TextField textField;
	@FXML 
	private HBox playerPanel;
	
	@FXML
	private Button muleSelect;
	@FXML
	private Label food;
	@FXML
	private Label energy;
	@FXML
	private Label smithore;
	@FXML
	private Label crystite;
	private Label[] muleLabels;
	
	@FXML
	private Button storeSelect;
	@FXML
	private Label buy;
	@FXML
	private Label sell;
	@FXML
	private Label quit;
	private Label[] buySellQuit;
	
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
		muleLabels = new Label[]{food, energy, smithore, crystite};
		textMuleColor();
		
		storeSelectorOverlay.setVisible(false);
		buySellQuit = new Label[]{buy, sell, quit};
		textStoreColor();
		
		textOverlay.setVisible(false);
		
		//storeSelector.setItems(buySell);
		//muleSelector.setItems(muleTypes);
		
		canvasContainer.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == CANCEL_KEY) {
					displayMuleSelector(false);
					storeSelectorOverlay.setVisible(false);
					textOverlay.setVisible(false);
				}
			}
		});
		
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
							k.getCode() == LEFT_KEY ? -1 : k.getCode() == RIGHT_KEY ? 1 : 0,
							k.getCode() == DOWN_KEY ? 1 : k.getCode() == UP_KEY ? -1 : 0);
				}
				else if(k.getCode().equals(ACTION_KEY)){
					controller.action();
				}
				else if(k.getCode() == SKIP_KEY) {
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
								Color.WHITE,
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
		BufferedImage hs = currentPlayer.getHeadshot();
		float ratio = (float)hs.getWidth()/hs.getHeight();
		int newHeight = 100;
		int newWidth = (int)(newHeight*ratio);
		graphics.drawImage(hs, 30, 420, newWidth, newHeight);
		
		int i = 0;
		for(Player player : players) {
			if(player.equals(currentPlayer)) {
				graphics.drawText(player.display(), new Point(160+120*i, 420));
			} else {
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
	
	// store select
	
	private int store;
	private static String[] BSQyum = {"buy","sell","quit"};
	
	private void storeLeft() {
		store = mod(--store,BSQyum.length);
		textStoreColor();
	}
	
	private void storeRight() {
		store = mod(++store,BSQyum.length);
		textStoreColor();
	}
	
	@FXML
	protected void storeAction(KeyEvent event) {
		if (event.getCode() == UP_KEY) {
			storeLeft();
		} else if (event.getCode() == DOWN_KEY) {
			storeRight();
		} else if (event.getCode() == ACTION_KEY) {
			displayStoreSelector(false);
			if(BSQyum[store].equals("buy")) {
				displayStoreAmountMenu(true);
			} else if(BSQyum[store].equals("sell")) {
				displayStoreAmountMenu(false);
			}
		} else if (event.getCode() == CANCEL_KEY) {
			displayMuleSelector(false);
		}
	}
	
	private void textStoreColor() {
		for(Label lab : buySellQuit) {
			lab.setTextFill(FXView.NORMAL);
		}
		selectedStore();
	}
	
	private void selectedStore() {
		buySellQuit[store].setTextFill(FXView.SELECTED);
	}
	
	private void displayStoreSelector(boolean isVisible) {
		storeSelectorOverlay.setVisible(isVisible);
		storeSelect.setVisible(isVisible);
		if(isVisible) {
			storeSelect.requestFocus();
			store = 0;
			textStoreColor();
		}
	}

	@Override
	public void displayStoreMenu() {
		displayStoreSelector(true);
		storeSelect.requestFocus();
	}
	
	// store amount input

	@Override
	public void displayStoreAmountMenu(final boolean buying) {
		textOverlay.setVisible(true);
		textField.requestFocus();
		textField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == ACTION_KEY) {
					int count = 0;
					try {
						count = Integer.parseInt(textField.getText());
					} catch(NumberFormatException ex) {
						System.out.println("Silly alien, that's not a number!");
					}
					textOverlay.setVisible(false);
					townController.storeComplete(count, buying);
				} else if(event.getCode() == CANCEL_KEY) {
					textOverlay.setVisible(false);
				}
			}
			
		});
	}
	

	@Override
	public void setStoreResourceAmounts(int[] resources) {
		storeResources = resources;
	}
	
	// mule selection
	
	private int mule;
	private static ResourceType[] res = {ResourceType.FOOD, ResourceType.ENERGY, 
										ResourceType.SMITHORE, ResourceType.CRYSTITE};
	
	private void muleLeft() {
		mule = mod(--mule,res.length);
		textMuleColor();
	}
	
	private void muleRight() {
		mule = mod(++mule,res.length);
		textMuleColor();
	}
	
	@FXML
	protected void muleAction(KeyEvent event) {
		if (event.getCode() == UP_KEY) {
			muleLeft();
		} else if (event.getCode() == DOWN_KEY) {
			muleRight();
		} else if (event.getCode() == ACTION_KEY) {
			System.out.println("Look at my MULE, my MULE is amazing.");
			displayMuleSelector(false);
			townController.setMuleType(res[mule]);
		} else if (event.getCode() == CANCEL_KEY) {
			displayMuleSelector(false);
		}
	}
	
	private void textMuleColor() {
		for(Label lab : muleLabels) {
			lab.setTextFill(FXView.NORMAL);
		}
		selectedMule();
	}
	
	private void selectedMule() {
		muleLabels[mule].setTextFill(FXView.SELECTED);
	}
	
	private void displayMuleSelector(boolean isVisible) {
		muleSelectorOverlay.setVisible(isVisible);
		muleSelect.setVisible(isVisible);
		if(isVisible) {
			muleSelect.requestFocus();
			mule = 0;
			textMuleColor();
		}
	}

	@Override
	public void displayMuleOptions() {
		if(muleSelectorOverlay.isVisible()) return;
		displayMuleSelector(true);
	}
	
	@Override
	public void setMuleOptions(ResourceType[] mules) {
		muleTypes.clear();
		muleTypes.addAll(mules);
//		muleSelector.setItems(FXCollections.observableArrayList(mules));
	}
}
