package edu.gatech.mule.game.event.roundevents;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

public class QueenEvent implements RoundEvent {

	@Override
	public void execute(GameEngine game) {
		int[] resources = new int[ResourceType.values().length];
		resources[ResourceType.FOOD.ordinal()] = 2;
		for(Player p : game.getPlayers()) {
			p.addResources(resources);
		}
	}

	@Override
	public String getMessage() {
		return "Queen Aurrurga visits the town. Everyone gains 2 food.";
	}

}
