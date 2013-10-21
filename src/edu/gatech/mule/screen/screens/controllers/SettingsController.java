package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.game.Settings.Difficulty;
import edu.gatech.mule.game.Settings.MapType;
import edu.gatech.mule.screen.screens.views.ScreenView;

/**
 * 
 * Set up for settings screen
 * 
 * @version 1.0
 *
 */
public class SettingsController extends ScreenController {

	public SettingsController(GameEngine game, ScreenView view) {
		super(game, view);
	}

	public Settings getSettings() {
		return game.getSettings();
	}
	
	@Override
	public void dispose() {
		game.chooseRace();
	}

}
