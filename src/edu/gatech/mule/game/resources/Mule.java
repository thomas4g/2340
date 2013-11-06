package edu.gatech.mule.game.resources;

import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.store.Transactor;

public class Mule {

	public ResourceType type;
	public GameTile tile;
	public Transactor owner;
	public boolean emplaced;
	
	public Mule() {
		emplaced = false;
	}
	
	public Mule(ResourceType type, Transactor owner) {
		this();
		this.type = type;
		this.owner = owner;
	}
	
	public ResourceType getType() {
		return type;
	}
	
	public void emplace(GameTile tile) {
		emplaced = true;
		this.tile = tile;
	}
	
	public void produce() {
		if(tile == null)
			return;
				
		int[] resources = new int[5];
		int production = 0;
		switch(type) {
		case FOOD:
			production = tile.getType().getFoodRate();
			break;
		case ENERGY:
			production = tile.getType().getEnergyRate();
			break;
		case SMITHORE:
			production = tile.getType().getOreRate();
			break;
		default:
			break;
		}
		resources[type.ordinal()] = production;
		owner.addResources(resources);
	}
}
