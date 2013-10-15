package edu.gatech.mule.screen;

/**
 * Properties all screens should have
 */
public interface IScreen  {

	/**
	 * When this is called, the current screen's action ends,
	 * and the next action is called
	 */
	public void done();
	
}
