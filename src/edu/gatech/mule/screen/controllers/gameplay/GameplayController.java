package edu.gatech.mule.screen.controllers.gameplay;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.CharacterType.Direction;
import edu.gatech.mule.map.tiles.GameTile;
import edu.gatech.mule.map.tiles.PropertyTile;
import edu.gatech.mule.map.tiles.TileType;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;
import edu.gatech.mule.screen.views.MapView;

/**
 * Controller for main map screen.
 * @version 0.1
 */
public class GameplayController extends MapController {

	public static final int MOVEMENT = 5;
	private Timer timer;
	private static final int TIMER_TICK = 10;

	/**
	 * Constructor for game controller.
	 * @param game game engine
	 * @param view map view
	 */
	public GameplayController(GameEngine game, MapView view) {
		super(game, view, MOVEMENT);
	}

	@Override
	public void move(int x, int y) {
		super.move(x, y);

		if(currentPlayer.getTileType() == TileType.ENTERTOWN) {
			game.setScreen(ScreenType.TOWN_SCREEN);
		}
	}

	/**
	 * Hit when enter key is pressed.
	 */
	public void action() {
		GameTile tile = currentPlayer.getTile();

		if (currentPlayer.hasMule()) {
			if (tile.hasOwner()
					&& tile.getOwner() == currentPlayer
					&& tile instanceof PropertyTile) {

				((PropertyTile) tile).addMule(mule);
				currentPlayer.addPlacedMule(mule);
				mule.emplace(tile);

				entities.remove(mule);
			} else {
				mule.setDirection(Direction.LEFT);
				timer = new Timer(true);
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						if(!mule.outOfBounds()) {
							mule.sweetFreedom();
						} else {
							timer.cancel();
							entities.remove(mule);
							mule = null;
						}
					}
				}, 0, TIMER_TICK);
			}
			currentPlayer.setMule(null);
		}
	}

	@Override
	public void load() {
		this.map = game.getGameMap();
		super.load();
		currentPlayer.useBigSprites(false);

		Point p = new Point(0, 0);
		Point m = new Point(0, 0);
		switch(currentPlayer.getDirection()) {
		case DOWN:
			p.x = (int) map.getTileWidth() / 2;
			p.y = (int) map.getHeight() * map.getTileHeight() / 2 + map.getTileHeight() / 2;
			m.x = p.x;
			m.y = p.y - currentPlayer.getImage().getHeight();
			break;
		case LEFT:
			p.y = (int) map.getHeight() * map.getTileHeight() / 2;
			p.x = (int) map.getWidth() * map.getTileWidth() / 2 - map.getTileWidth() / 2;
			m.x = p.x + currentPlayer.getImage().getWidth();
			m.y = p.y;
			break;
		case RIGHT:
			p.y = (int) map.getHeight() * map.getTileHeight() / 2;
			p.x = (int) map.getWidth() * map.getTileWidth() / 2 + map.getTileWidth() / 2;
			m.x = p.x - currentPlayer.getImage().getWidth();
			m.y = p.y;
			break;
		case UP:
			p.y = (int) map.getHeight() * map.getTileHeight() / 2 - map.getTileHeight() / 2;
			p.x = (int) map.getWidth() * map.getTileWidth() / 2;
			m.x = p.x;
			m.y = p.y + currentPlayer.getImage().getHeight();
			break;
		default:
			break;
		}

		currentPlayer.setPosition(p);
		if(currentPlayer.getMule() != null) {
			currentPlayer.getMule().setPosition(new Point(m.x, m.y));
		}
	}
}
