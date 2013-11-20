package edu.gatech.mule.screen.controllers.player;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.SettingsView;

/**
 * Controller for player config.
 * @version 1.0
 */
public class ColorSelectController extends ScreenController {

	protected SettingsView view;

	/**
	 * Constructor for player controller.
	 * @param game game engine
	 * @param view settings view
	 */
	public ColorSelectController(GameEngine game, SettingsView view) {
		super(game,  view);
		this.view = view;
	}

	@Override
	public void load() {
		super.load();
		view.setSettings(game.getSettings());
	}

	@Override
	public void done() {
		game.chooseName();
	}

}
