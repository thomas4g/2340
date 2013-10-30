package edu.gatech.mule.game.resources;

public enum ResourceType {
    
    FOOD (0), 
    ENERGY (1), 
    SMITHORE (2), 
    CRYSTITE (3), 
    MULE (4);
    
    private int index;
    
    private ResourceType(int index) {
    	this.index = index;
    }
    
    public int getIndex() {
    	return index;
    }

}
