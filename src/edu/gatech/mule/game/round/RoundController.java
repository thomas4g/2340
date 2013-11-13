package edu.gatech.mule.game.round;

import java.io.Serializable;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;

public class RoundController implements Serializable {
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
			for(Player p : game.getPlayers()) {
				p.setProductionCoeficients(new double[ResourceType.values().length]);
			}
			currentRound = new Round(game, this, roundNumber++);
			//if not first round, do round event here
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
