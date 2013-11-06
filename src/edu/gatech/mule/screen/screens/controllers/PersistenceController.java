package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.views.ScreenView;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class PersistenceController extends ScreenController {
	
	protected ScreenView view;

	public PersistenceController(GameEngine game, ScreenView view) {
		super(game, view);
		this.view = view;
	}

	@Override
	public void done() {
		System.out.println("go to difficulty");
		game.chooseDifficulty();
	}

}
