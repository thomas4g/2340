package edu.gatech.mule.screen.screens.controllers.main;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.ScreenView;

public class PersistenceController extends ScreenController {
	
	protected ScreenView view;

	public PersistenceController(GameEngine game, ScreenView view) {
		super(game, view);
		this.view = view;
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

}
