package org.mule;

import java.util.List;

/**
 * Game controller
 * 
 * @author Thomas Shields
 * @version 1.0
 */
public class Game extends Screen {
	private static int rounds = 12;
	private List<Player> players;
	private Tile[][] map;
	
	//TODO write a constructor for game that takes in players and calls the map loader
	
	//TODO write a map loader method
	
	/**
	 * cycles through all the rounds
	 */
	public void run() {
		for(int i=0;i<rounds;i++) {
			Round r = new Round(players);
			r.run();
		}
	}
}
