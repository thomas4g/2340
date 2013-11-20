package edu.gatech.mule.screen;

import java.util.HashMap;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.controllers.gameplay.GameplayController;
import edu.gatech.mule.screen.controllers.gameplay.LandSelectController;
import edu.gatech.mule.screen.controllers.gameplay.TownController;
import edu.gatech.mule.screen.controllers.main.HelpController;
import edu.gatech.mule.screen.controllers.main.PersistenceController;
import edu.gatech.mule.screen.controllers.main.StartController;
import edu.gatech.mule.screen.controllers.player.ColorSelectController;
import edu.gatech.mule.screen.controllers.player.NameChooseController;
import edu.gatech.mule.screen.controllers.player.RaceSelectController;
import edu.gatech.mule.screen.controllers.settings.DifficultyController;
import edu.gatech.mule.screen.controllers.settings.MapTypeController;
import edu.gatech.mule.screen.controllers.settings.NumPlayersController;
import edu.gatech.mule.screen.views.MapView;
import edu.gatech.mule.screen.views.PersistenceView;
import edu.gatech.mule.screen.views.ScreenView;
import edu.gatech.mule.screen.views.SettingsView;
import edu.gatech.mule.screen.views.TownMapView;

/**
 * Screen handler structures for other screen subclasses.
 * @version 1.0
 */
public abstract class ScreenHandler {

	/**
	 * Screen types.
	 */
	public enum ScreenType { START, PERSISTENCE, HELP,
                             DIFFICULTY, MAP_TYPE, NUM_PLAYERS,
                             RACE_SELECT, COLOR, NAME,
                             LAND_SELECT, GAME_SCREEN, TOWN_SCREEN };

	protected HashMap<ScreenType, ScreenController> screens;
	protected GameEngine game;

	/**
	 * Constructor for screen handler.
	 * @param game game engine screen handler runs in
	 */
	public ScreenHandler(GameEngine game) {
		this.game = game;
		this.screens = new HashMap<ScreenType, ScreenController>();
	}

	/**
	 * Loads all screens and sets up start screen.
	 */
	public final void load() {
		screens.put(ScreenType.START,
					new StartController(game, loadStartView()));
		screens.put(ScreenType.PERSISTENCE,
					new PersistenceController(game, loadPersistenceView()));
		screens.put(ScreenType.HELP,
					new HelpController(game, loadHelpView()));

		screens.put(ScreenType.DIFFICULTY,
					new DifficultyController(game, loadDifficultyView()));
		screens.put(ScreenType.MAP_TYPE,
					new MapTypeController(game, loadMapTypeView()));
		screens.put(ScreenType.NUM_PLAYERS,
					new NumPlayersController(game, loadNumPlayersView()));

		screens.put(ScreenType.RACE_SELECT,
					new RaceSelectController(game, loadRaceSelectView()));
		screens.put(ScreenType.COLOR,
					new ColorSelectController(game, loadColorView()));
		screens.put(ScreenType.NAME,
					new NameChooseController(game, loadNameView()));

		screens.put(ScreenType.LAND_SELECT,
					new LandSelectController(game, loadLandSelectView()));
		screens.put(ScreenType.GAME_SCREEN,
					new GameplayController(game, loadGameplayView()));
		screens.put(ScreenType.TOWN_SCREEN,
					new TownController(game, loadTownView()));
	}

	/**
	 * Loads view for start screen.
	 * @return view for start screen
	 */
	protected abstract ScreenView loadStartView();

	/**
	 * Loads view for persistence view.
	 * @return view for persistence view
	 */
	protected abstract PersistenceView loadPersistenceView();

	/**
	 * Loads view for help view.
	 * @return view for help view
	 */
	protected abstract ScreenView loadHelpView();

	/**
	 * Loads view for difficulty config screen.
	 * @return view for difficulty config screen
	 */
	protected abstract SettingsView loadDifficultyView();

	/**
	 * Loads view for map type config screen.
	 * @return view for map type config screen
	 */
	protected abstract SettingsView loadMapTypeView();

	/**
	 * Loads view for num players config screen.
	 * @return view for num players config screen
	 */
	protected abstract SettingsView loadNumPlayersView();

	/**
	 * Loads view for player race select.
	 * @return view for player race select
	 */
	protected abstract SettingsView loadRaceSelectView();

	/**
	 * Loads view for player color select.
	 * @return view for player color select.
	 */
	protected abstract SettingsView loadColorView();

	/**
	 * Loads view for player name choosing.
	 * @return view for player name choosing
	 */
	protected abstract SettingsView loadNameView();

	/**
	 * Loads view for main map.
	 * @return view for main map.
	 */
	protected abstract MapView loadGameplayView();

	/**
	 * Loads view for land select map.
	 * @return view for land select map.
	 */
	protected abstract MapView loadLandSelectView();

	/**
	 * Loads view for town map.
	 * @return view for town map
	 */
	protected abstract TownMapView loadTownView();

	/**
	 * Set up screen based on type.
	 * @param type type of screen
	 */
	public void setScreen(ScreenType type) {
		screens.get(type).load();
	}

}
