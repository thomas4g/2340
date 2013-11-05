package edu.gatech.mule.screen;

import java.util.HashMap;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.controllers.StartController;
import edu.gatech.mule.screen.screens.controllers.gameplay.GameplayController;
import edu.gatech.mule.screen.screens.controllers.gameplay.LandSelectController;
import edu.gatech.mule.screen.screens.controllers.gameplay.TownController;
import edu.gatech.mule.screen.screens.controllers.player.PlayerController;
import edu.gatech.mule.screen.screens.controllers.player.RaceSelectController;
import edu.gatech.mule.screen.screens.controllers.settings.DifficultyController;
import edu.gatech.mule.screen.screens.controllers.settings.MapTypeController;
import edu.gatech.mule.screen.screens.controllers.settings.NumPlayersController;
import edu.gatech.mule.screen.screens.views.MapView;
import edu.gatech.mule.screen.screens.views.ScreenView;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * Screen handler structures for other screen subclasses
 * @version 1.0
 */
public abstract class ScreenHandler {
	public enum ScreenType { START, DIFFICULTY, MAP_TYPE, NUM_PLAYERS, RACE_SELECT, PLAYER_SCREEN,
							LAND_SELECT, GAME_SCREEN, TOWN_SCREEN };
	protected HashMap<ScreenType, ScreenController> screens;
	protected GameEngine game;
	
	/**
	 * Constructor for screen handler
	 * @param game, game engine screen handler runs in
	 */
	public ScreenHandler(GameEngine game) {
		this.game = game;
		this.screens = new HashMap<ScreenType, ScreenController>();
	}
	
	/**
	 * Loads all screens and sets up start screen
	 */
	public final void load() {
		screens.put(ScreenType.START, new StartController(game, loadStartView()));
		screens.put(ScreenType.DIFFICULTY, new DifficultyController(game, loadDifficultyView()));
		screens.put(ScreenType.MAP_TYPE, new MapTypeController(game, loadMapTypeView()));
		screens.put(ScreenType.NUM_PLAYERS, new NumPlayersController(game, loadNumPlayersView()));
		screens.put(ScreenType.RACE_SELECT, new RaceSelectController(game, loadRaceSelectView()));
		screens.put(ScreenType.PLAYER_SCREEN, new PlayerController(game, loadPlayerView()));
		screens.put(ScreenType.LAND_SELECT, new LandSelectController(game, loadLandSelectView()));
		screens.put(ScreenType.GAME_SCREEN, new GameplayController(game, loadGameplayView()));
		screens.put(ScreenType.TOWN_SCREEN, new TownController(game, loadTownView()));
		setScreen(ScreenType.START);
	}

	protected abstract ScreenView loadStartView();
	protected abstract SettingsView loadDifficultyView();
	protected abstract SettingsView loadMapTypeView();
	protected abstract SettingsView loadNumPlayersView();
	protected abstract SettingsView loadRaceSelectView();
	protected abstract SettingsView loadPlayerView();
	protected abstract MapView loadGameplayView();
	protected abstract MapView loadLandSelectView();
	protected abstract MapView loadTownView();

	/**
	 * Set up screen based on type
	 * @param type, type of screen
	 */
	public void setScreen(ScreenType type) {
		screens.get(type).load();		
	}
		
	public abstract void start();
}
