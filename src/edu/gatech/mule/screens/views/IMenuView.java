package edu.gatech.mule.screens.views;

import edu.gatech.mule.core.GameEngine.DIFFICULTY;
import edu.gatech.mule.screen.*;
import edu.gatech.mule.screens.presenters.MenuPresenter;

public interface IMenuView extends IScreenView{
	public void addDifficulty(DIFFICULTY difficulty);
	public void setPresenter(MenuPresenter presenter);
}
