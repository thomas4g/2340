package edu.gatech.mule.game.event;

import edu.gatech.mule.core.GameEngine;

public interface RoundEvent {
	
	public void execute(GameEngine game);
}
