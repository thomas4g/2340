package edu.gatech.mule.screen;

import edu.gatech.mule.core.GameEngine;

public abstract class ScreenPresenter {
	
	protected IScreenView iview;
	protected static GameEngine game;
	
	public ScreenPresenter(IScreenView iview) {
		this.iview = iview;
	}
	
	public void init() {
		iview.reset();
	};
	
	public void display() {
		iview.display();
	}
	
	public static void setGame(GameEngine g) {
		game = g;
	}
}
