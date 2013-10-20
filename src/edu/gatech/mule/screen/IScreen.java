package edu.gatech.mule.screen;

/**
 * Provides a contract for a screen, and methods such as completion
 * and display
 */
public interface IScreen  {

	/**
	 * Called upon screen disposal
	 */
	public void dispose();
	
	/**
	 * Called upon screen start
	 */
	public void display();
}
