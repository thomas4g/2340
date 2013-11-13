package edu.gatech.mule.game.event.turnevents;

import java.util.Random;

import edu.gatech.mule.game.player.Player;

public interface TurnEvent {
	
	public void execute(Player player);
	public String getMessage();
}
