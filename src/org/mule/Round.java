package org.mule;

import java.util.List;
import java.util.Queue;

/**
 * Round keeps track of order of players' turns.
 * 
 * @author Thomas Shields
 * @version 1.0
 */
public class Round extends Screen {
	private Queue<Turn> turns;
	
	/**
	 * Creates a round
	 * @param the players
	 */
	public Round(AtariMule game, List<Player> players) {
		super(game);
		for(Player p : players) {
			turns.add(new Turn(p));
		}
	}
	
	public void run() {
		//run through turns
		game.setScreen(AtariMule.ScreenType.AUCTION);
	}
	

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}
}
