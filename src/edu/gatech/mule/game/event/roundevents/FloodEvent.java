package edu.gatech.mule.game.event.roundevents;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

/**
 * Round event that reduces ore production by half
 * @version 1.0
 */
public class FloodEvent implements RoundEvent {

	@Override
	public void execute(GameEngine game) {
		for (Player p : game.getPlayers()) {
			double[] pc = p.getProductionCoeficients();
			pc[ResourceType.SMITHORE.ordinal()] = -0.5;
			p.setProductionCoeficients(pc);
		}
	}

	@Override
	public String getMessage() {
		return "Rain has flooded the mines, reducing ore production by half.";
	}

}
