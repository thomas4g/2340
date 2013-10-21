package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.ScreenView;

public class RaceSelectController extends ScreenController{

	public RaceSelectController(GameEngine game, ScreenView view){
		super(game, view);
	}
	
	public Settings getSettings() {
		return game.getSettings();
	}
	
	@Override
	public void dispose(){
		game.choosePlayer();
	}
	
}
