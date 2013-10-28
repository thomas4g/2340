package edu.gatech.mule.game;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import edu.gatech.mule.game.CharacterType.Direction;
import edu.gatech.mule.game.Settings.Color;
import edu.gatech.mule.game.map.*;
import edu.gatech.mule.game.map.tiles.PropertyTile;
import edu.gatech.mule.game.resources.PlayerResources;
import edu.gatech.mule.game.resources.ResourceType;
import edu.gatech.mule.game.map.GameTile;

/**
 * Representation of a player in the game
 * Specifications of the player in the game depends on character type
 * @version 0.1
 */
public class Player extends Entity {
	
	private BufferedImage headshot;
	private BufferedImage totem;
	
	private CharacterType type;
	private Color color;
	private String name;
	private double money;
	private ArrayList<GameTile> ownedLands;

	private PlayerResources resources;

    private int score;
	private int food;
	
	/**
	 * Constructor for a player
	 * @param type, type of character
	 */
	public Player(CharacterType type) {
		super(type.getStillSprite(Direction.RIGHT), new Point(0,0),null);
		this.type = type;
		this.money = type.getMoney();
		this.ownedLands=new ArrayList<>();
		resources = new PlayerResources();
		//TODO: make this better
		
		setDirectionalFrames();
	}
	
	@Override
	public void setDirection(Direction direction) {
		super.setDirection(direction);
		setDirectionalFrames();
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getFood() {
		return food;
	}
	
	/**
	 * Set the name of the player
	 * @param name, name of player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set the color of the player
	 * @param color, color of player
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Get name of player
	 * @return name of player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get color of player
	 * @return color of player
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Get character type of player
	 * @return character type of player
	 */
	public CharacterType getType() {
		return type;
	}
	
	/**
	 * Set the still sprite
	 */
	public void setStillSprite(){
		image = loadImage(type.getStillSprite(direction));
	}
	
	/**
	 * Set the directional frames ???
	 */
	public void setDirectionalFrames(){
		setFrames(type.getDirectionalSprites(direction));
	}
	
	/**
	 * Add a property to a player's possession
	 * @param tile, tile the player is possessing
	 * @param free, true if land is free, false if need to purchase
	 * @return true if land is in player's possession, false otherwise
	 */
	public boolean addLand(GameTile tile, boolean free){
		if(!free) {
			this.money -= tile.getCost();
			if(this.money < 0) {
				this.money += tile.getCost();
				return false;
			}
		}
		ownedLands.add(tile);
		tile.setOwner(this);
		return true;
	}
	
	/**
	 * Get player's owned lands
	 * @return player's owned lands
	 */
	public ArrayList<GameTile> getLands(){
		return ownedLands;
	}
	
	/**
	 * Get image of totem
	 * @return image of totem
	 */
	public BufferedImage getTotem() {
		if(this.totem == null) {
			this.totem = loadImage(type.getTotem(color.ordinal()+1));
		}
		return this.totem;
	}

	/**
	 * Get image of headshot
	 * @return image of headshot
	 */
	public BufferedImage getHeadshot() {
		if(this.headshot == null) {
			this.headshot = loadImage(type.getHeadshot(color.ordinal()+1));
		}
		return this.headshot;
	}
	
	
	@Override
	public String toString() {
		return "Name: "+name+" | Money: "+money+
				" | Color: "+color+" | Race: "+type.name();
	}
	
	/////
	
	public boolean canAfford(int purchase) {
        return purchase <= money;
    }
	
	public boolean purchase(int purchase) {
	    if(!canAfford(purchase)) {
	        return false;
	    } else {
	        money -= purchase;
	        return true;
	    }
	}
	
	public boolean receive(int receive) {
	    money += receive;
	    return true;
	}
	
	public boolean resourceExchange(ResourceType resource,
	                                int money,
	                                boolean isPurchasing) {
	    if(isPurchasing) {
	        if(purchase(money)) {
	            resources.setResource(resource, isPurchasing);
	            return true;
	        }
	        return false;
	    } else {
	        receive(money);
	        resources.setResource(resource, isPurchasing);
	        return true;
	    }
	}
	
}
