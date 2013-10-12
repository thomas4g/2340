package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

public abstract class AbstractPlayerScreen implements IScreen {

	protected GameEngine game;
	protected Settings settings;
	
	public AbstractPlayerScreen(GameEngine game) {
		this.game = game;
		this.settings = game.getSettings();
	}
	
	public void nextPlayer(){
		game.disposeScreen(ScreenType.PLAYER_SCREEN);
		game.chooseRace();
	}
	
	public void done(){
		game.playGame();
	}
	
	
}
