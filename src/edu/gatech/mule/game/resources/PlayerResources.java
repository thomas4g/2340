package edu.gatech.mule.game.resources;

/**
 * Resources that a player holds
 * A player holds a number of food, energy, smithore, and crystite
 * @version 0.1
 */
public class PlayerResources extends ResourcePack {

    public PlayerResources() {
        super();
    }
    
    public int getCrystite() {
        return resources[3];
    }
    
}
