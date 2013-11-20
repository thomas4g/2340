package edu.gatech.mule.game.round;

import java.io.Serializable;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

/**
 * Controls the rounds.
 * @author dengel6
 *
 */

public class RoundController implements Serializable {

	private static final long serialVersionUID = -4187045980634695454L;

	/**
	 * Returns current game engine.
	 * @return currentGame
	 */

	public GameEngine getGame() {
		return game;
	}

	/**
	 *Sets the current game engine.
	 * @param game current engine
	 */

	public void setGame(GameEngine game) {
		this.game = game;
	}

	private Player currentPlayer;
	private GameEngine game;
	private int roundNumber;
	private int rounds;
	private Round currentRound;

	/**
	 * Constructor for RoundController.
	 * @param game game engine
	 * @param rounds number of rounds
	 */

	public RoundController(GameEngine game, int rounds) {
		this.game = game;
		this.rounds = rounds;
		this.roundNumber = 1;
	}

	/**
	 * Performs the correct round operations.
	 */

	public void round() {
		game.saveGameFile("gamedata");
		if(roundNumber <= rounds) {
			for(Player p : game.getPlayers()) {
				p.setProductionCoeficients(new double[ResourceType.values().length]);
			}
			currentRound = new Round(game, this, roundNumber++);
			//if not first round, do round event here
			currentRound.start();
		} else {
			game.end();
		}
	}

	/**
	 * Returns the current round.
	 * @return current round
	 */

	public Round getRound() {
		return currentRound;
	}

	/**
	 * Return the current player for this round.
	 * @return current player
	 */

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
}
