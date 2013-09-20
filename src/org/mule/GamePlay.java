package org.mule;

import java.util.List;
import java.util.Queue;

/**
 * Game controller
 * 
 * @author Thomas Shields
 * @version 1.0
 */
public class GamePlay extends Screen {
	public GamePlay(AtariMule game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	private static int numRounds = 12;
	private Queue<Round> rounds;
	private List<Player> players;
	private Tile[][] map;
	
	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}
	
	//TODO write a constructor for game that takes in players and calls the map loader
	//TODO write a map loader method
	
}
