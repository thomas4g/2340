package org.mule;

import java.awt.Point;

/**
 * Abstract class for all objects that will be
 * represented by graphics
 * 
 * @author Thomas Shields
 * @version 1.0
 */
public abstract class Drawable {
	protected Point coords;
	protected ImageAsset asset;
	
	public void draw(){
		//implement actual draw here (will figure out when we actually
		//get into the coding
		//drawing will vary depending on if this is a Texture or Sprite
	}
}
