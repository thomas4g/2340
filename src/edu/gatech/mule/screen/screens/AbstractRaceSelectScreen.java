package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;

public abstract class AbstractRaceSelectScreen implements IScreen {

	protected GameEngine game;
	protected Settings settings;
	
	public AbstractRaceSelectScreen(GameEngine game){
		this.game = game;
		this.settings = game.getSettings();
	}
	
	public void done(){
		game.choosePlayer();
	}
	
}
