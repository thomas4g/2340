package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.views.ScreenView;

public abstract class ScreenController {
	protected ScreenView view;
	protected GameEngine game;
	
	public ScreenController(GameEngine game, ScreenView view) {
		this.game = game;
		this.view = view;
	}
	
	public void load() {
		view.setController(this);		
	}
	
	public abstract void done();
	
	public ScreenView getView() {
		return view;
	}

	public void move(int i, int j) {}

	//Method to be implemented when the user selects enter
	public void action() {}

}
