package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.views.ScreenView;

public class HelpController extends ScreenController {
	
	protected ScreenView view;

	public HelpController(GameEngine game, ScreenView view) {
		super(game, view);
		this.view = view;
	}

	@Override
	public void done() {
		game.persistence();
	}

}
