package edu.gatech.mule.screen.screens.controllers;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * Controller for race selection
 * @version 0.1
 */
public class RaceSelectController extends ScreenController{

	protected SettingsView view;
	
	/**
	 * Constructor for race select controller
	 * @param game, game engine
	 * @param view, settings view
	 */
	public RaceSelectController(GameEngine game, SettingsView view){
		super(game, view);
		this.view = view;
	}
	
	@Override
	public void load() {
		super.load();
		view.setSettings(game.getSettings());
	}
	
	/**
	 * Goes to player config
	 */
	@Override
	public void done(){
		game.choosePlayer();
	}
	
}
