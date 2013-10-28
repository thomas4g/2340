package edu.gatech.mule.game.resources;

/**
 * Resources that the store holds
 * The store holds a number of food, energy, smithore, and MULES
 * @version 0.1
 */
public class StoreResources extends ResourcePack {

    public StoreResources() {
        super();
    }
    
    public int getMules() {
        return resources[3];
    }
    
}
