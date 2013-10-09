package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.IScreen;

abstract class AbstractStartScreen implements IScreen {

	protected GameEngine engine;
	
	public AbstractStartScreen(GameEngine engine) {
		this.engine = engine;
	}
	
	public void done() {
		engine.start();
	}
	
}
