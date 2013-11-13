package edu.gatech.mule.game.event;

import edu.gatech.mule.game.player.Player;

public interface TurnEvent {

	public void execute(Player player);
}
