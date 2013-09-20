package org.mule;

/**
 * A slide or deck for information and user interaction
 * Could be the start screen or the main gameplay area
 * @author Thomas Shields
 *
 */
public abstract class Screen {
	protected ImageAsset[] assets;
	protected Graphics handler;
	
	//for each screen, it will need to load its ImageAssets
	public abstract void load();
	
	public void activate(){
		handler.setScreen(this);
	}
}
