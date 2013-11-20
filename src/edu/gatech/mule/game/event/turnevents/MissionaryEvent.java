package edu.gatech.mule.game.event.turnevents;

import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

/**
 * A turn event where ???
 * @author Susanna Dong
 *
 */
public class MissionaryEvent implements TurnEvent {

private int energy;

	@Override
	public void execute(Player player) {
		int[] resources = new int[ResourceType.values().length];
		energy = (int) (player.getResourceAmt(ResourceType.ENERGY) * .25);
		resources[ResourceType.ENERGY.ordinal()] = energy;
		player.addResources(resources);
	}

	@Override
	public String getMessage() {
		return "Missionaries from the north have traveled"
				+ " to the wilderness to spread the news of equality"
				+ " among the mules and the other civilized races. Pro.";
	}

}
