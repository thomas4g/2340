package edu.gatech.mule.game;

import edu.gatech.mule.game.resources.ResourceType;

public class Turn {

	private Round round;
	private Player player;
	private long length;
	
	public Turn(Round round, Player player) {
		this.round = round;
		this.player = player;
		genTurnLength();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public long getLength() {
		return length;
	}
	
	public void genTurnLength() {
		int playerFood = player.getResourceAmt(ResourceType.FOOD);
		int foodReq = round.getFoodReq();
		if(playerFood == 0) {
			this.length = 5000L;
		} else if(playerFood < foodReq) {
			this.length = 30000L;
		} else if(playerFood >= foodReq) {
			this.length = 50000L;
		}
	}
}
