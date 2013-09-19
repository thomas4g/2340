package org.mule;

import java.util.List;

/**
 * Round keeps track of order of players' turns.
 * 
 * @author Susanna Dong
 * @version 1.0
 */
public class Round {
	private List<Player> players;
	public Round(List<Player> p) {
		players = p;
	}
	public void run() {
		for(Player p : players) {
			Turn t = new Turn(p);
			t.run();
		}
	}
}
