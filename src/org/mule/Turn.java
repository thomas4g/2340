package org.mule;

/**
 * Turn represents a player's turn, allowing the player to purchase MULEs,
 * purchase property, and alter property to generate resources.  Random events
 * can also occur at the beginning of a player's turn.
 * 
 * @author Susanna Dong
 * @version 1.0
 */
public class Turn {
	private Player player;
	
	public Turn(Player p) {
		player = p;
	}
	
	public void run() {
//		Timer t = new Timer();
		//player moves, stuff happens
		//on timer end: reap the rewards:
		player.reap();
	}
}
