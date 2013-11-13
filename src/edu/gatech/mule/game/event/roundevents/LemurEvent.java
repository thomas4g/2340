package edu.gatech.mule.game.event.roundevents;

import java.util.Arrays;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

public class LemurEvent implements RoundEvent {

	@Override
	public void execute(GameEngine game) {
		double[] pc = new double[ResourceType.values().length];
		Arrays.fill(pc, 2);
		for(Player p : game.getPlayers()) {
			p.setProductionCoeficients(pc);
		}
	}

	@Override
	public String getMessage() {
		return "Lemurs have taught you how to move it. All production increased by 50%";
	}

}
