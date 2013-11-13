package edu.gatech.mule.game.event.turnevents;

import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

public class MinstrelEvent implements TurnEvent {

	int energy;
	
	@Override
	public void execute(Player player) {
		int[] resources=new int[ResourceType.values().length];
		energy=(int)(player.getResourceAmt(ResourceType.ENERGY)*.25);
		resources[ResourceType.ENERGY.ordinal()]=energy;
		player.addResources(resources);
	}

	@Override
	public String getMessage() {
		return "Daniel, the Minstrel makes some noise, sings some tunes, and does a dance. This brings"
				+ "joy and "+energy+" energy to you";
	}
	
	

}
