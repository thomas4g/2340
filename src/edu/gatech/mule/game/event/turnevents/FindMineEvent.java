package edu.gatech.mule.game.event.turnevents;

import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

/**
 * A turn event where a player earns energy and smithore.
 * @version 1.0
 */
public class FindMineEvent implements TurnEvent {

	private int smithore;
	private int energy;

	@Override
	public void execute(Player player) {
		int[] resources = new int[ResourceType.values().length];
		smithore = (int) (player.getResourceAmt(ResourceType.SMITHORE) * .25);
		energy = (int) (player.getResourceAmt(ResourceType.ENERGY) * .25);
		resources[ResourceType.SMITHORE.ordinal()] = smithore;
		resources[ResourceType.ENERGY.ordinal()] = energy;
		player.addResources(resources);

	}

	@Override
	public String getMessage() {
		return "You've found an abandoned mine,"
				+ " and have gained " + smithore
				+ " smithore, and " + energy
				+ " energy.";
	}

}
