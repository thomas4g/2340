package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.IScreen;

public abstract class AbstractSettingsScreen implements IScreen {

	protected GameEngine engine;
	protected Settings settings;
	
	public AbstractSettingsScreen(GameEngine engine, Settings settings) {
		this.engine = engine;
		this.settings = settings;
	}
	
	public void done() {
		engine.chooseRace();
	}

}
