package edu.gatech.mule.screen.screens.controllers.player;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.screens.controllers.ScreenController;
import edu.gatech.mule.screen.screens.views.SettingsView;

/**
 * Controller for player config
 * @version 0.1
 */
public class PlayerController extends ScreenController {
	
	protected SettingsView view;
	
	/**
	 * Constructor for player controller
	 * @param game, game engine
	 * @param view, settings view
	 */
	public PlayerController(GameEngine game, SettingsView view) {
		super(game,  view);
		this.view = view;
	}
	
	@Override
	public void load() {
		super.load();
		view.setSettings(game.getSettings());
	}

	/**
	 * If all players have finished config, game starts.
	 * Otherwise, next player chooses race and other config.
	 */
	public void done(){
		System.out.println("player count: "+game.getSettings().getPlayerCount());
		System.out.println("number of players: "+game.getSettings().getPlayers().size());
		if(game.getSettings().getPlayerCount() == game.getSettings().getPlayers().size()) {
			game.playGame();
		} else {
			game.chooseRace();
		}
	}
	
}
