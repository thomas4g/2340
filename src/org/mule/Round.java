package org.mule;

import java.util.List;

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
