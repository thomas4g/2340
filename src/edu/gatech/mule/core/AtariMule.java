package edu.gatech.mule.core;

import edu.gatech.mule.fx.*;

public class AtariMule {
	public static void main(String... args) {
		GameEngine game = new GameEngine(new FXScreenHandler());
		game.start();
	}
}
