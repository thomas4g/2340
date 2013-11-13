package edu.gatech.mule.game.event.roundevents;

import edu.gatech.mule.core.GameEngine;

public class StampedeEvent implements RoundEvent {

	@Override
	public void execute(GameEngine game) {
		// lose mule
	}

	@Override
	public String getMessage() {
		return "A stampede of wildebeests have scared away one of your mules!";
	}

}
