package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;

public abstract class AbstractGameScreen implements IScreen {

	protected GameEngine game;
	protected Settings settings;
	
	public AbstractGameScreen(GameEngine game){
		this.game = game;
		this.settings = game.getSettings();
	}
	
	public void done() {
		
	}
	
	//TODO add all the map stuff here later
	
}
