package edu.gatech.mule.game;

import java.awt.Point;

import edu.gatech.mule.game.CharacterType.Direction;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import javafx.scene.image.Image;

public abstract class Entity {

	protected Image image;
	protected Point location;
	protected Direction currentDir;
	protected GameTile currentTile;
	
	public Entity(String imgPath,Point location,GameTile tile){
		image=new Image(imgPath);
		this.location=location;
		this.currentTile=tile;
		currentDir=Direction.DOWN;
	}
	
	public void move(int deltaX,int deltaY){
		location.x+=deltaX;
		location.y+=deltaY;
	}
	
	public void setDirection(Direction dir){
		currentDir=dir;
	}
	
	public void setCurrentTile(GameMap map){
		int xTilePos=(int)(location.getX()/map.getTileWidth());
		int yTilePos=(int)(location.getY()/map.getTileHeight());
		currentTile=map.getTile(xTilePos, yTilePos);
	}
	
	public GameTile getCurrentTile(){
		return currentTile;
	}
	
	public Image getImage(){
		return image;
	}
	
	public Point getPosition(){
		return location;
	}
}
