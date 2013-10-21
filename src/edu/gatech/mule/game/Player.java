package edu.gatech.mule.game;

import java.awt.Point;

import javafx.scene.image.Image;
import edu.gatech.mule.game.CharacterType.Direction;
import edu.gatech.mule.game.Settings.Color;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;

/**
 * 
 * Representation of a player in the game
 * Specifications of the player in the game depends on character type
 * 
 *
 */
public class Player extends Entity {
	
	private CharacterType type;
	private Color color;
	private String name;
	private GameTile currentTile;
	

	
	/**
	 * Constructor for player based on player type
	 * 
	 * @param type, the character type of the player
	 */
	public Player(CharacterType type) {
		//Add color later
		super(type.getStillSprite(Direction.RIGHT), new Point(0,0),null);
		this.type = type;
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
		stillFrame=new Image(type.getStillSprite(currentDir));
	}
	
	public void setDirectionalFrames(){
		setFrames(type.getDirectionalSprites(currentDir));
	}
	
}
