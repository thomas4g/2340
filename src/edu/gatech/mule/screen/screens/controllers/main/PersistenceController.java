package edu.gatech.mule.screen.screens.controllers.main;

import java.io.File;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.PersistenceView;

public class PersistenceController extends ScreenController {
	
	protected PersistenceView view;

	public PersistenceController(GameEngine game, PersistenceView view) {
		super(game, view);
		this.view = view;
	}
	
	@Override
	public void load() {
		view.setController(this);
	}

	@Override
	public void done() {
		boolean awesomeness = true;
		if(awesomeness) {
			System.out.println("making a new game, so let's make the game!");
			game.chooseDifficulty();
		} else if(awesomeness) {
			System.out.println("help if needed");
			game.help();
		}		
	}

	public void done(File file) {
		game.loadGameFile(file);
	}

}
