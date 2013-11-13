package edu.gatech.mule.game.event;

import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

public class StubToeEvent implements TurnEvent {

	private int energyLoss;
	
	@Override
	public void execute(Player player) {
		int[] resources = new int[5];
		energyLoss=(int) (player.getResourceAmt(ResourceType.ENERGY) * .25);
		resources[ResourceType.ENERGY.ordinal()] = energyLoss;
		player.subtractResources(resources);
	}

	@Override
	public String getMessage() {
		return "You stubbed your toe and lost "+energyLoss+" amount of energy";
	}

}
