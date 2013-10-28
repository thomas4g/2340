package edu.gatech.mule.screen.screens.controllers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.fx.screens.views.FXMapView;
import edu.gatech.mule.game.Entity;
import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.Round;
import edu.gatech.mule.game.Turn;
import edu.gatech.mule.game.map.TileType;
import edu.gatech.mule.screen.screens.views.MapView;

/**
 * Controller for main map screen
 * @version 0.1
 */
public class GameplayController extends ScreenController {

	public final int MOVEMENT = 2;
	public static boolean paused = true;
	
	private MapView view;
	private List<Player> players;
	private Player currentPlayer;
	protected List<Entity> entities;
	
	/**
	 * Constructor for game controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public GameplayController(GameEngine game, MapView view) {
		super(game, view);
		this.view = view;
		this.entities = new ArrayList<Entity>();
	}
	
	@Override
	public void load() {
		super.load();
		view.setGameEntities(entities);
		view.setGameMap(game.getGameMap());
		Thread rounds = new RoundController();
	}
	
	/**
	 * Moves player around the main map
	 */
	public final void move(int x, int y) {
		if(!paused) {
			if(null == players) {
				players = game.getSettings().getPlayers();
				currentPlayer = players.get(0); 
				entities.add(currentPlayer);
				view.setGameEntities(entities);
			}
			x = x == 0 ? 0 : x/Math.abs(x);
			y = y == 0 ? 0 : y/Math.abs(y);
			currentPlayer.move(MOVEMENT*x, MOVEMENT*y);
			currentPlayer.setTile(game.getGameMap());
	
			if(currentPlayer.getTileType().equals(TileType.ENTERTOWN)){
				//Nasty hardcode still but it works until the tiles are being 
				game.enterTown();
				if(currentPlayer.getPosition().getX()>395 && currentPlayer.getPosition().getX()<400){
					currentPlayer.setPosition(new Point(530,180));
				} else {
					currentPlayer.setPosition(new Point(40,180));
				}
				
			
			}	
			((FXMapView)view).render();
		}
	}
	
	@Override
	public void done() {
		this.paused = false;
	}
	
	class RoundController extends Thread {
		
		private int roundNum;
		private Round currentRound;
		
		public RoundController() {
			roundNum = 1;
			currentRound = new Round(game, roundNum);
			this.start();
		}
		
		public void run() {
			paused = true;
			System.out.println("start");
			try {
				for(final Turn turn : currentRound.getTurns()) {
					currentPlayer = turn.getPlayer();
					java.awt.EventQueue.invokeAndWait(new Runnable() {
						public void run() {
							((FXMapView)view).render();
						}
					});
					paused = true;
					
					while(paused) {
						Thread.sleep(10);
					}
					
					System.out.println("turn start: " + currentPlayer.getName());
//					long time = turn.getLength();
					long time = 10000;
					Thread.sleep(time);
					System.out.println("turn done");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
