package edu.gatech.mule.game.round;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

/**
 * The Round that cycles each player's turn.
 * @author dengel6
 *
 */

public class Round implements Serializable {

	private static final long serialVersionUID = -6250527181695602273L;
	private GameEngine game;
	private RoundController roundController;
	private List<Turn> turns;
	private transient Iterator<Turn> iter;
	private Turn turn;
	private RoundInfo rInfo;

	/**
	 * Round constructor.
	 * @param game game engine
	 * @param roundController round controller
	 * @param roundNumber current round number
	 */
	public Round(GameEngine game, RoundController roundController, int roundNumber) {
		this.game = game;
		this.roundController = roundController;
		this.rInfo = RoundInfo.valueOf("ROUND" + (roundNumber));
		createTurns();
		this.iter = turns.iterator();
	}

	/**
	 * Starts the round.
	 */

	public void start() {
		game.setScreen(ScreenType.LAND_SELECT);
	}

	/**
	 * Called to change to the next turn.
	 */

	public void turn() {
		if(iter.hasNext()) {
			turn = iter.next();
			turn.start();
			game.setScreen(ScreenType.GAME_SCREEN);
		} else {
			System.out.println("Round Over");
			roundController.round();
		}
	}

	/**
	 * Generates the turn order and then creates them.
	 */
	public void createTurns() {
		List<Player> players = game.getPlayers();
		Collections.sort(players);

		turns = new ArrayList<>();
		for(Player p : players) {
			turns.add(new Turn(this, p, game));
		}
	}

	/**
	 * Returns required food.
	 * @return required food
	 */

	public int getFoodReq() {
		return rInfo.getFoodReq();
	}

	/**
	 * Returns gambling bonus based on time left.
	 * @return gambleBonus
	 */

	public int getGambleBonus() {
		return rInfo.getGambleBonus();
	}

	/**
	 *  Returns a list of turns.
	 * @return turns
	 */

	public List<Turn> getTurns() {
		return this.turns;
	}

	/**
	 * Returns current turn.
	 * @return currentTurn
	 */

	public Turn getTurn() {
		return turn;
	}

	/**
	 * Returns round number.
	 * @return roundNumber
	 */

	public int getNum() {
		return rInfo.ordinal() + 1;
	}
}
