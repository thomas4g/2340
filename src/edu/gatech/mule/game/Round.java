package edu.gatech.mule.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.gatech.mule.core.GameEngine;

public class Round {

	private GameEngine game;
	private List<Turn> turns;
	private RoundInfo rInfo;
	
	public Round(GameEngine game, int roundNum) {
		this.game = game;
		this.rInfo = RoundInfo.valueOf("ROUND" + (roundNum));
		genTurnOrder();
	}
	
	public void genTurnOrder() {
		List<Player> players = game.getPlayers();
		Collections.sort(players, new Comparator<Player>() {
			public int compare(Player a, Player b) {
				int diff = a.getScore() - b.getScore();
				if(diff == 0) {
					return diff;
				} else {
					return diff / Math.abs(diff);
				}
			}
		});
		
		turns = new ArrayList<>();
		for(Player p : players) {
			turns.add(new Turn(this, p));
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
}
