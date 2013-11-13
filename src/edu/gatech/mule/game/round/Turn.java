package edu.gatech.mule.game.round;

import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.GamblingFormula;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.event.RandomEventFactory;
import edu.gatech.mule.game.event.TurnEvent;
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
	private Random rand;
	private int coinFlip;
	
	public Turn(Round round, Player player,GameEngine engine) {
		this.round = round;
		this.player = player;
		this.player.setCurrentTurn(this);
		this.rand=new Random();
		genTurnLength();
	}
	
	public void start() {
		//do turnevent here
		for(Mule m : player.getPlacedMules()) {
			m.produce();
		}
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
		
		int coinFlip=rand.nextInt(2);
		if (coinFlip%2==0) {
			TurnEvent event = RandomEventFactory.createTurnEvent();
			event.execute(player);
			System.out.println(event.getMessage());
		}
		round.turn();
	}
}
