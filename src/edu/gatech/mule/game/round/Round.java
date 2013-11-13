package edu.gatech.mule.game.round;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.gatech.mule.core.GameEngine;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.screen.ScreenHandler.ScreenType;

public class Round {

	private GameEngine game;
	private RoundController roundController;
	private List<Turn> turns;
	private Iterator<Turn> iter;
	private Turn turn;
	private RoundInfo rInfo;
	
	public Round(GameEngine game, RoundController roundController, int roundNumber) {
		this.game = game;
		this.roundController = roundController;	
		this.rInfo = RoundInfo.valueOf("ROUND" + (roundNumber));
		
		createTurns();
		this.iter = turns.iterator();
	}
	
	public void start() {
		game.setScreen(ScreenType.LAND_SELECT);
	}
	
	public void turn() {
		if(iter.hasNext()) {
			turn = iter.next();
			turn.start();
			game.setScreen(ScreenType.GAME_SCREEN);
		}
		else {
			System.out.println("Round Over");
			roundController.round();
		}
	}
	
	/*
	 * Generates the turn order and then creates them.
	 */
	public void createTurns() {
		List<Player> players = game.getPlayers();
		Collections.sort(players);
		
		turns = new ArrayList<>();
		for(Player p : players) {
			turns.add(new Turn(this, p,game));
		}
	}
	
	public int getFoodReq() {
		return rInfo.getFoodReq();
	}
	
	public int getGambleBonus() {
		return rInfo.getGambleBonus();
	}
	
	public List<Turn> getTurns() {
		return this.turns;
	}
	
	public Turn getTurn() {
		return turn;
	}
	
	public int getNum() {
		return rInfo.ordinal() + 1;
	}
}
