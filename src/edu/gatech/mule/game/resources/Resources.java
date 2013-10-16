package edu.gatech.mule.game.resources;

/**
 * Keeps count of the number of resources
 * 
 * @version 0.1
 */
public abstract class Resources {
	
	private int[] resourceHolder;
	
	/**
	 * Constructor for resource holder
	 */
	public Resources() {
		resourceHolder = new int[4];
	}
	
	/*
	 * Since resources is only counted by the number,
	 * you might as well keep an array of numbers
	 * keeping track of how many resources each
	 * 
	 * See the PlayerResources and StoreResources
	 * for more info on what each array should keep
	 * track off.
	 */
	
}
