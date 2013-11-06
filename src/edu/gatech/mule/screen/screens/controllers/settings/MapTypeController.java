package edu.gatech.mule.screen.screens.controllers.settings;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.ScreenView;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class MapTypeController extends ScreenController {
	
	protected SettingsView view;

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
