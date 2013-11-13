package edu.gatech.mule.screen;

import java.io.Serializable;
import java.util.HashMap;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.controllers.gameplay.GameplayController;
import edu.gatech.mule.screen.screens.controllers.gameplay.LandSelectController;
import edu.gatech.mule.screen.screens.controllers.gameplay.TownController;
import edu.gatech.mule.screen.screens.controllers.main.HelpController;
import edu.gatech.mule.screen.screens.controllers.main.PersistenceController;
import edu.gatech.mule.screen.screens.controllers.main.StartController;
import edu.gatech.mule.screen.screens.controllers.player.ColorSelectController;
import edu.gatech.mule.screen.screens.controllers.player.NameChooseController;
import edu.gatech.mule.screen.screens.controllers.player.RaceSelectController;
import edu.gatech.mule.screen.screens.controllers.settings.DifficultyController;
import edu.gatech.mule.screen.screens.controllers.settings.MapTypeController;
import edu.gatech.mule.screen.screens.controllers.settings.NumPlayersController;
import edu.gatech.mule.screen.screens.views.MapView;
import edu.gatech.mule.screen.screens.views.ScreenView;
import edu.gatech.mule.screen.screens.views.SettingsView;
import edu.gatech.mule.screen.screens.views.TownMapView;

/**
 * Screen handler structures for other screen subclasses
 * @version 1.0
 */
public abstract class ScreenHandler implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6251214685880267487L;

	public enum ScreenType { START, PERSISTENCE, HELP,
							DIFFICULTY, MAP_TYPE, NUM_PLAYERS,
							RACE_SELECT, COLOR, NAME,
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
		screens.put(ScreenType.PERSISTENCE, new PersistenceController(game, loadPersistenceView()));
		screens.put(ScreenType.HELP, new HelpController(game, loadHelpView()));
		
		screens.put(ScreenType.DIFFICULTY, new DifficultyController(game, loadDifficultyView()));
		screens.put(ScreenType.MAP_TYPE, new MapTypeController(game, loadMapTypeView()));
		screens.put(ScreenType.NUM_PLAYERS, new NumPlayersController(game, loadNumPlayersView()));
		
		screens.put(ScreenType.RACE_SELECT, new RaceSelectController(game, loadRaceSelectView()));
		screens.put(ScreenType.COLOR, new ColorSelectController(game, loadColorView()));
		screens.put(ScreenType.NAME, new NameChooseController(game, loadNameView()));
		
		screens.put(ScreenType.LAND_SELECT, new LandSelectController(game, loadLandSelectView()));
		screens.put(ScreenType.GAME_SCREEN, new GameplayController(game, loadGameplayView()));
		screens.put(ScreenType.TOWN_SCREEN, new TownController(game, loadTownView()));
	}

	protected abstract ScreenView loadStartView();
	protected abstract ScreenView loadPersistenceView();
	protected abstract ScreenView loadHelpView();
	
	protected abstract SettingsView loadDifficultyView();
	protected abstract SettingsView loadMapTypeView();
	protected abstract SettingsView loadNumPlayersView();
	
	protected abstract SettingsView loadRaceSelectView();
	protected abstract SettingsView loadColorView();
	protected abstract SettingsView loadNameView();
	
	protected abstract MapView loadGameplayView();
	protected abstract MapView loadLandSelectView();
	protected abstract TownMapView loadTownView();

	/**
	 * Set up screen based on type
	 * @param type, type of screen
	 */
	public void setScreen(ScreenType type) {
		screens.get(type).load();		
	}
		
}
