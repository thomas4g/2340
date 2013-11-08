package edu.gatech.mule.screen.screens.controllers.main;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.ScreenView;

/**
 * Controller for start screen
 * @version 0.1
 */
public class StartController extends ScreenController {

	/**
	 * Constructor for start screen
	 * @param game, game engine
	 * @param view, map view
	 */
	public StartController(GameEngine game, ScreenView view) {
		super(game, view);
	}
	
	/**
	 * Goes to settings config
	 */
	public void done() {
		game.persistence();
	}
	
}
