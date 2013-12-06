package edu.gatech.mule.game.event.turnevents;

import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

/**
 * A turn event where one of the players loses energy.
 * @version 1.0
 */
public class StubToeEvent implements TurnEvent {

	private int energyLoss;

	@Override
	public void execute(Player player) {
		int[] resources = new int[ResourceType.values().length];
		energyLoss = (int) (player.getResourceAmount(ResourceType.ENERGY) * QUARTER);
		resources[ResourceType.ENERGY.ordinal()] = energyLoss;
		player.subtractResources(resources);
	}

	@Override
	public String getMessage() {
		return "You stubbed your toe and lost "
				+ energyLoss
				+ " amount of energy";
	}

}
