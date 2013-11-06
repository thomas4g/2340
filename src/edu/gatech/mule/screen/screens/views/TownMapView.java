package edu.gatech.mule.screen.screens.views;

import edu.gatech.mule.screen.screens.controllers.TownController;

public interface TownMapView extends MapView {
	public void setController(TownController controller);
	public void displayStoreMenu();
	public void displayStoreAmountMenu(boolean buying);
	public void setStoreResourceAmounts(int[] resources);
}
