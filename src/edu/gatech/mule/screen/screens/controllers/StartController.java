package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.views.ScreenView;

public class StartController extends ScreenController {

	public StartController(GameEngine game, ScreenView view) {
		super(game, view);
	}
	
	public final void done() {
		game.chooseSettings();
	}
	
}
