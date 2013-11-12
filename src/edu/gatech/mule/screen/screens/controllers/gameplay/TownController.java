package edu.gatech.mule.screen.screens.controllers.gameplay;

import java.awt.Point;
import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.CharacterType.Direction;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.map.TileType;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.game.store.Store;
import edu.gatech.mule.game.store.Transaction;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;
import edu.gatech.mule.screen.screens.views.TownMapView;

/**
 * Controller for town map
 * @version 0.1
 */
public class TownController extends MapController {
	
	public final static int MOVEMENT = 10;
	private TownMapView view;
	private Store store;	
	
	/**
	 * Constructor for town controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public TownController(GameEngine game, TownMapView view){
		super(game, view, MOVEMENT);
		this.view = view;
	}
	
	@Override
	public void move(int x, int y) {
		super.move(x, y);
		if(
			(currentPlayer.getTileType() == TileType.EXITTOWN_LEFT && currentPlayer.getDirection() == Direction.LEFT)
			||
			(currentPlayer.getTileType() == TileType.EXITTOWN_RIGHT && currentPlayer.getDirection() == Direction.RIGHT)) {
			game.setScreen(ScreenType.GAME_SCREEN);
		}
		else if(currentPlayer.getTileType() == TileType.PUB){
			done();
		}
		else if(currentPlayer.getTileType() == TileType.RESOURCE_STORE) {
			view.displayStoreMenu();
		}
		else if(currentPlayer.getTileType() == TileType.MULE_STORE){
//			setMuleType(ResourceType.CRYSTITE);
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
			p.x = (int) map.getMap().getWidth()*map.getTileWidth()/2;
			p.y = 0;
			break;
		case LEFT:
			p.y = (int) map.getMap().getHeight()*map.getTileHeight()/2;
			p.x = (int) map.getMap().getWidth()*map.getTileWidth();
			break;
		case RIGHT:
			p.y = (int) map.getMap().getHeight()*map.getTileHeight()/2;
			p.x = 0;
			break;
		case UP:
			p.y = (int) map.getMap().getHeight()*map.getTileHeight();
			p.x = (int) map.getMap().getWidth()*map.getTileWidth()/2;
			break;
		default:
			break;
		}
		currentPlayer.setPosition(p);
		
		if(store == null) {
			store = new Store(game.getSettings().getDifficulty().getStoreResources(), new int[] {1, 2, 3, 4, 5});
		}
		view.setStoreResourceAmounts(store.getResources());
		
		view.setPlayers(game.getSettings().getPlayers());
	}
	
	@Override
	public void done() {
		turn.done();
	}

	public void storeComplete(int count, boolean buying) {
		int[] rDeltas = new int[5];
		ResourceType type = ResourceType.valueOf(currentPlayer.getTile().getProperties().getProperty("resource_type").toUpperCase());
		rDeltas[type.ordinal()] = count;
		Transaction transaction = new Transaction(rDeltas, store.getPrices());
		if(buying) {
			store.sell(transaction, currentPlayer);
		} else {
			currentPlayer.sell(transaction, store);
		}
	}

	public void setMuleType(ResourceType type) {
		if(currentPlayer.getMule() != null) return;
		
		Mule m = new Mule(currentPlayer, CharacterType.MULE);
		m.setType(type);
		this.entities.add(m);
		currentPlayer.setMule(m);
	}
}
