package edu.gatech.mule.game.store;

import edu.gatech.mule.game.Player;

/**
 * Representation of a general store
 * @version 0.1
 */
public abstract class Store {

    public abstract boolean exchange(Player player);
    
    public boolean transaction(Player player, int purchase, int receive) {
        return player.purchase(purchase) && player.receive(receive);
    }
    
}
