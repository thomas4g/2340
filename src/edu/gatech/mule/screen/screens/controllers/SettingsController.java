package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.views.ScreenView;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * Controller for settings config
 * @version 0.1
 */
public class SettingsController extends ScreenController {

	protected SettingsView view;
	
	/**
	 * Constructor for settings controller
	 * @param game, game engine
	 * @param view, map view
	 */
	public SettingsController(GameEngine game, SettingsView view) {
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
