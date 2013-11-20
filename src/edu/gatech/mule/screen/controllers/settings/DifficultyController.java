package edu.gatech.mule.screen.controllers.settings;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.SettingsView;

/**
 * Controller for game difficulty settings.
 * @version 1.0
 */
public class DifficultyController extends ScreenController {

	protected SettingsView view;

	/**
	 * Constructor for difficulty config controller.
	 * @param game game engine
	 * @param view settings view
	 */
	public DifficultyController(GameEngine game, SettingsView view) {
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
		game.chooseMapType();
	}

}
