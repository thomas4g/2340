package edu.gatech.mule.screen.controllers.main;

import java.io.File;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.PersistenceView;

/**
 * Creates a controller for the new/load/help screen.
 * @author tshields
 *
 */
public class PersistenceController extends ScreenController {

	protected PersistenceView view;

	/**
	 * Creates it yo.
	 * @param game the game engine
	 * @param view the corresponding view
	 */
	public PersistenceController(GameEngine game, PersistenceView view) {
		super(game, view);
		this.view = view;
	}

	@Override
	public void load() {
		view.setController(this);
	}

	/**
	 * Switches to the help screen.
	 */
	public void help() {
		game.help();
	}

	/**
	 * New Game.
	 */
	@Override
	public void done() {
		game.chooseDifficulty();
	}

	/**
	 * Loads a saved game.
	 * @param file the saved game file
	 */
	public void done(File file) {
		game.loadGameFile(file);
	}

}
