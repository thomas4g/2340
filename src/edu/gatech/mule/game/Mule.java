package edu.gatech.mule.game;

import java.awt.Point;

import edu.gatech.mule.game.CharacterType.Direction;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.resources.ResourceType;


public class Mule extends Entity {

	public CharacterType type;
	public GameTile tile;
	public boolean placed;
	private Player owner;
	private ResourceType resourceType;
	private boolean big;
	
	public Mule(Player owner, CharacterType type) {
		super(type.getStillSprite(owner.getDirection()),owner.getPosition());
		this.type = type;
		this.owner = owner;
	}
	
	public void move(Player player){
		
		switch(player.getDirection()){
			case DOWN:
				location.x=player.getPosition().x;
				location.y=player.getPosition().y-2*player.getImage().getHeight();
				break;
			case RIGHT:
				location.x=player.getPosition().x-2*player.getImage().getWidth();
				location.y=player.getPosition().y;
				break;
			case LEFT:
				location.x=player.getPosition().x+2*player.getImage().getWidth();
				location.y=player.getPosition().y;
				break;
			case UP:
				location.x=player.getPosition().x;
				location.y=player.getPosition().y+2*player.getImage().getHeight();
				break;
		
		}
		setDirection(player.getDirection());
		
	}
	
	public void setDirection(Direction direction) {
		super.setDirection(direction);
		setDirectionalFrames();
	}
	
	public void setDirectionalFrames(){
		setFrames(type.getDirectionalSprites(direction, big));
	}
	
	public ResourceType getType() {
		return resourceType;
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
		switch(resourceType) {
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
