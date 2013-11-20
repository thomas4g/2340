package edu.gatech.mule.screen.controllers.settings;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.SettingsView;

/**
 * Controller for map type config.
 * @version 1.0
 */
public class MapTypeController extends ScreenController {

	protected SettingsView view;

	/**
	 * Constructor for map type config controller.
	 * @param game game engine
	 * @param view settings view
	 */
	public MapTypeController(GameEngine game, SettingsView view) {
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
		game.chooseNumPlayers();
	}

}
