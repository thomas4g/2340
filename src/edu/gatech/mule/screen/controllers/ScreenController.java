package edu.gatech.mule.screen.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.views.ScreenView;

/**
 * Controller of screens.
 * @version 1.0
 */
public abstract class ScreenController {
	protected ScreenView view;
	protected GameEngine game;

	/**
	 * Constructor for screen controller.
	 * @param game game engine
	 * @param view screen view
	 */
	public ScreenController(GameEngine game, ScreenView view) {
		this.game = game;
		this.view = view;
	}

	/**
	 * Loads itself in the view.
	 */
	public void load() {
		view.setController(this);
	}

	/**
	 * Runs this method when screen completes its task.
	 */
	public abstract void done();

	/**
	 * Get the screen view.
	 * @return screen view
	 */
	public ScreenView getView() {
		return view;
	}

	/**
	 * Action so entity moves.
	 * @param i one way
	 * @param j another way
	 */
	public void move(int i, int j) { };

	/**
	 * Action when user presses Enter.
	 */
	public void action() { }

}
