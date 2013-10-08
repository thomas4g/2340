package edu.gatech.mule.screens.presenters;

import edu.gatech.mule.core.GameEngine.DIFFICULTY;
import edu.gatech.mule.screen.*;
import edu.gatech.mule.screens.views.IMenuView;

public class MenuPresenter extends ScreenPresenter{
	private IMenuView view;
	
	public MenuPresenter(IMenuView view) {
		super(view);
		this.view = view;
	}


	@Override
	public void init() {
		view.setDifficulties(new DIFFICULTY[]{DIFFICULTY.EASY, DIFFICULTY.HARD});
		display();
	}

}
