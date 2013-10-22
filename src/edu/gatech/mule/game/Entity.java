package edu.gatech.mule.game;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.gatech.mule.game.CharacterType.Direction;
import edu.gatech.mule.game.map.GameMap;
import edu.gatech.mule.game.map.GameTile;
import edu.gatech.mule.game.map.TileType;
import edu.gatech.mule.graphics.OrthogonalMapRenderer;

public abstract class Entity {

	protected BufferedImage[] frames;
	protected BufferedImage image;
	protected Point location;
	protected Direction direction;
	protected GameTile tile;
	protected int frameIndex;
	
	public Entity(String imgPath,Point location,GameTile tile){
		frameIndex=0;
		this.location = location;
		this.tile = tile;
		this.direction = Direction.DOWN;
		this.image = loadImage(imgPath);
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
		int xTilePos=(int)(location.getX()/OrthogonalMapRenderer.TILE_WIDTH);
		int yTilePos=(int)(location.getY()/OrthogonalMapRenderer.TILE_HEIGHT);
		tile=map.getTile(xTilePos, yTilePos);
	}
	
	public TileType getTileType(){
		return tile.getType();
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public void setFrames(String[] srcFrames){
		frames=new BufferedImage[srcFrames.length];
		for(int i=0;i<frames.length;i++){
			frames[i] = loadImage(srcFrames[i]);
		}
		updateFrame();
	}
	
	public Point getPosition(){
		return location;
	}

	private void updateFrame(){
		frameIndex=(frameIndex+1)%frames.length;
		System.out.println(frameIndex);
		image=frames[frameIndex];
	}
	
	protected BufferedImage loadImage(String src) {
		try {
			return ImageIO.read(Entity.class.getResource(src));
		} catch (IOException e) {
			e.printStackTrace();
			return new BufferedImage(0,0,0);
		}
	}
	
}
