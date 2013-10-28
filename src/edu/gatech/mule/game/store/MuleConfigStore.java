package edu.gatech.mule.game.store;

import edu.gatech.mule.game.Player;

/**
 * Representation of a store that can config a MULE
 * @version 0.1
 */
public abstract class MuleConfigStore extends Store {
    
    public abstract void exchange(Player player);
    
}
