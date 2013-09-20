package org.mule;

import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class AtariMule {
	public enum ScreenType {WELCOME, MENU, GAMEPLAY, AUCTION, ENDING};
	
	private Graphics graphics;
	private InputListener listener;
	
	private HashMap<ScreenType, Screen> screens;
	private List<Player> players;
	
	public AtariMule() {
		graphics = new Graphics();
		//TODO create a listener here. Pass it the screens. Listener passes back.
		//TODO call player loader. Use the instance variables!
		loadScreens();
	}
	

	//TODO write a player loader method
	
	/**
	 * Loads up the screens. This might simply be a
	 * helper method that loads up a fixed set of screens,
	 * or we may have it pull from somewhere.
	 */
	private void loadScreens() {
		//TODO throw a bunch of singletons in here. Maybe get creative with the enum?
		//I don't know.
	}
	
	/**
	 * runs the application
	 */
	private void run() {
		setScreen(ScreenType.WELCOME);
	}
	
	
	public void setScreen(ScreenType next) {
		Screen current = screens.get(next);
		current.activate();
		listener.setScreen(current);
		graphics.setScreen(current);
	}

}
