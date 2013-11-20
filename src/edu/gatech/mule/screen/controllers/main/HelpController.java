package edu.gatech.mule.screen.controllers.main;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.ScreenView;

/**
 * The controller for the help view.
 * @author tshields
 *
 */
public class HelpController extends ScreenController {

	protected ScreenView view;

	/**
	 * Creates a controller for a help view.
	 * @param game the game engine
	 * @param view the corresponding view
	 */
	public HelpController(GameEngine game, ScreenView view) {
		super(game, view);
		this.view = view;
	}

	@Override
	public void done() {
		game.persistence();
	}

}
