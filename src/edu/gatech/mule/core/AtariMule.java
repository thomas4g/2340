package edu.gatech.mule.core;

import edu.gatech.mule.screen.ScreenHandler;

public class AtariMule {
	public static void main(String... args) {
		GameEngine game = new GameEngine(new ScreenHandler());
		game.start();
	}
}
