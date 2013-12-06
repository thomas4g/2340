package edu.gatech.mule.fx.views.gameplay;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import javax.imageio.ImageIO;

import edu.gatech.mule.fx.graphics.FXGraphics;
import edu.gatech.mule.fx.views.FXView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Message;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.game.round.Turn;
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
	private ImageView background;
	@FXML
	private GridPane backgroundOverlay;

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
	private Label player1Info;
	@FXML
	private ImageView player1Tile;
	@FXML
	private Label player2Info;
	@FXML
	private ImageView player2Tile;
	@FXML
	private Label player3Info;
	@FXML
	private ImageView player3Tile;
	@FXML
	private Label player4Info;
	@FXML
	private ImageView player4Tile;
	@FXML
	private Label storeInfo;
	@FXML
	private ImageView storeTile;

	private Label[] playerLabels;
	private ImageView[] playerTiles;
	private Image[] playerActiveImages;
	private Image[] playerInactiveImages;

	@FXML
	private ImageView clock;

	private boolean buying = true;

	private static final double BORDER_WIDTH = 5.0;

//	private static final int Y_STAT_SPACE = 420;

	private static final int FONT_SIZE = 16;

	private static final int X_MESSAGE = 25;
	private static final int Y_MESSAGE = 510;

	private static final int CLOCK_INTERVAL = 6;

	private static final int STORE_RES_Y = 45;

	private ArrayList<BufferedImage> clockFrames;

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

		backgroundOverlay.setVisible(false);

		canvas = new Canvas(canvasContainer.getPrefWidth(), canvasContainer.getPrefHeight());
		canvasContainer.getChildren().add(0, canvas);

		muleSelectorOverlay.setVisible(false);
		muleLabels = new Label[]{food, energy, smithore, crystite};
		playerLabels = new Label[] {player1Info, player2Info, player3Info, player4Info};
		playerTiles = new ImageView[] {player1Tile, player2Tile, player3Tile, player4Tile};

		if(clockFrames == null) {
			clockFrames = new ArrayList<>();
			for(int i = 0; i < CLOCK_INTERVAL; i++) {
				String clockString = "/assets/bottom/time/c" + i + ".png";
				clockFrames.add(loadImage(clockString));
			}
		}

		textMuleColor();

		storeSelectorOverlay.setVisible(false);
		buySellQuit = new Label[]{buy, sell, quit};
		textStoreColor();

		textOverlay.setVisible(false);

		graphics = new FXGraphics(canvas.getGraphicsContext2D());
		mapRenderer = new OrthogonalMapRenderer(gameMap, graphics);
		setupPlayerTiles();
		wireKeyboard();
		drawSelector();
	}

	private void setupPlayerTiles() {
		playerActiveImages = new Image[players.size()];
		playerInactiveImages = new Image[players.size()];
		for(int i = 0; i < players.size(); i++) {
			String res = "/assets/bottom/wood/p" + (players.get(i).getColor().ordinal() + 1);

			playerActiveImages[i] = graphics.createImage(loadImage(res + "d.png"));
			playerInactiveImages[i] = graphics.createImage(loadImage(res + "l.png"));

		}
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

		textField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				if(e.getCode() == ACTION_KEY) {
					storeComplete(buying);
				}
			}
		});
	}

	/**
	 * Renders graphics.
	 */
	public void render() {
		graphics.clear(0, 0,
					   (int) canvas.getWidth(),
					   (int) canvas.getHeight());

		if (mapRenderer != null) {
			mapRenderer.render(true);
		}
		drawSelector();

		for (Entity entity : gameEntities) {
			graphics.drawEntity(entity);
		}
		drawClock();
		drawPlayers();

		if (storeResources != null) {
			drawStoreResources();
		} else {
			drawLands();
		}

		if(message != null) {
			graphics.drawText(message.getMessage(), new Point(X_MESSAGE, Y_MESSAGE));
		}
	}

	private void drawClock() {
		int clockNum = (CLOCK_INTERVAL - (int)
				((double) currentPlayer.getCurrentTurn().getRemaining()
						/ Turn.NORMAL_TURN * CLOCK_INTERVAL) + CLOCK_INTERVAL - 1) % CLOCK_INTERVAL;
		clock.setImage(graphics.createImage(clockFrames.get(clockNum)));
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
								new Point(t.getWidth() * i + t.getWidth() / 2,
								STORE_RES_Y),
								Color.WHITE,
								FONT_SIZE);
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
		int i = 0;
		for (Player player : players) {
			playerTiles[i].setImage(
				player.equals(currentPlayer) ? playerActiveImages[i] : playerInactiveImages[i]);
			playerLabels[i++].setText(player.getResourceString());
		}
		if(storeResources != null) {
			String resString = "STORE\n";
			for(int j = 0; j < storeResources.length; j++) {
				resString += ResourceType.values()[j].name() + ": " + storeResources[j] + "\n";
			}
			storeInfo.setText(resString);
		}
	}

	/**
	 * Draws the owned-land indicators.
	 * TODO give tiles access to their own location!!
	 * So that I can draw just owned tiles
	 */
	private void drawLands() {
//		for(Player player : players) {
//			for(GameTile tile : player.getLands()) {
//				if(tile.getOwner() != null) {
//					BufferedImage totem = player.getTotem();
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
//				}
//			}
//		}
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
				buying = true;
			} else if (options[store].equals("sell")) {
				buying = false;
			}
			displayStoreAmountMenu();
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
		backgroundOverlay.setVisible(isVisible);
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
	public void displayStoreAmountMenu() {
		textOverlay.setVisible(true);
		backgroundOverlay.setVisible(true);
		textField.requestFocus();
	}

	/**
	 * Store finishes store.
	 * @param buying whether buying or not
	 */
	public void storeComplete(boolean buying) {
		int count = 0;
		try {
			count = Integer.parseInt(textField.getText());
		} catch(NumberFormatException nfe) {
			System.out.println("Not a number!");
		}
		textOverlay.setVisible(false);
		backgroundOverlay.setVisible(false);
		townController.storeComplete(count, buying);
	}

	@Override
	public void setStoreResourceAmounts(int[] resources) {
		storeResources = resources;
	}

	private int mule;
	private static ResourceType[] res = {ResourceType.FOOD, ResourceType.ENERGY,
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
		backgroundOverlay.setVisible(isVisible);
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
			return null;
		}
	}

}
