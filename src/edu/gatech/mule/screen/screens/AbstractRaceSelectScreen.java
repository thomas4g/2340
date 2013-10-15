package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;

/**
 * Set up for the race select screen
 * 
 * @version 1.0
 */
public abstract class AbstractRaceSelectScreen implements IScreen {

	protected GameEngine engine;
	protected Settings settings;
	
	/**
	 * Constructor for the race select screen
	 * 
	 * @param game, the game engine running the game
	 * @param settings, the game config settings
	 */
	public AbstractRaceSelectScreen(GameEngine engine,Settings settings){
		this.engine=engine;
		this.settings=settings;
	}
	
	/**
	 * When race is selected, player config is initiated
	 */
	public void done(){
		engine.choosePlayer();
	}
	
}
