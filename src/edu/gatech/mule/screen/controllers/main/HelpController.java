package edu.gatech.mule.screen.controllers.main;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.controllers.ScreenController;
import edu.gatech.mule.screen.views.ScreenView;

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
