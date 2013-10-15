package edu.gatech.mule.screen;

import edu.gatech.mule.core.GameEngine;

/**
 * Screen handler structure for other screen subclasses
 * 
 * @version 1.0
 */
public abstract class ScreenHandler {
	public enum ScreenType {START, SETTINGS, RACE_SELECT, PLAYER_SCREEN, GAME_SCREEN};
	
	/**
	 * Sets the screen into a specific type
	 * 
	 * @param type, type of screen
	 */
	public abstract void setScreen(ScreenType type);
	
	/**
	 * Loads based on game engine
	 * 
	 * @param g, the game engine
	 */
	public abstract void load(GameEngine g);
	
	/**
	 * When called, begins to run
	 */
	public abstract void start();
}
