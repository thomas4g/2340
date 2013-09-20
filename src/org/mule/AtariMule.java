package org.mule;

import java.util.List;
import java.util.Queue;

public class AtariMule {
	private Graphics graphics;
	private Queue<Screen> screens;
	private List<Player> players;
	
	public AtariMule() {
		graphics = new Graphics();
		//TODO call player loader. Use the instance variables!
		loadScreens();
		
		run();
	}
	

	//TODO write a player loader method
	
	/**
	 * Loads up the screens. This might simply be a
	 * helper method that loads up a fixed set of screens,
	 * or we may have it pull from somewhere.
	 */
	private void loadScreens() {
		screens.add(new Game(players));
	}
	
	/**
	 * runs the application
	 */
	private void run() {
		//setup
		displayScreen();
	}

	/**
	 * Displays the next screen in sequence
	 * This is a little ghetto right now.
	 * It might change. It probably will change.
	 * Like say, what if screens have sub-screens? 
	 * Also, how do you wait for a screen to continue? 
	 * Custom events? 
	 * ...like I said: ghetto.
	 */
	private void displayScreen() {
		Screen current = screens.poll();
		//TODO process screen, wait for it to request the next screen
		screens.add(current);
		displayScreen();
	}
}
