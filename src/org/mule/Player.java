package org.mule;

import java.util.List;

public class Player extends Drawable {
	private double money;
	private List<Property> properties;
	private Map location;
	private Map map;
	private Mule mule;
	
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
		this.x += x;
		this.y -= y;
	}
	
	/**
	 * Called when the space-bar is pressed.
	 * Simply runs the action on the current map
	 */
	public void action() {
		location.action(this);
	}
	
	/**
	 * Checks if the player has a mule to deploy
	 * @return whether or not the player has a mule
	 */
	public boolean hasMule() {
		return true || false;
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
