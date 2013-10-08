package edu.gatech.mule.screens.views.text;

import edu.gatech.mule.core.GameEngine.DIFFICULTY;
import edu.gatech.mule.screens.views.IMenuView;

public class TextMenuView implements IMenuView {

	private String[] difficultyOptions;
	
	@Override
	public void display() {
		System.out.println("Welcome to the menu!");
		System.out.println("Here are your difficulty options:");
		for(int i=0;i<difficultyOptions.length;i++) {
			System.out.println(i + ".  " + difficultyOptions[i]);
		}
	}

	@Override
	public void setDifficulties(DIFFICULTY[] difficultyOptions) {
		this.difficultyOptions = new String[difficultyOptions.length];
		for(int i=0;i<difficultyOptions.length;i++) {
			this.difficultyOptions[i] = difficultyOptions[i].name();
		}
	}

}
