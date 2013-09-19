package org.mule;


public class Turn {
	private Player player;
	
	public Turn(Player p) {
		player = p;
	}
	
	public void run() {
//		Timer t = new Timer();
		//player moves, stuff happens
		//on timer end: reap the rewards:
		player.reap();
	}
}
