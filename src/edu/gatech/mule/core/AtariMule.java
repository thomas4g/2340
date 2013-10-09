package edu.gatech.mule.core;

import edu.gatech.mule.fx.*;

public class AtariMule {
	public static void main(String... args) {
		System.out.println("hi");
		GameEngine game = new GameEngine(new FXScreenHandler());
//		game.chooseSettings();
	}
}
