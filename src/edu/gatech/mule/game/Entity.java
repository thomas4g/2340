package edu.gatech.mule.game;

import java.awt.Point;

import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import javafx.scene.image.Image;

public abstract class Entity {

	protected Image image;
	protected Point location;
	public enum Direction{LEFT,RIGHT,UP,DOWN};
	protected Direction currentDir;
	protected GameTile currentTile;
	
	public Entity(Image image,Point location,GameTile tile){
		this.image=image;
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
}
