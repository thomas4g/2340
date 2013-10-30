package edu.gatech.mule.game;

import edu.gatech.mule.core.GameEngine;

public class RoundController {

	private Player currentPlayer;
	private GameEngine game;
	private int roundNumber;
	private Round currentRound;
	
	public RoundController(GameEngine game) {
		this.game = game;
		roundNumber = 1;
		currentRound = new Round(game, roundNumber);
	}
	
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
}
