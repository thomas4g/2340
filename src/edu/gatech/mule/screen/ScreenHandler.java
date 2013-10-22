package edu.gatech.mule.screen;

import java.util.HashMap;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.*;
import edu.gatech.mule.screen.screens.controllers.*;
import edu.gatech.mule.screen.screens.views.*;

/**
 * 
 * Screen handler structures for other screen subclasses
 * 
 * @version 1.0
 *
 */
public abstract class ScreenHandler {
	public enum ScreenType { START, SETTINGS, RACE_SELECT, PLAYER_SCREEN, LAND_SELECT, GAME_SCREEN, TOWN_SCREEN };
//	protected HashMap<ScreenType, IScreen> screens;
	protected HashMap<ScreenType, ScreenController> screens;
	protected GameEngine game;
	
	public ScreenHandler(GameEngine game) {
		this.game = game;
//		this.screens = new HashMap<ScreenType, IScreen>();
		this.screens = new HashMap<ScreenType, ScreenController>();
	}
	
	public final void load() {
		screens.put(ScreenType.START, new StartController(game, loadStartView()));
		screens.put(ScreenType.SETTINGS, new SettingsController(game, loadSettingsView()));
		screens.put(ScreenType.RACE_SELECT, new RaceSelectController(game, loadRaceSelectView()));
		screens.put(ScreenType.PLAYER_SCREEN, new PlayerController(game, loadPlayerView()));
		screens.put(ScreenType.LAND_SELECT, new LandSelectController(game, loadLandSelectView()));
		screens.put(ScreenType.GAME_SCREEN, new GameplayController(game, loadGameplayView()));
		screens.put(ScreenType.TOWN_SCREEN, new TownController(game, loadTownView()));
		setScreen(ScreenType.START);
	}

	protected abstract ScreenView loadStartView();
	protected abstract SettingsView loadSettingsView();
	protected abstract SettingsView loadRaceSelectView();
	protected abstract SettingsView loadPlayerView();
	protected abstract MapView loadGameplayView();
	protected abstract MapView loadLandSelectView();
	protected abstract MapView loadTownView();


	public void setScreen(ScreenType type) {
		screens.get(type).load();
	};
		
	
	public abstract void start();
}
