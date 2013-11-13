package edu.gatech.mule.game.event.turnevents;

import java.util.Random;

import edu.gatech.mule.game.player.Player;

public class WackAMuleEvent implements TurnEvent {

	private Player player;
	
	@Override
	public void execute(Player player) {
		Random rand=new Random();
		player.getLands().remove(rand.nextInt(player.getLands().size()));
		this.player=player;
	}

	@Override
	public String getMessage() {
		return "Aww it looks like "+player.getName()+" was playing Wack-a-Mule and made one of the mules"
				+ "run off!";
	}

	
	
	
}
