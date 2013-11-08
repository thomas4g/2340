package edu.gatech.mule.screen.screens.controllers.settings;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * Controller for settings config
 * @version 0.1
 */
public class NumPlayersController extends ScreenController {

	protected SettingsView view;
	
	/**
	 * Constructor for settings controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public NumPlayersController(GameEngine game, SettingsView view) {
		super(game, view);
		this.view = view;
	}

	/**
	 * Loads game settings
	 */
	@Override
	public void load() {
		super.load();
		view.setSettings(game.getSettings());
	}
	
	/**
	 * Goes to race select screen
	 */
	@Override
	public void done() {
		game.chooseRace();
	}

}
