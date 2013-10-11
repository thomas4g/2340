package edu.gatech.mule.screen;

import edu.gatech.mule.core.GameEngine;

public abstract class ScreenHandler {
	public enum ScreenType {START, SETTINGS, RACE_SELECT, PLAYER_SCREEN, GAME_SCREEN};
	public abstract void setScreen(ScreenType type);
	public abstract void load(GameEngine g);
	public abstract void start();
}
