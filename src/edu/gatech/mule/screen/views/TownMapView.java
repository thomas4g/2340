package edu.gatech.mule.screen.views;

import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.screen.controllers.gameplay.TownController;

/**
 * Sets up town map view.
 * @version 1.0
 */
public interface TownMapView extends MapView {

	/**
	 * Sets town controller.
	 * @param controller the town controller
	 */
	void setController(TownController controller);

	/**
	 * Displays store menu.
	 */
	void displayStoreMenu();

	/**
	 * Displays menu for modifying store amount.
	 */
	void displayStoreAmountMenu();

	/**
	 * Sets the store resource options.
	 * @param resources types of resources available
	 */
	void setStoreResourceAmounts(int[] resources);

	/**
	 * Displays mule options.
	 */
	void displayMuleOptions();

	/**
	 * Sets up menu for mule options.
	 * @param mules the types of mules available
	 */
	void setMuleOptions(ResourceType[] mules);
}
