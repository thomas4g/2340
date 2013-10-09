package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;

public abstract class AbstractMenuScreen implements IScreen {

	protected GameEngine engine;
	protected Settings settings;
	
	public AbstractMenuScreen(GameEngine engine, Settings settings) {
		this.engine = engine;
		this.settings = settings;
	}
	
	public void done() {
		engine.playGame();
	}

}
