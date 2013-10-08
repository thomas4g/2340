package edu.gatech.mule.screens.views;

import edu.gatech.mule.core.GameEngine.DIFFICULTY;
import edu.gatech.mule.screen.*;

public interface IMenuView extends IScreenView{
	public void setDifficulties(DIFFICULTY[] difficultyOptions);
	
}
