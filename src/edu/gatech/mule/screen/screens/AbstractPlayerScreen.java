package edu.gatech.mule.screen.screens;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.IScreen;

public abstract class AbstractPlayerScreen implements IScreen {

	protected GameEngine engine;
	protected Settings settings;
	public enum Color { PURPLE, BLUE, TEAL, SEAFOAM, GREEN, GOLD, ORANGE, MARROON};
	protected Color currentColor=Color.PURPLE;
	public AbstractPlayerScreen(GameEngine engine, Settings settings) {
		this.engine = engine;
		this.settings = settings;
	}
	
	
	public void nextPlayer(){
		engine.chooseRace();
	}
	
	public void done(){
		engine.playGame();
	}
	
	
}
