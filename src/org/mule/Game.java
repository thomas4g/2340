package org.mule;

import java.util.List;

/**
 * Game controller
 * 
 * @author Susanna Dong
 * @version 1.0
 */
public class Game {
	private static int rounds = 12;
	private List<Player> players;
	
	//TODO write a map loader method
	//TODO write a player loader method
	
	public void run() {
		for(int i=0;i<rounds;i++) {
			Round r = new Round(players);
			r.run();
		}
	}
}
