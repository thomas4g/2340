package edu.gatech.mule.screen.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.views.ScreenView;

/**
 * Controller of screens
 * @version 0.1
 */
public abstract class ScreenController {
	protected ScreenView view;
	protected GameEngine game;
	
	/**
	 * Constructor for screen controller based on game engine and screen view
	 * @param game, game engine
	 * @param view, screen view
	 */
	public ScreenController(GameEngine game, ScreenView view) {
		this.game = game;
		this.view = view;
	}
	
	/**
	 * Loads itself ???
	 */
	public void load() {
		view.setController(this);		
	}
	
	public abstract void done();
	
	/**
	 * Get the screen view???
	 * @return screen view
	 */
	public ScreenView getView() {
		return view;
	}

	public void move(int i, int j) {}

	//Method to be implemented when the user selects enter
	public void action() {}

}
