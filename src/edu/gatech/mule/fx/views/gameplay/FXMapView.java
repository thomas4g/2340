package edu.gatech.mule.fx.views.gameplay;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import edu.gatech.mule.core.FXApplication;
import edu.gatech.mule.fx.graphics.FXGraphics;
import edu.gatech.mule.fx.views.FXView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.ImageEntity;
import edu.gatech.mule.game.Message;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;
import edu.gatech.mule.map.maps.GameMap;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.screen.controllers.gameplay.TownController;
import edu.gatech.mule.screen.views.TownMapView;

/**
 * View for main map.
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
	private Message message;

	private final ObservableList<ResourceType> muleTypes;

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

	@FXML
	private Label prompt;

	@FXML
	private ProgressIndicator timer;


	private static final double BORDER_WIDTH = 5.0;

	private static final int X_STAT_START = 160;
	private static final int X_STAT_SPACE = 120;
	private static final int Y_STAT_SPACE = 420;

	private static final int HUH = 45;
	private static final int WUT = 16;

	private static final int X_MESSAGE = 25;
	private static final int Y_MESSAGE = 510;

//	private static final int MAX_PLAYERS = 4;
	private static final int X_TIMER = 30;
	private static final int Y_TIMER = Y_STAT_SPACE;
	private final int HEIGHT=FXApplication.HEIGHT;
	private final int WIDTH=FXApplication.WIDTH;
	private int clockInterval=0;

	/**
	 * Constructor for map view.
	 */
	public FXMapView() {
		super("map");
		muleTypes = FXCollections.observableArrayList();
	}

	@Override
	public void load() {
		super.load();
	

		canvas = new Canvas(FXApplication.WIDTH, FXApplication.HEIGHT);
		canvasContainer.getChildren().add(0, canvas);

		muleSelectorOverlay.setVisible(false);
		muleLabels = new Label[]{food, energy, smithore, crystite};
		textMuleColor();

		storeSelectorOverlay.setVisible(false);
		buySellQuit = new Label[]{buy, sell, quit};
		textStoreColor();

		textOverlay.setVisible(false);

		canvasContainer.addEventHandler(KeyEvent.KEY_PRESSED,
				new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent event) {
						if (event.getCode() == CANCEL_KEY) {
							displayMuleSelector(false);
							storeSelectorOverlay.setVisible(false);
							textOverlay.setVisible(false);
						}
					}
		});

		graphics = new FXGraphics(canvas.getGraphicsContext2D());
		mapRenderer = new OrthogonalMapRenderer(gameMap, graphics);
		wireKeyboard();

		drawSelector();
	}

	/**
	 * Wires the key board onto the game.
	 */
	private void wireKeyboard() {
		canvas.setFocusTraversable(true);
		canvas.requestFocus();
		canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent k) {
				if (k.getCode().isArrowKey()) {
					controller.move(
						k.getCode() == LEFT_KEY ? -1
								: k.getCode() == RIGHT_KEY ? 1 : 0,
						k.getCode() == DOWN_KEY ? 1
								: k.getCode() == UP_KEY ? -1 : 0);
				} else if (k.getCode().equals(ACTION_KEY)) {
					controller.action();
				} else if (k.getCode() == CANCEL_KEY) {
					controller.done();
				}
			}
		});
	}

	/**
	 * Renders graphics.
	 */
	public void render() {
		graphics.clear(0,
					   0,
					   (int) canvas.getWidth(),
					   (int) canvas.getHeight());

		if (mapRenderer != null) {
			mapRenderer.render(true);
		}
		drawSelector();

		for (Entity entity : gameEntities) {
			graphics.drawEntity(entity);
		}
		//drawGrain();
		drawClock();
		//drawPlayers();

		if (storeResources != null) {
			drawStoreResources();
		}

		if(message != null) {
			graphics.drawText(message.getMessage(), new Point(X_MESSAGE, Y_MESSAGE));
		}
	}
	
	private void drawClock(){
		clockInterval=Math.max(clockInterval, currentPlayer.getCurrentTurn().getLength());
		graphics.drawText("Time left: "
				+ Integer.toString(currentPlayer.getCurrentTurn().getLength()),
				new Point(X_TIMER, Y_TIMER));
		//TODO finish this
		//BufferedImage clock=loadImage("/assets/bottom/time/c"++".png");
		
	}
	
	private void drawGrain(){
		BufferedImage image=loadImage("/assets/bottom/grain.png");
		graphics.drawImage(image, 0, Y_TIMER-10,WIDTH, HEIGHT-Y_TIMER);
	}

	/**
	 * Draw store resources.
	 */
	private void drawStoreResources() {
		for (int i = 0; i < gameMap.getTiles().length; i++) {
			for (int j = 0; j < gameMap.getTiles()[0].length; j++) {
				GameTile t = gameMap.getTiles()[i][j];
				String tt = t.getProperties().getProperty("resource_type");

				for(int k = 0; k < storeResources.length; k++) {
					String rt = ResourceType.values()[k].name();

					if (rt.equalsIgnoreCase(tt)) {
						graphics.drawText(Integer.toString(storeResources[k]),
								new Point(t.getWidth() * i + t.getWidth() / 2, HUH),
								Color.WHITE,
								WUT);
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
	 * Draws selector.
	 */
	private void drawSelector() {
		if(selectorLocation != null && currentPlayer != null) {
			graphics.drawHollowRect(
				selectorLocation.x * OrthogonalMapRenderer.getTileWidth(),
				selectorLocation.y * OrthogonalMapRenderer.getTileHeight(),
				OrthogonalMapRenderer.getTileWidth(),
				OrthogonalMapRenderer.getTileHeight(),
				BORDER_WIDTH,
				currentPlayer.getColor().getRGB()
				);
		}
	}

	private void drawPlayers() {
		BufferedImage hs = currentPlayer.getHeadshot();
		float ratio = (float) hs.getWidth() / hs.getHeight();
		int newHeight = 100;
		int newWidth = (int) (newHeight * ratio);
		graphics.drawImage(hs, 30, 420, newWidth, newHeight);
		

		int i = 0;
		for (Player player : players) {
			if (player.equals(currentPlayer)) {
				graphics.drawText(player.getResourceString(),
						new Point(X_STAT_START + X_STAT_SPACE * i, Y_STAT_SPACE));
			} else {
				graphics.drawGreyedText(player.getResourceString(),
						new Point(X_STAT_START + X_STAT_SPACE * i, Y_STAT_SPACE));
			}
			i++;
		}
	}

	/**
	 * Draws the owned-land indicators.
	 * TODO give tiles access to their own location!!
	 * So that I can draw just owned tiles
	 */
	private void drawLands() {
		for(Player player : players) {
			for(GameTile tile : player.getLands()) {
				if(tile.getOwner() != null) {
					BufferedImage totem = player.getTotem();
//					graphics.drawImage(totem,
//							x * tile.getWidth(),
//							y * tile.getHeight(),
//							totem.getWidth(),
//							totem.getHeight());
//					graphics.drawHollowRect(x * tileWidth,
//							y * tileHeight,
//							tileWidth,
//							tileHeight,
//							4.0,
//							tile.getOwner().getColor().getRGB());
				}
			}
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

	private int store;
	private static String[] options = {"buy", "sell", "quit"};

	/**
	 * Scrolls store toggle to left.
	 */
	private void storeLeft() {
		store = mod(--store, options.length);
		textStoreColor();
	}

	/**
	 * Scrolls store toggle to right.
	 */
	private void storeRight() {
		store = mod(++store, options.length);
		textStoreColor();
	}

	/**
	 * Store actions based on key events.
	 * @param event key pressed
	 */
	@FXML
	protected void storeAction(KeyEvent event) {
		if (event.getCode() == UP_KEY) {
			storeLeft();
		} else if (event.getCode() == DOWN_KEY) {
			storeRight();
		} else if (event.getCode() == ACTION_KEY) {
			displayStoreSelector(false);
			if (options[store].equals("buy")) {
				displayStoreAmountMenu(true);
			} else if (options[store].equals("sell")) {
				displayStoreAmountMenu(false);
			}
		} else if (event.getCode() == CANCEL_KEY) {
			displayMuleSelector(false);
		}
	}

	/**
	 * Sets color of toggle.
	 */
	private void textStoreColor() {
		for (Label lab : buySellQuit) {
			lab.setTextFill(FXView.NORMAL);
		}
		selectedStore();
	}

	/**
	 * Sets selected text to selected color.
	 */
	private void selectedStore() {
		buySellQuit[store].setTextFill(FXView.SELECTED);
	}

	/**
	 * Displays store selector.
	 * @param isVisible whether selector will be visible or not
	 */
	private void displayStoreSelector(boolean isVisible) {
		storeSelectorOverlay.setVisible(isVisible);
		storeSelect.setVisible(isVisible);
		if (isVisible) {
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

	@Override
	public void displayStoreAmountMenu(final boolean buying) {
		textOverlay.setVisible(true);
		textField.requestFocus();
		textField.addEventHandler(KeyEvent.KEY_PRESSED,
								  new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == ACTION_KEY) {
					int count = 0;
					try {
						count = Integer.parseInt(textField.getText());
					} catch (NumberFormatException ex) {
						System.out.println("Silly alien, that's not a number!");
					}
					textOverlay.setVisible(false);
					townController.storeComplete(count, buying);
				} else if (event.getCode() == CANCEL_KEY) {
					textOverlay.setVisible(false);
				}
			}

		});
	}

	@Override
	public void setStoreResourceAmounts(int[] resources) {
		storeResources = resources;
	}

	private int mule;
	private static ResourceType[] res = {ResourceType.FOOD,ResourceType.ENERGY, 
										ResourceType.SMITHORE, ResourceType.CRYSTITE, };

	/**
	 * Toggles mule selector to the left.
	 */
	private void muleLeft() {
		mule = mod(--mule, res.length);
		textMuleColor();
	}

	/**
	 * Toggles mule selector to the right.
	 */
	private void muleRight() {
		mule = mod(++mule, res.length);
		textMuleColor();
	}
	/**
	 * Actions of mule selector based on key event.
	 * @param event key pressed
	 */
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

	/**
	 * Sets up mule selector text.
	 */
	private void textMuleColor() {
		for(Label lab : muleLabels) {
			lab.setTextFill(FXView.NORMAL);
		}
		selectedMule();
	}

	/**
	 * Colors selected mule text to selected color.
	 */
	private void selectedMule() {
		muleLabels[mule].setTextFill(FXView.SELECTED);
	}

	/**
	 * Displays mule selector.
	 * @param isVisible, whether selector will be visible
	 */
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
		if(muleSelectorOverlay.isVisible()) {
			return;
		}
		displayMuleSelector(true);
	}

	@Override
	public void setMuleOptions(ResourceType[] mules) {
		muleTypes.clear();
		muleTypes.addAll(mules);
	}

	@Override
	public void setMessage(Message message) {
		this.message = message;
	}
	
	private BufferedImage loadImage(String src) {
		try {
			
			return ImageIO.read(FXMapView.class.getResource(src));
		} catch (IOException e) {
			e.printStackTrace();
			return new BufferedImage(0, 0, 0);
		}
	}

}
