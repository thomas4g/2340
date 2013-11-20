package edu.gatech.mule.screen.controllers.player;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.SettingsView;

/**
 * Controller for player config
 * @version 0.1
 */
public class ColorSelectController extends ScreenController {
	
	protected SettingsView view;
	
	/**
	 * Constructor for player controller
	 * @param game, game engine
	 * @param view, settings view
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

	/**
	 * If all players have finished config, game starts.
	 * Otherwise, next player chooses race and other config.
	 */
	public void done(){
		game.chooseName();
	}
	
}
