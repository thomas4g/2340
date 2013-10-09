package edu.gatech.mule.screen;

import java.util.HashMap;

import edu.gatech.mule.core.GameEngine;

public abstract class ScreenHandler {
	public enum ScreenType {START, MENU};
	public abstract void setScreen(ScreenType type);
	public abstract void load(GameEngine g);
	public abstract void start();
}
