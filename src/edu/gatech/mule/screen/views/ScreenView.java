package edu.gatech.mule.screen.views;

import edu.gatech.mule.screen.controllers.ScreenController;

/**
 * Set up for screen view.
 * @version 1.0
 */
public interface ScreenView {

	/**
	 * Sets up general screen controller.
	 * @param c the screen controller
	 */
	void setController(ScreenController c);

}
