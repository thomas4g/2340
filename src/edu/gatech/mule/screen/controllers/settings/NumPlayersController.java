package edu.gatech.mule.screen.controllers.settings;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.SettingsView;

/**
 * Controller for num of players config.
 * @version 1.0
 */
public class NumPlayersController extends ScreenController {

	protected SettingsView view;

	/**
	 * Constructor for settings controller.
	 * @param game game engine
	 * @param view settings view
	 */
	public NumPlayersController(GameEngine game, SettingsView view) {
		super(game, view);
		this.view = view;
	}

	@Override
	public void load() {
		super.load();
		view.setSettings(game.getSettings());
	}

	@Override
	public void done() {
		game.chooseRace();
	}

}
