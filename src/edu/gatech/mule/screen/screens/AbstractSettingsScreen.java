package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.IScreen;

/**
 * Set up for settings screen
 * 
 * @version 1.0
 */
public abstract class AbstractSettingsScreen implements IScreen {

	protected GameEngine engine;
	protected Settings settings;
	
	/**
	 * Constructor for the settings screen
	 * 
	 * @param game, the game engine running the game
	 * @param settings, the game config settings
	 */
	public AbstractSettingsScreen(GameEngine engine, Settings settings) {
		this.engine = engine;
		this.settings = settings;
	}
	
	/**
	 * When game config is done,
	 * transitions to 1st player config for race
	 */
	public void done() {
		engine.chooseRace();
	}

}
