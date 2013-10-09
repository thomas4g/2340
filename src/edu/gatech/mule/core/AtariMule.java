package edu.gatech.mule.core;

import edu.gatech.mule.fx.FXScreenHandler;

public class AtariMule {
	public static void main(String... args) {
		GameEngine game = new GameEngine(new FXScreenHandler());
	}
}
