package edu.gatech.mule.game.round;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import edu.gatech.mule.game.GamblingFormula;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

public class Turn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -301629855669899017L;
	private Round round;
	private Player player;
	private int length;
	private transient Timer timer;
	
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
		int playerFood = player.getResourceAmt(ResourceType.FOOD);
		int foodReq = round.getFoodReq();
		if(playerFood == 0) {
			this.length = 5;
		} else if(playerFood < foodReq) {
			this.length = 30;
		} else if(playerFood >= foodReq) {
			this.length = 50;
		}
	}
	
	public void done() {
		player.addMoney(GamblingFormula.gamble(round.getNum(), length));
		timer.cancel();
		round.turn();
	}
}
