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

/**
 * Representation of an entity that can move around a map
 * @version 0.1
 */
public abstract class Entity {

	protected BufferedImage[] frames;
	protected BufferedImage image;
	protected Point location;
	protected Direction direction;
	protected GameTile tile;
	protected int frameIndex;
	
	/**
	 * Constructor for an entity
	 * @param imgPath, the image of the entity
	 * @param location, location on a map
	 * @param tile, the tile where the entity is positioned
	 */
	public Entity(String imgPath,Point location,GameTile tile){
		frameIndex=0;
		this.location = location;
		this.tile = tile;
		this.direction = Direction.DOWN;
		this.image = loadImage(imgPath);
	}
	
	/**
	 * Moving the entity based on velocity
	 * @param deltaX, horizontal direction and rate of movement
	 * @param deltaY, vertical direction and rate of movement
	 */
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
	
	/**
	 * Set the direction the entity is facing
	 * @param dir, direction the entity is facing
	 */
	public void setDirection(Direction dir){
		direction = dir;
	}
	
	/**
	 * Get the direction the entity is facing
	 * @return the direction the entity is facing
	 */
	public Direction getDirection() {
		return direction;
	}
	
	/**
	 * Set the tile of the map based on the location of the entity
	 * @param map, the map the entity is traversing upon
	 */
	public void setTile(GameMap map){
		int xTilePos=(int)(location.getX()/OrthogonalMapRenderer.TILE_WIDTH);
		int yTilePos=(int)(location.getY()/OrthogonalMapRenderer.TILE_HEIGHT);
		tile=map.getTile(xTilePos, yTilePos);
	}
	
	/**
	 * Get the tile type
	 * @return tile type
	 */
	public TileType getTileType(){
		return tile.getType();
	}
	
	/**
	 * Get the image of the entity
	 * @return image of the entity
	 */
	public BufferedImage getImage(){
		return image;
	}
	
	/**
	 * Set up the frames for animation
	 * @param srcFrames, array of frames for animation
	 */
	public void setFrames(String[] srcFrames){
		frames=new BufferedImage[srcFrames.length];
		for(int i=0;i<frames.length;i++){
			frames[i] = loadImage(srcFrames[i]);
		}
		updateFrame();
	}
	
	/**
	 * Get the position of the entity
	 * @return position of the entity
	 */
	public Point getPosition(){
		return location;
	}
	
	/**
	 * Set the position of the entity
	 * @param pos, position to set entity to
	 */
	public void setPosition(Point pos){
		location=pos;
	}

	/**
	 * Updates the animation frame
	 */
	private void updateFrame(){
		frameIndex=(frameIndex+1)%frames.length;
		System.out.println(frameIndex);
		image=frames[frameIndex];
	}
	
	/**
	 * Load the buffered image
	 * @param src, ???
	 * @return a buffered image
	 */
	protected BufferedImage loadImage(String src) {
		try {
			return ImageIO.read(Entity.class.getResource(src));
		} catch (IOException e) {
			e.printStackTrace();
			return new BufferedImage(0,0,0);
		}
	}
	
}
