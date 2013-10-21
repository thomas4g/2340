package edu.gatech.mule.game;

import java.awt.Point;

import edu.gatech.mule.game.CharacterType.Direction;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import javafx.scene.image.Image;

public abstract class Entity {

	protected Image image;
	protected Point location;
	protected Direction direction;
	protected GameTile tile;
	
	public Entity(String imgPath,Point location,GameTile tile){
		this.image = new Image(imgPath);
		this.location = location;
		this.tile = tile;
		this.direction = Direction.DOWN;
	}
	
	public void move(int deltaX,int deltaY){
		location.x += deltaX;
		location.y += deltaY;
		
		if(deltaX > 0)
			setDirection(Direction.RIGHT);
		else if(deltaX < 0)
			setDirection(Direction.LEFT);
		
		if(deltaY > 0)
			setDirection(Direction.UP);
		else if(deltaY < 0)
			setDirection(Direction.DOWN);
	}
	
	public void setDirection(Direction dir){
		direction = dir;
	}
	public Direction getDirection() {
		return direction;
	}
	
	public void setTile(GameMap map){
		int xTilePos=(int)(location.getX()/map.getTileWidth());
		int yTilePos=(int)(location.getY()/map.getTileHeight());
		tile=map.getTile(xTilePos, yTilePos);
	}
	
	public GameTile getTile(){
		return tile;
	}
	
	public Image getImage(){
		return image;
	}
	
	public Point getPosition(){
		return location;
	}
}
