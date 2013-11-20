package edu.gatech.mule.game.event.turnevents;

import java.util.Random;

import edu.gatech.mule.game.player.Player;

/**
 * Set up for turn events
 * @version 1.0
 */
public interface TurnEvent {
	
	/**
	 * Affects player
	 * @param player, player to be affected
	 */
	public void execute(Player player);
	
	/**
	 * Returns string of message
	 * @return string of message
	 */
	public String getMessage();
}
