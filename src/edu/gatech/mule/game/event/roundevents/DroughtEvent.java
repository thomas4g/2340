package edu.gatech.mule.game.event.roundevents;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.event.RoundEvent;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

public class DroughtEvent implements RoundEvent {

	@Override
	public void execute(GameEngine game) {
		for(Player p : game.getPlayers()) {
			int[] resources = new int[ResourceType.values().length];
			resources[ResourceType.FOOD.ordinal()] = p.getResourceAmt(ResourceType.FOOD) / 2;
			p.subtractResources(resources);
		}
	}

	@Override
	public String getMessage() {
		return "A drought has caused all players to lose half of their food!";
	}

	
}
