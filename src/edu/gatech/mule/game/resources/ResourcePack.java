package edu.gatech.mule.game.resources;

/**
 * Representation of the resources
 * @version 0.1
 */
public abstract class ResourcePack {
    
    protected int[] resources;
    
    public ResourcePack() {
        resources = new int[]{-1,-1,-1,-1};
    }
    
    protected int getResourceIndex(ResourceType resource) {
        int index = -1;
        switch(resource) {
        case FOOD:
            index = 0;
            break;
        case ENERGY:
            index = 1;
            break;
        case SMITHORE:
            index = 2;
            break;
        }
        return index;
    }
    
    public int getResource(ResourceType resource) {
        return resources[getResourceIndex(resource)];
    }
    
    public boolean setResource(ResourceType resource, boolean isPurchasing) {
        int index = getResourceIndex(resource);
        
        if(isPurchasing) {
           resources[index] += 1;
        } else {
           resources[index] -= 1;
           if(resources[index] < 0) {
               resources[index] += 1;
               return false;
           }
        }
        return true;
    }
    
    public String toString() {
        String aString = "";
        for(int i=0; i<resources.length; i++) {
            if(resources[i]>-1) {
                aString += resources[i]+"\t";
            }
        }
        return aString;
    }

}
