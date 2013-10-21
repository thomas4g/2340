package edu.gatech.mule.game;

import java.awt.Point;

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
public class Player {
	
	private CharacterType type;
	private Color color;
	private String name;
	private Point position;
	private GameTile currentTile;
	public enum Direction{LEFT,RIGHT,UP,DOWN};
	private Direction currentDirection;
	
	/**
	 * Constructor for player based on player type
	 * 
	 * @param type, the character type of the player
	 */
	public Player(CharacterType type) {
		this.type = type;
		position=new Point(0, 0); //Need to figure out where the character starts by default
		//Need to set a default tile here
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
	
	public void move(int deltaX,int deltaY){
		position.x+=deltaX;
		position.y+=deltaY;
	}
	
	public void setDirection(Direction dir){
		currentDirection=dir;
	}
	
	public void draw(){
		
	}
	
	public void setCurrentTile(GameMap map){
		int xTilePos=(int)(position.getX()/map.getTileWidth());
		int yTilePos=(int)(position.getY()/map.getTileHeight());
		currentTile=map.getTile(xTilePos, yTilePos);
	}
		
	public GameTile getCurrentTile(){
		
		return currentTile;
	}
}
