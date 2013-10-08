package edu.gatech.mule.screens.presenters;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.core.GameEngine.DIFFICULTY;
import edu.gatech.mule.screen.*;
import edu.gatech.mule.screens.views.IMenuView;

public class MenuPresenter extends ScreenPresenter{
	private IMenuView view;
	
	public MenuPresenter(IMenuView view) {
		super(view);
		this.view = view;
		this.view.setPresenter(this);
	}


	@Override
	public void init() {
		view.addDifficulty(DIFFICULTY.EASY);
		view.addDifficulty(DIFFICULTY.HARD);
		display();
	}
	
	public void complete(DIFFICULTY difficulty, int players) {
		game.setDifficulty(difficulty);
		game.configurePlayers(players);
	}

}
