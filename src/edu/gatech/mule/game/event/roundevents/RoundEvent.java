package edu.gatech.mule.game.event.roundevents;

import edu.gatech.mule.core.GameEngine;

public interface RoundEvent {
	
	public void execute(GameEngine game);
	public String getMessage();
}
