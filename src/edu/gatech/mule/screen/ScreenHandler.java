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
	public enum ScreenType { START, SETTINGS, RACE_SELECT, PLAYER_SCREEN, GAME_SCREEN };
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
		screens.put(ScreenType.GAME_SCREEN, new GameplayController(game, loadGameplayView()));
		setScreen(ScreenType.START);
	}

	protected abstract ScreenView loadStartView();
	protected abstract ScreenView loadSettingsView();
	protected abstract ScreenView loadRaceSelectView();
	protected abstract ScreenView loadPlayerView();
	protected abstract ScreenView loadGameplayView();


	public abstract void setScreen(ScreenType type);// {
//		screens.get(type).display();
//	};
		
	
	public abstract void start();
}
