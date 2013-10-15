package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.IScreen;

/**
 * Set up for the start screen
 * 
 * @version 1.0
 */
public abstract class AbstractStartScreen implements IScreen {

	protected GameEngine engine;
	
	/**
	 * Constructor for the start screen
	 * 
	 * @param game, the game engine running the game
	 * @param settings, the game config settings
	 */
	public AbstractStartScreen(GameEngine engine) {
		this.engine = engine;
	}
	
	/**
	 * Ends the start screen and runs game config
	 */
	public void done() {
		engine.chooseSettings();
	}
	
}
