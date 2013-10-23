package edu.gatech.mule.core;

import edu.gatech.mule.fx.FXScreenHandler;
import edu.gatech.mule.screen.ScreenHandler;

/**
 * Driver for the Atari game M.U.L.E.
 * 
 * @version 0.1
 */
public class AtariMule {
	public static void main(String... args) {
		GameEngine game = new GameEngine();
		ScreenHandler handler = new FXScreenHandler(game);
		game.load(handler);
	}
}
