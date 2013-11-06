package edu.gatech.mule.game;

import java.awt.Point;

import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.game.store.Transactor;

public class Mule extends Entity {

	public ResourceType type;
	public GameTile tile;
	public Transactor owner;
	public boolean placed;
	
	
	public Mule(ResourceType type, Transactor owner,Point location) {
		super("img_path",location);
		this.type = type;
		this.owner = owner;
	}
	
	public ResourceType getType() {
		return type;
	}
	
	public void emplace(GameTile tile) {
		placed = true;
		this.tile = tile;
	}
	
	public void FREEDOM(){
		
		//Run away skipper!
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
		resources[type.getIndex()] = production;
		owner.addResources(resources);
	}
}
