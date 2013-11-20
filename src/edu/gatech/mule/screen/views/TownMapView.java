package edu.gatech.mule.screen.views;

import java.util.List;

import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.screen.controllers.gameplay.TownController;


public interface TownMapView extends MapView {
	public void setController(TownController controller);
	public void displayStoreMenu();
	public void displayStoreAmountMenu(boolean buying);
	public void setStoreResourceAmounts(int[] resources);
	public void displayMuleOptions();
	void setMuleOptions(ResourceType[] mules);
}
