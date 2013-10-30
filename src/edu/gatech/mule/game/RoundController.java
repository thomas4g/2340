package edu.gatech.mule.game;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.screen.ScreenHandler;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

public class RoundController {

	private Player currentPlayer;
	private GameEngine game;
	private ScreenHandler screenHandler;
	private int roundNumber;
	private int rounds;
	private Round currentRound;
	
	public RoundController(GameEngine game, ScreenHandler screenHandler, int rounds) {
		this.game = game;
		this.screenHandler = screenHandler;
		this.rounds = rounds;
		this.roundNumber = 1;
	}
	
	public void round() {
		if(roundNumber <= rounds) {
			currentRound = new Round(game, this, roundNumber++, screenHandler);
			currentRound.start();
		}
		else
			game.end();
	}
	
	public Round getRound() {
		return currentRound;
	}
	
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
}
