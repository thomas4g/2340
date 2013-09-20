package org.mule;

import java.awt.Point;
import java.util.List;

/**
 * A player represents the user in the game.
 * 
 * A player can buy and sell resources, move around the map,
 * and earn or lose money.
 * 
 * @author Susanna Dong
 * @version 1.0
 */
public class Player extends Drawable {
	private double money;
	private List<Property> properties;
	private Point location;
	private Tile currentTile;
	private Tile[][] map;
	private Mule mule;
	
	/**
	 * Creates a player
	 * @param map the game map
	 */
	public Player(Tile[][] map) {
		this.map = map;
	}
	
	/**
	 * reaps the benefits from all the properties
	 */
	public void reap() {
		for(Property prop : properties) {
			prop.produce();
		}
	}
	
	/**
	 * Moves the player on the map.
	 * TODO figure out what tile player is on
	 * @param x distance to move in x dimension
	 * @param y distance to move in y dimension
	 */
	public void move(int x, int y) {
		location.x += x;
		location.y += y;
		currentTile = map[location.x][location.y];
	}
	
	/**
	 * Called when the action key is pressed.
	 * Simply runs the action on the current map
	 */
	public void action() {
		currentTile.action(this);
	}
	
	/**
	 * Checks if the player has a mule to deploy
	 * @return whether or not the player has a mule
	 */
	public boolean hasMule() {
		return mule != null;
	}
	
	/**
	 * deploys the mule back to a property that asks for it
	 * also removes mule from player
	 * @return the player's mule
	 */
	public Mule deployMule() {
		Mule toReturn = mule;
		mule = null;
		return toReturn;
	}
}
