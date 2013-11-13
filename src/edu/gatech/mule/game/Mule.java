package edu.gatech.mule.game;

import java.util.Random;

import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.player.CharacterType;
import edu.gatech.mule.game.player.Color;
import edu.gatech.mule.game.player.CharacterType.Direction;
import edu.gatech.mule.game.player.Player;
import edu.gatech.mule.game.resources.ResourceType;


public class Mule extends Entity {

	public CharacterType type;
	public GameTile tile;
	public boolean placed;
	private Player owner;
	private ResourceType resourceType;
	private boolean big;
	private boolean enslaved;
	private Random rand;
	
	public Mule(Player owner, CharacterType type) {
		super(type.getStillSprite(owner.getDirection(), Color.PURPLE),owner.getPosition());
		this.type = type;
		this.owner = owner;
		this.enslaved=true;
		rand=new Random();
		//Determine color based on resource
		color=Color.BLUE;
	}
	
	public void move(){
		
		switch(owner.getDirection()){
			case DOWN:
				location.setLocation(
						owner.getPosition().getX(),
						owner.getPosition().getY() - 2*owner.getImage().getHeight());
				break;
			case RIGHT:
				location.setLocation(
						owner.getPosition().getX() - 2*owner.getImage().getWidth(),
						owner.getPosition().getY());
				break;
			case LEFT:
				location.setLocation(
						owner.getPosition().getX() + 2*owner.getImage().getWidth(),
						owner.getPosition().getY());
				break;
			case UP:
				location.setLocation(
						owner.getPosition().getX(),
						owner.getPosition().getY() + 2*owner.getImage().getHeight());
				break;
			
			default:
				break;
		
		}
		setDirection(owner.getDirection());
		
	}
	
	public void setDirection(Direction direction) {
		super.setDirection(direction);
		setDirectionalFrames();
	}
	
	public void useBigSprites(boolean big) {
		this.big = big;
		setDirectionalFrames();
	}
	
	public void setDirectionalFrames(){
		setFrames(type.getDirectionalSprites(direction, big, color));
	}
	
	
	public ResourceType getType() {
		return resourceType;
	}
	
	public void emplace(GameTile tile) {
		placed = true;
		this.tile = tile;
	}
	
	public void run(int x,int y){
		location.x+=x;
		location.y+=y;
	}
	
	public void sweetFreedom(){
		run(-1*rand.nextInt(5),-1*rand.nextInt(5));
	}
	
	public boolean outOfBounds(){
		if(location.x<0 || location.y<0) return true;
		return false;
	}
	
	public void emancipate(){
		enslaved=false;
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

	public void setType(ResourceType type) {
		resourceType = type;
	}
}
