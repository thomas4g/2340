package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.Settings;
import edu.gatech.mule.screen.screens.views.ScreenView;
import edu.gatech.mule.screen.screens.views.SettingsView;

public class RaceSelectController extends ScreenController{

	protected SettingsView view;
		
	public RaceSelectController(GameEngine game, SettingsView view){
		super(game, view);
		this.view = view;
	}
	
	@Override
	public void load() {
		super.load();
		view.setSettings(game.getSettings());
	}
	
	@Override
	public void dispose(){
		game.choosePlayer();
	}
	
}
