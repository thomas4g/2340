package edu.gatech.mule.game.event.turnevents;

import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

/**
 * A turn event where a player earns energy.
 * @version 1.0
 */
public class MinstrelEvent implements TurnEvent {

	private int energy;

	@Override
	public void execute(Player player) {
		int[] resources = new int[ResourceType.values().length];
		energy = (int) (player.getResourceAmount(ResourceType.ENERGY) * QUARTER);
		resources[ResourceType.ENERGY.ordinal()] = energy;
		player.addResources(resources);
	}

	@Override
	public String getMessage() {
		return "Daniel, the Minstrel makes some noise,"
				+ " sings some tunes, and does a dance. This brings"
				+ " joy and " + energy + " energy to you";
	}

}
