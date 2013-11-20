package edu.gatech.mule.screen.controllers.gameplay;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.CharacterType.Direction;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.game.store.Store;
import edu.gatech.mule.game.store.Transaction;
import edu.gatech.mule.map.tiles.TileType;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;
import edu.gatech.mule.screen.views.TownMapView;

/**
 * Controller for town map.
 * @version 0.1
 */
public class TownController extends MapController {

	public static final int MOVEMENT = 10;
	private TownMapView view;
	private Store store;

	/**
	 * Constructor for town controller.
	 * @param game game engine
	 * @param view map view
	 */
	public TownController(GameEngine game, TownMapView view) {
		super(game, view, MOVEMENT);
		this.view = view;
	}

	@Override
	//@TODO Change this logic so that it's being handled from within the tiles
	public void move(int x, int y) {
		super.move(x, y);
		if((currentPlayer.getTileType() == TileType.EXITTOWN_LEFT
			&& currentPlayer.getDirection() == Direction.LEFT)
			||
			(currentPlayer.getTileType() == TileType.EXITTOWN_RIGHT
			&& currentPlayer.getDirection() == Direction.RIGHT)) {
			game.setScreen(ScreenType.GAME_SCREEN);
		} else if(currentPlayer.getTileType() == TileType.PUB) {
			done();
		} else if(currentPlayer.getTileType() == TileType.RESOURCE_STORE) {
			view.displayStoreMenu();
		} else if(currentPlayer.getTileType() == TileType.MULE_STORE && !currentPlayer.hasMule()) {
			view.displayMuleOptions();
		}
	}

	@Override
	public void load() {
		//this override
		view.setController(this);
		this.map = game.getTownMap();
		super.load();

		currentPlayer.useBigSprites(true);

		Point p = new Point(0, 0);
		switch(currentPlayer.getDirection()) {
		case DOWN:
			p.x = (int) map.getWidth() * map.getTileWidth() / 2;
			p.y = 0;
			break;
		case LEFT:
			p.y = (int) map.getHeight() * map.getTileHeight() / 2;
			p.x = (int) map.getWidth() * map.getTileWidth();
			break;
		case RIGHT:
			p.y = (int) map.getHeight() * map.getTileHeight() / 2;
			p.x = 0;
			break;
		case UP:
			p.y = (int) map.getHeight() * map.getTileHeight();
			p.x = (int) map.getWidth() * map.getTileWidth() / 2;
			break;
		default:
			break;
		}
		currentPlayer.setPosition(p);

		if(store == null) {
			//@TODO Law of Demeter violation much?!
			store = new Store(game.getSettings().getDifficulty().getStoreResources(),
					new int[] {1, 2, 3, 4, 5});
		}

		List<ResourceType> muleTypes = new ArrayList<ResourceType>(
				Arrays.asList(ResourceType.values()));

		muleTypes.remove(ResourceType.MULE);
		view.setMuleOptions(muleTypes.toArray(new ResourceType[]{}));
		view.setStoreResourceAmounts(store.getResources());
		view.setPlayers(game.getSettings().getPlayers());
	}

	@Override
	public void done() {
		turn.done();
	}

	/**
	 * Called when a transaction has been completed in GUI.
	 * @param count the number of things being bought or sold
	 * @param buying whether or not they're buying or selling
	 */
	public void storeComplete(int count, boolean buying) {
		int[] rDeltas = new int[5];

		//@TODO Again with the Law of Demeter violations!
		ResourceType type = ResourceType.valueOf(
				currentPlayer.getTile().getProperties().getProperty("resource_type").toUpperCase());
		rDeltas[type.ordinal()] = count;
		Transaction transaction = new Transaction(rDeltas, store.getPrices());
		if(buying) {
			store.sell(transaction, currentPlayer);
		} else {
			currentPlayer.sell(transaction, store);
		}
	}

	/**
	 * Called when the player has selected a mule type in the GUI.
	 * @param type the type of mule
	 */
	public void setMuleType(ResourceType type) {
		if(currentPlayer.getMule() != null) {
			return;
		}

		mule = new Mule(currentPlayer, CharacterType.MULE);
		mule.setType(type);
		this.entities.add(mule);
		currentPlayer.setMule(mule);
		mule.useBigSprites(true);

	}
}
