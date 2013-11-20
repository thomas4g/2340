package edu.gatech.mule.game.event.roundevents;

import edu.gatech.mule.core.GameEngine;

/**
 * Set up for round event.
 * @version 1.0
 */
public interface RoundEvent {

	/**
	 * Affects game.
	 * @param game the game engine
	 */
	void execute(GameEngine game);

	/**
	 * Returns the message of the event.
	 * @return the message of the event
	 */
	String getMessage();

}
