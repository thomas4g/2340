package org.mule;

import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class AtariMule {
	
	private Graphics graphicsEngine;
	private GameEngine gameEngine;
	private ScreenHandler handler;
	
	public AtariMule() {
		graphicsEngine = new Graphics();
		gameEngine =new GameEngine();
		handler= new ScreenHandler(new Menu(), graphicsEngine, gameEngine);
		//TODO Init all players
	}
	

	//TODO write a player loader method
	
	/**
	 * Loads up the screens. This might simply be a
	 * helper method that loads up a fixed set of screens,
	 * or we may have it pull from somewhere.
	 */
	public void update(){
		handler.handleInput();
		handler.paint();
	}
	
}
