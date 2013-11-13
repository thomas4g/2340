package edu.gatech.mule.game.event;

import edu.gatech.mule.game.player.Player;

public class SwordWomanEvent implements TurnEvent {

	private int money;
	
	@Override
	public void execute(Player player) {
		money=(int)(player.getMoney()*.25);
		player.addMoney(money);
	}

	@Override
	public String getMessage() {
		return "Susanna, the suave swordswoman notices as you try to pickpocket her and challenges you"
				+ "to a duel. She wins, but you manage to run away with $"+money;
	}

}
