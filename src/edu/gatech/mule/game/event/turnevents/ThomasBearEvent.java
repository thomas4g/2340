package edu.gatech.mule.game.event.turnevents;

import edu.gatech.mule.game.player.Player;

/**
 * A random event where a player loses money
 * @version 1.0
 */
public class ThomasBearEvent implements TurnEvent {

	private int money;
	
	@Override
	public void execute(Player player) {
		money = (int)(-1*player.getMoney() * .25);
		player.addMoney(money);
	}

	@Override
	public String getMessage() {
		return "Thomas the overbearing bear just walked up to you,"
				+ " and took $" + money + " from you";
	}

}
