package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.ScreenView;

public class PlayerController extends ScreenController {

	public PlayerController(GameEngine game, ScreenView view) {
		super(game,  view);
	}
	
	public Settings getSettings() {
		return game.getSettings();
	}
	
	public void nextPlayer(){
		game.getSettings().nextPlayer();
		if(game.getSettings().playersLoaded()) dispose();
		else game.chooseRace();
	}
	
	public void dispose(){
		game.playGame();
	}
	
	
}
