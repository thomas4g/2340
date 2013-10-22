package edu.gatech.mule.game;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import tiled.core.Tile;
import edu.gatech.mule.game.CharacterType.Direction;
import edu.gatech.mule.game.Settings.Color;
import edu.gatech.mule.game.map.*;
import edu.gatech.mule.game.map.tiles.PropertyTile;

/**
 * 
 * Representation of a player in the game
 * Specifications of the player in the game depends on character type
 * 
 *
 */
public class Player extends Entity {
	
	private BufferedImage headshot;
	private BufferedImage totem;
	
	private CharacterType type;
	private Color color;
	private String name;
	private GameTile currentTile;
	private ArrayList<GameTile> ownedLands;
	
	/**
	 * Constructor for player based on player type
	 * 
	 * @param type, the character type of the player
	 */
	public Player(CharacterType type) {
		super(type.getStillSprite(Direction.RIGHT), new Point(0,0),null);
		this.type = type;
		this.ownedLands=new ArrayList<>();
		//TODO: make this better
		
		setDirectionalFrames();
	}
	
	@Override
	public void setDirection(Direction direction) {
		super.setDirection(direction);
		setDirectionalFrames();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}
	
	public CharacterType getType() {
		return type;
	}
	
	public void setStillSprite(){
		image = loadImage(type.getStillSprite(direction));
	}
	
	public void setDirectionalFrames(){
		setFrames(type.getDirectionalSprites(direction));
	}
	
	public void addLand(GameTile tile){
		ownedLands.add(tile);
		tile.setOwner(this);
	}
	
	public ArrayList<GameTile> getLands(){
		return ownedLands;
	}
	
<<<<<<< HEAD
	
=======
	public BufferedImage getTotem() {
		if(this.totem == null) {
			this.totem = loadImage(type.getTotem(color.ordinal()+1));
		}
		return this.totem;
	}
>>>>>>> cef9e7d4758acab23773465a7f384e905bd8173b
	public BufferedImage getHeadshot() {
		if(this.headshot == null) {
			this.headshot = loadImage(type.getHeadshot(color.ordinal()+1));
		}
		return this.headshot;
	}
}
