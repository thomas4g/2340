package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class PlayerController extends ScreenController {
	
	protected SettingsView view;
	
	public PlayerController(GameEngine game, SettingsView view) {
		super(game,  view);
		this.view = view;
	}
	
	@Override
	public void load() {
		super.load();
		view.setSettings(game.getSettings());
	}

	public void done(){
		if(game.getSettings().getPlayerCount() == game.getSettings().getPlayers().size()) {
			game.playGame();
		} else {
			game.chooseRace();
		}
	}
	
	
}
