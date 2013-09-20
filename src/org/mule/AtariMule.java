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
		//TODO set Graphics screen to MenuScreen
		//TODO Init all players
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
		//Performs logic to call setScreen() aka gamelogic loop
	}
	
	/**
	 * runs the application
	 */
	private void start(){
		setScreen(ScreenType.WELCOME);
	}
	
	//Adjustment to Screen simplifies this
	public void setScreen(ScreenType next) {
		Screen current = screens.get(next);
		current.activate();
	}

}
