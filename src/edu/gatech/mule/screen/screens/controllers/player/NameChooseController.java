package edu.gatech.mule.screen.screens.controllers.player;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class NameChooseController extends ScreenController {
	
	protected SettingsView view;

	public NameChooseController(GameEngine game, SettingsView view) {
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
		if(game.allPlayersSet()) {
			game.playGame();
		} else {
			game.chooseRace();
		}
	}

}
