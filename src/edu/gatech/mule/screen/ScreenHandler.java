package edu.gatech.mule.screen;

import java.util.HashMap;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.*;

/**
 * 
 * Screen handler structures for other screen subclasses
 * 
 * @version 1.0
 *
 */
public abstract class ScreenHandler {
	public enum ScreenType { START, SETTINGS, RACE_SELECT, PLAYER_SCREEN, GAME_SCREEN };
	protected HashMap<ScreenType, IScreen> screens;
	protected GameEngine game;
	
	public ScreenHandler(GameEngine game) {
		this.game = game;
		this.screens = new HashMap<ScreenType, IScreen>();
	}
	
	public final void load() {
		screens.put(ScreenType.START, loadStartScreen());
		screens.put(ScreenType.SETTINGS, loadSettingsScreen());
		screens.put(ScreenType.RACE_SELECT, loadRaceSelectScreen());
		screens.put(ScreenType.PLAYER_SCREEN, loadPlayerScreen());
		screens.put(ScreenType.GAME_SCREEN, loadGameScreen());
		setScreen(ScreenType.START);
	}

	protected abstract AbstractStartScreen loadStartScreen();
	protected abstract AbstractSettingsScreen loadSettingsScreen();
	protected abstract AbstractRaceSelectScreen loadRaceSelectScreen();
	protected abstract AbstractPlayerScreen loadPlayerScreen();
	protected abstract AbstractGameScreen loadGameScreen();


	public void setScreen(ScreenType type) {
		screens.get(type).display();
	};
		
	
	public abstract void start();
}
