package edu.gatech.mule.game.event.turnevents;

import edu.gatech.mule.game.player.Player;

/**
 * A turn event where a player loses money.
 * @version 1.0
 */
public class AnnaEvent implements TurnEvent {

	private int money;

	@Override
	public void execute(Player player) {
		money = (int)(player.getMoney() * .25);
		player.addMoney(-1 * money);
	}

	@Override
	public String getMessage() {
		return "Anna the Artist from a nearby town,"
				+ " brings her widely sought after art to the town. You spend"
				+ "$ " + money
				+ " after having her paint several selfie-portraits of you.";
	}

}
