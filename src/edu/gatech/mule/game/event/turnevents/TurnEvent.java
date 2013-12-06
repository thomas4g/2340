package edu.gatech.mule.game.event.turnevents;

import edu.gatech.mule.game.player.Player;

/**
 * Set up for turn events.
 * @version 1.0
 */
public interface TurnEvent {

	double QUARTER = 0.25;

	/**
	 * Affects player.
	 * @param player player to be affected
	 */
	void execute(Player player);

	/**
	 * Returns string of message.
	 * @return string of message
	 */
	String getMessage();
}
