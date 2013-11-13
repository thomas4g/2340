package edu.gatech.mule.game.round;

import java.io.Serializable;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.Player;

public class RoundController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4187045980634695454L;

	public GameEngine getGame() {
		return game;
	}

	public void setGame(GameEngine game) {
		this.game = game;
	}

	private Player currentPlayer;
	private GameEngine game;
	private int roundNumber;
	private int rounds;
	private Round currentRound;
	
	public RoundController(GameEngine game, int rounds) {
		this.game = game;
		this.rounds = rounds;
		this.roundNumber = 1;
	}
	
	public void round() {
		if(roundNumber <= rounds) {
			currentRound = new Round(game, this, roundNumber++);
			currentRound.start();
		}
		else {
			game.end();
		}
	}
	
	public Round getRound() {
		return currentRound;
	}
	
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
}
