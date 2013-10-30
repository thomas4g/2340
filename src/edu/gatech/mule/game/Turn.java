package edu.gatech.mule.game;

import java.util.Timer;
import java.util.TimerTask;

public class Turn {

	private Round round;
	private Player player;
	private int length;
	private Timer timer;
	
	public Turn(Round round, Player player) {
		this.round = round;
		this.player = player;
		this.player.setCurrentTurn(this);
		genTurnLength();
	}
	
	public void start() {
		timer = new Timer(true);
		timer.schedule(new TimerTask() {			
			@Override
			public void run() {
				length -= 1;
				System.out.println(length);
				if(length <= 0) {
					done();
				}
			}
		}, 0, 1000);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getLength() {
		return length;
	}
	
	public void genTurnLength() {
//		int playerFood = player.getResourceAmt(ResourceType.FOOD);
//		int foodReq = round.getFoodReq();
//		if(playerFood == 0) {
//			this.length = 5;
//		} else if(playerFood < foodReq) {
//			this.length = 30;
//		} else if(playerFood >= foodReq) {
//			this.length = 50;
//		}
		this.length = 10;
	}
	
	public void done() {
		timer.cancel();
		round.turn();
	}
}
