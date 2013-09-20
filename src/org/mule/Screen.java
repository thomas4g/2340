package org.mule;

/**
 * A slide or deck for information and user interaction
 * Could be the start screen or the main gameplay area
 * @author Thomas Shields
 *
 */
public abstract class Screen {
	protected AtariMule game;
	
	public Screen(AtariMule game) {
		this.game = game;
	}
	
	public abstract void activate();
}
