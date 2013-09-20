package org.mule;

import java.awt.Point;

public class Sprite extends ImageAsset {
	
	private int numFrames;

	public Sprite(int width, int height,int numFrames) {
		super(width, height);
		this.numFrames=numFrames;
	}
	
	public void animate(){
		for(int i=0;i<numFrames;i++){
			//draw each frame with graphics API
		}
	}
}
