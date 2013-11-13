package edu.gatech.mule.game.event.roundevents;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.event.RoundEvent;
import edu.gatech.mule.game.player.Player;

public class PantaloonsEvent implements RoundEvent {

	@Override
	public void execute(GameEngine game) {
		for(Player p : game.getPlayers()) {
			p.addMoney(100);
		}
	}

	@Override
	public String getMessage() {
		return "A salesman from Pennington's Pantaloons have bought your pants for 100 dollars.";
	}

}
