package edu.gatech.mule.screen.controllers.player;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.SettingsView;

/**
 * Controller for race selection.
 * @version 1.0
 */
public class RaceSelectController extends ScreenController {

	protected SettingsView view;

	/**
	 * Constructor for race select controller.
	 * @param game game engine
	 * @param view settings view
	 */
	public RaceSelectController(GameEngine game, SettingsView view) {
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
		game.chooseColor();
	}
}
