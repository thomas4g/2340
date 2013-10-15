package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;

/**
 * Set up for the player screen
 * 
 * @version 1.0
 */
public abstract class AbstractPlayerScreen implements IScreen {

	protected GameEngine engine;
	protected Settings settings;
	public enum Color { PURPLE, BLUE, TEAL, SEAFOAM, GREEN, GOLD, ORANGE, MAROON};
	protected Color currentColor=Color.PURPLE;
	
	/**
	 * Constructor for the player screen
	 * 
	 * @param game, the game engine running the game
	 * @param settings, the game config settings
	 */
	public AbstractPlayerScreen(GameEngine engine, Settings settings) {
		this.engine = engine;
		this.settings = settings;
	}
	
	/**
	 * When player config for one player is done,
	 * transitions to the next player config for race
	 */
	public void nextPlayer(){
		engine.chooseRace();
	}
	
	/**
	 * When player config for all players are done,
	 * transitions to main game
	 */
	public void done(){
		engine.playGame();
	}
	
	
}
