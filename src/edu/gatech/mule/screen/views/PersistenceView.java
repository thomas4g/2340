package edu.gatech.mule.screen.views;

import edu.gatech.mule.screen.controllers.main.PersistenceController;

/**
 * Set up for persistence view.
 * @version 1.0
 */
public interface PersistenceView extends SettingsView {

	/**
	 * Sets the persistence controller.
	 * @param c the persistence controller
	 */
	void setController(PersistenceController c);

}
