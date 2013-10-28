package edu.gatech.mule.game.store;

import edu.gatech.mule.game.resources.ResourceType;

public class FoodConfigStore extends MuleConfigStore {
    
    public FoodConfigStore() {
        super(ResourceType.FOOD,125);
    }

}
