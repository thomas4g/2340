package edu.gatech.mule.game.round;

import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.GamblingFormula;
import edu.gatech.mule.game.Mule;
import edu.gatech.mule.game.event.RandomEventFactory;
import edu.gatech.mule.game.event.turnevents.TurnEvent;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

/**
 * A Turn is the period where each player performs his or her actions.
 * @author dengel6
 *
 */

public class Turn implements Serializable {

	private static final long serialVersionUID = -301629855669899017L;
	private Round round;
	private Player player;
	private int length;
	private transient Timer timer;
	private Random rand;
	private GameEngine game;
	private static final int TIME = 1000;

	private static final int NORMAL_TURN = 50;
	private static final int HUNGRY_TURN = 30;
	private static final int STARVING_TURN = 5;

	/**
	 * Turn Constructor.
	 * @param round round
	 * @param player player
	 * @param engine engine
	 */

	public Turn(Round round, Player player, GameEngine engine) {
		this.round = round;
		this.player = player;
		this.player.setCurrentTurn(this);
		this.rand = new Random();
		this.game = engine;
		genTurnLength();
	}

	/**
	 * Starts the turn.
	 */

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
		}, 0, TIME);
	}

	/**
	 * Return current player.
	 * @return current player
	 */

	public Player getPlayer() {
		return player;
	}

	/**
	 * Return turn length.
	 * @return turn length
	 */

	public int getLength() {
		return length;
	}

	/**
	 * Gets the turn length based on player resources.
	 */
	public void genTurnLength() {
		int playerFood = player.getResourceAmt(ResourceType.FOOD);
		int foodReq = round.getFoodReq();
		if(playerFood == 0) {
			this.length = STARVING_TURN;
		} else if(playerFood < foodReq) {
			this.length = HUNGRY_TURN;
		} else if(playerFood >= foodReq) {
			this.length = NORMAL_TURN;
		}
	}

	/**
	 * Called after the turn is finished.
	 */

	public void done() {
		int gainedMoney = GamblingFormula.gamble(round.getNum(), length);
		player.addMoney(gainedMoney);
		timer.cancel();

		if (rand.nextInt(2) % 2 == 0) {
			TurnEvent event = RandomEventFactory.createTurnEvent();
			event.execute(player);
			game.setMessage(event.getMessage());
		}
		round.turn();
	}
}
