package edu.gatech.mule.game.event.roundevents;

import edu.gatech.mule.core.GameEngine;

public class MysteryManEvent implements RoundEvent {

	@Override
	public void execute(GameEngine game) {
		//needs store ref
	}

	@Override
	public String getMessage() {
		return "A mysterious traveling man has sold food to the store!";
	}

}
