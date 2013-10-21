package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.views.ScreenView;

public abstract class ScreenController {
	protected ScreenView view;
	protected GameEngine game;
	
	public ScreenController(GameEngine game, ScreenView view) {
		this.game = game;
		this.view = view;
		view.setController(this);
	}
	
	public abstract void dispose();
	
	public ScreenView getView() {
		return view;
	}
}
