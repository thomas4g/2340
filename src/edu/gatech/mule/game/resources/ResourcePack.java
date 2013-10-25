package edu.gatech.mule.game.resources;

/**
 * Representation of the resources
 * @version 0.1
 */
public abstract class ResourcePack {
    
    protected int[] resources;
    
    public ResourcePack() {
        resources = new int[4];
    }
    
    public int getFood() {
        return resources[0];
    }
    
    public int getEnergy() {
        return resources[1];
    }
    
    public int getSmithore() {
        return resources[2];
    }

}
