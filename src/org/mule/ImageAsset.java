package org.mule;

import java.awt.Point;

public abstract class ImageAsset {

	protected int width;
	protected int height;
	
	public ImageAsset(int width,int height) {
		this.width=width;
		this.height=height;
	}
	
	public abstract void draw(Point position);

}
