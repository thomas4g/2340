package edu.gatech.mule.game.store;

import edu.gatech.mule.game.Player;
import edu.gatech.mule.game.resources.ResourceType;

/**
 * Representation of a store that can config a MULE
 * @version 0.1
 */
public abstract class MuleConfigStore extends Store {
    
    protected ResourceType resource;
    protected int cost;
    
    public MuleConfigStore(ResourceType resource, int cost) {
        this.resource = resource;
        this.cost = cost;
    }
    
    public boolean exchange(Player player) {
        if(player.resourceExchange(resource, cost, true)) {
            return true;
        }
        return false;
    }
        
}
