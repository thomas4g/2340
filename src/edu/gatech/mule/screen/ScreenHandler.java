package edu.gatech.mule.screen;

import edu.gatech.mule.core.GameEngine;

/**
 * 
 * Screen handler structures for other screen subclasses
 * 
 * @version 1.0
 *
 */
public abstract class ScreenHandler {
	public enum ScreenType { START, SETTINGS, RACE_SELECT, PLAYER_SCREEN, GAME_SCREEN };
	
	/**
	 * 
	 * ???
	 * 
	 * @param type
	 * 
	 */
	public abstract void setScreen(ScreenType type);
	
	/**
	 * 
	 * ???
	 * 
	 * @param g
	 * 
	 */
	public abstract void load(GameEngine g);
	
	public abstract void disposeScreen(ScreenType type);
	
	/**
	 * ???
	 */
	public abstract void start();
}
